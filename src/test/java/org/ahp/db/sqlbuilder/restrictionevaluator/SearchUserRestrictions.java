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
