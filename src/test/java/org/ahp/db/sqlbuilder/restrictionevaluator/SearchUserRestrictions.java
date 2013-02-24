package org.ahp.db.sqlbuilder.restrictionevaluator;

import org.ahp.db.sqlbuilder.restrictionevaluator.enums.Restriction;
import org.ahp.db.sqlbuilder.restrictionevaluator.enums.RestrictionConstructionType;
import org.ahp.db.sqlbuilder.restrictionevaluator.enums.RestrictionDataType;
import org.ahp.db.sqlbuilder.restrictionevaluator.enums.RestrictionJoinCondition;

/**
 *
 * @author Shankar K. Vaithianathan
 *
 */
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

	/**
	 *
	 * @param pRestrictableFieldName
	 * @param pRestriction
	 * @param pRestrictionJoinCondition
	 * @param pRestrictionDataType
	 * @param pRestrictionConstructionType
	 */
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
}
