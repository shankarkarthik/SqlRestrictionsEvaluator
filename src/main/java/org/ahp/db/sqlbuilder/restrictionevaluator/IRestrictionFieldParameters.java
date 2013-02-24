package org.ahp.db.sqlbuilder.restrictionevaluator;

import org.ahp.db.sqlbuilder.restrictionevaluator.enums.Restriction;
import org.ahp.db.sqlbuilder.restrictionevaluator.enums.RestrictionConstructionType;
import org.ahp.db.sqlbuilder.restrictionevaluator.enums.RestrictionDataType;
import org.ahp.db.sqlbuilder.restrictionevaluator.enums.RestrictionJoinCondition;

/**
 * @author Shankar K. Vaithianathan
 *
 */
public interface IRestrictionFieldParameters {

	/**
	 * 
	 * @return
	 */
	public RestrictionDataType getRestrictionDataType();
	
	/**
	 * 
	 * @return
	 */
	public RestrictionJoinCondition getRestrictionJoinCondition();
	
	/**
	 * 
	 * @return
	 */
	public RestrictionConstructionType getRestrictionConstructionType();
	
	/**
	 * 
	 * @return
	 */
	public Restriction getRestriction();
	
	/**
	 * 
	 * @return
	 */
	public String getRestrictableFieldName();

}
