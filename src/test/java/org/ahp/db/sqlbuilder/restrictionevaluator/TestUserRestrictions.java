/**
 *
 */
package org.ahp.db.sqlbuilder.restrictionevaluator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.ahp.db.sqlbuilder.restrictionevaluator.dialects.MySqlRestrictionsEvaluator;
import org.ahp.db.sqlbuilder.restrictionevaluator.enums.SortOrder;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Shankar K. Vaithianathan
 *
 */
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
