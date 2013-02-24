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
* Based on dynamic user inputs create `RestrictionField`s. 
* Choose the appropriate dialexts to evaluate your restrictions. 

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

	String mRestrictableFieldName;
	Restriction mRestriction;
	RestrictionJoinCondition mRestrictionJoinCondition;
	RestrictionDataType mRestrictionDataType;
	RestrictionConstructionType mRestrictionConstructionType;

	private SearchUserRestrictions( String pRestrictableFieldName,
			                        Restriction pRestriction,
			                        RestrictionJoinCondition pRestrictionJoinCondition,
			                        RestrictionDataType pRestrictionDataType,
			                        RestrictionConstructionType pRestrictionConstructionType ){
		this.mRestrictableFieldName = pRestrictableFieldName;
		this.mRestriction = pRestriction;
		this.mRestrictionJoinCondition = pRestrictionJoinCondition;
		this.mRestrictionDataType = pRestrictionDataType;
		this.mRestrictionConstructionType = pRestrictionConstructionType;
	}

	public String getRestrictableFieldName(){
		return this.mRestrictableFieldName;
	}

	public Restriction getRestriction(){
		return this.mRestriction;
	}
	public RestrictionJoinCondition getRestrictionJoinCondition(){
		return this.mRestrictionJoinCondition;
	}
	public RestrictionDataType getRestrictionDataType(){
		return this.mRestrictionDataType;
	}
	public RestrictionConstructionType getRestrictionConstructionType(){
		return this.mRestrictionConstructionType;
	}
```
Build Dynamic Query based on user inputs.

```java
public class TestUserRestrictions {

    private final static Logger LOGGER = Logger.getLogger( TestUserRestrictions.class .getName() ); 
    
    List<RestrictionField> mRestrictionFields;
    List<String> mOrderBy;
    List<String> mGroupBy;
    
    @Before
    public void setup(){
        mRestrictionFields = new ArrayList<RestrictionField>();
        RestrictionField lUserEmailField = new RestrictionField();
        lUserEmailField.setFieldParameters( UserFieldParameters.USER_EMAIL );
        lUserEmailField.setFieldInput( "test@example" );

        RestrictionField lAddressIdField = new RestrictionField();
        lAddressIdField.setFieldParameters( UserFieldParameters.ADDRESS_ID );
        lAddressIdField.setId( new Long( 101 ) );
        mRestrictionFields.add( lUserEmailField );
        mRestrictionFields.add( lAddressIdField );
        
        mOrderBy = new ArrayList<String>();
        mOrderBy.add( "user.last_name" );
        mOrderBy.add( "user.first_name" );
        mGroupBy = new ArrayList<String>();
        mGroupBy.add( "user.last_name" );
        mGroupBy.add( "user.first_name" );
    }
    
    @Test
    public void searchUser() {      
        IRestrictionsEvaluator lMySqlRestrictionsEvaluator = new MySqlRestrictionsEvaluator();
        StringBuilder lDataQuery = new StringBuilder();
        lDataQuery.append( " SELECT user.last_name, user.first_name FROM user, address " );
        lDataQuery.append( " WHERE (1=1) " );
        Map<String,Object> lNamedParametersMap = buildWhereRestrictions( lDataQuery, mRestrictionFields, lMySqlRestrictionsEvaluator );
        lDataQuery.append( lMySqlRestrictionsEvaluator.orderBy( mOrderBy, SortOrder.ASC ) );
        lDataQuery.append( lMySqlRestrictionsEvaluator.groupBy( mGroupBy ) );
        lDataQuery.append( lMySqlRestrictionsEvaluator.limit( 1, 0, 20 ) );
        LOGGER.info( lDataQuery.toString() );
        LOGGER.info( lNamedParametersMap.toString() );
    }

    private Map<String,Object> buildWhereRestrictions( StringBuilder pQuery, List<RestrictionField> pRestrictionFields, IRestrictionsEvaluator pMySqlRestrictionsEvaluator ){
        Map<String,Object> lNamedParametersMap = new HashMap<String,Object>();
        for ( RestrictionField lRestrictionField : pRestrictionFields ) {
            pQuery.append( lRestrictionField.getFieldParameters().getRestrictionJoinCondition() );
            pQuery.append( lRestrictionField.getFieldParameters().getRestriction().evaluateFieldRestriction( pMySqlRestrictionsEvaluator, lRestrictionField, lNamedParametersMap ) );
        }
        return lNamedParametersMap;
    }

}
```

### SQL with Restrictions is built as below

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
