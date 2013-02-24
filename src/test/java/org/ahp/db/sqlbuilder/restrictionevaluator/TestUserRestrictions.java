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

	List<RestrictionField> mRestrictionFields;
	List<String> mOrderBy;
	List<String> mGroupBy;

	@Before
	public void setup(){
		mRestrictionFields = new ArrayList<RestrictionField>();
		RestrictionField lUserEmailField = new RestrictionField();
		lUserEmailField.setFieldParameters( SearchUserRestrictions.USER_EMAIL );
		lUserEmailField.setFieldInput( "test@example" );

		RestrictionField lAddressIdField = new RestrictionField();
		lAddressIdField.setFieldParameters( SearchUserRestrictions.ADDRESS_ID );
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
