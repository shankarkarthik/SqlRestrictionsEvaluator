# SqlRestrictionsEvaluator

A simple, Java API for defining restrictions during a dynamic SQL building.

## Introduction

SqlRestrictionsEvaluator allows you to define your restrictions while building a dynamic SQL without going through the traditional SQL builders using a Simple java Enum definition.
It supports Named Parameter Mapping and avoid SQL injection by allowing to always use Prepared Statements.

## Setup

TO DO: Add as a Maven dependency:

```xml
<dependency>
  <groupId>org.ahp.db.sqlbuilder</groupId>
  <artifactId>sql-restrictions-evaluator</artifactId>
  <version>0.0.1</version>
</dependency>
```

## Usage

* Define your restrictable field parameters as an Enum by implementing IRestrictionFieldParameters interface
* Based on dynamic user inputs create corresponding `RestrictionField`s. 
* Choose the appropriate dialects to evaluate your restrictions and building the SQL query for the desired database. 

## Examples
Tables:
user 
with below columns
user.user_id,user.first_name, user.last_name, user.email
address 
with below columns
address.address_id, address.address1, address.address2, address.city, address.state, address.zip, address.country

Define your restriction fields as an enum

```java
public enum SearchUserRestrictions implements IRestrictionFieldParameters {

	USER_ID( "user.user_id", Restriction.ID_EQ, RestrictionJoinCondition.AND, RestrictionDataType.NUMBER, RestrictionConstructionType.AUTO ),
	ADDRESS_ID( "address.address_id", Restriction.ID_EQ, RestrictionJoinCondition.AND, RestrictionDataType.NUMBER, RestrictionConstructionType.AUTO ),
	USER_FIRST_NAME( "user.first_name", Restriction.ILIKE_ANYWHERE, RestrictionJoinCondition.AND, RestrictionDataType.STRING, RestrictionConstructionType.AUTO ),
	USER_EMAIL( "user.email", Restriction.ILIKE_ANYWHERE, RestrictionJoinCondition.AND, RestrictionDataType.STRING, RestrictionConstructionType.AUTO );

	String restrictableFieldName;
	Restriction restriction;
	RestrictionJoinCondition restrictionJoinCondition;
	RestrictionDataType restrictionDataType;
	RestrictionConstructionType restrictionConstructionType;

	/**
	 *
	 * @param restrictableFieldName
	 * @param restriction
	 * @param restrictionJoinCondition
	 * @param restrictionDataType
	 * @param restrictionConstructionType
	 */
	private SearchUserRestrictions( String restrictableFieldName,
			                        Restriction restriction,
			                        RestrictionJoinCondition restrictionJoinCondition,
			                        RestrictionDataType restrictionDataType,
			                        RestrictionConstructionType restrictionConstructionType ){
		this.restrictableFieldName = restrictableFieldName;
		this.restriction = restriction;
		this.restrictionJoinCondition = restrictionJoinCondition;
		this.restrictionDataType = restrictionDataType;
		this.restrictionConstructionType = restrictionConstructionType;
	}

	public String getRestrictableFieldName(){
		return this.restrictableFieldName;
	}

	public Restriction getRestriction(){
		return this.restriction;
	}
	public RestrictionJoinCondition getRestrictionJoinCondition(){
		return this.restrictionJoinCondition;
	}
	public RestrictionDataType getRestrictionDataType(){
		return this.restrictionDataType;
	}
	public RestrictionConstructionType getRestrictionConstructionType(){
		return this.restrictionConstructionType;
	}
}

```
Build Dynamic Query based on user inputs.

```java
public class TestUserRestrictions {

	private final static Logger LOGGER = Logger.getLogger( TestUserRestrictions.class .getName() );

	List<RestrictionField> restrictionFields;
	List<String> orderBy;
	List<String> groupBy;

	@Before
	public void setup(){
		restrictionFields = new ArrayList<RestrictionField>();
		RestrictionField userEmailField = new RestrictionField();
		userEmailField.setFieldParameters( SearchUserRestrictions.USER_EMAIL );
		userEmailField.setFieldInput( "test@example" );

		RestrictionField addressIdField = new RestrictionField();
		addressIdField.setFieldParameters( SearchUserRestrictions.ADDRESS_ID );
		addressIdField.setId( new Long( 101 ) );
		
		restrictionFields.add( userEmailField );
		restrictionFields.add( addressIdField );

		orderBy = new ArrayList<String>();
		orderBy.add( "user.last_name" );
		orderBy.add( "user.first_name" );
		groupBy = new ArrayList<String>();
		groupBy.add( "user.last_name" );
		groupBy.add( "user.first_name" );
	}

	/**
	 * Note, this test does not assert anything and is written for showcasing the module use.
	 */
	@Test
    public void searchUser() {
		IRestrictionsEvaluator mySqlRestrictionsEvaluator = new MySqlRestrictionsEvaluator();
		StringBuilder dataQuery = new StringBuilder();
		dataQuery.append( " SELECT user.last_name, user.first_name FROM user, address " );
		dataQuery.append( " WHERE (1=1) " );
		Map<String,Object> namedParametersMap = buildWhereRestrictions( dataQuery, restrictionFields, mySqlRestrictionsEvaluator );
		dataQuery.append( mySqlRestrictionsEvaluator.orderBy( orderBy, SortOrder.ASC ) );
		dataQuery.append( mySqlRestrictionsEvaluator.groupBy( groupBy ) );
		dataQuery.append( mySqlRestrictionsEvaluator.limit( 1, 0, 20 ) );
		LOGGER.info( dataQuery.toString() );
		LOGGER.info( namedParametersMap.toString() );
    }

	private Map<String,Object> buildWhereRestrictions( StringBuilder query, List<RestrictionField> restrictionFields, IRestrictionsEvaluator mySqlRestrictionsEvaluator ){
		Map<String,Object> namedParametersMap = new HashMap<String,Object>();
		for ( RestrictionField restrictionField : restrictionFields ) {
			query.append( restrictionField.getFieldParameters().getRestrictionJoinCondition() );
			query.append( restrictionField.getFieldParameters().getRestriction().evaluateFieldRestriction( mySqlRestrictionsEvaluator, restrictionField, namedParametersMap ) );
		}
		return namedParametersMap;
	}

}
```

### SQL Query with Restrictions will be built as below

```java
SELECT 
    user.last_name, user.first_name 
FROM 
    user, 
    address  
WHERE 
    (1=1) 
    AND UPPER(USER_EMAIL) LIKE UPPER(:user.email) 
    AND ADDRESS_ID = :address.address_id  
ORDER BY 
    user.last_name,user.first_name ASC 
GROUP BY user.last_name,user.first_name 
LIMIT 1, 20
```

## License

Shankar K. Vaithianathan - Released under the [Apache 2.0 license](http://www.apache.org/licenses/LICENSE-2.0.html).
