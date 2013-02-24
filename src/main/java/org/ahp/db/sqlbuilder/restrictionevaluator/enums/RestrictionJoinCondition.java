/**
 * 
 */
package org.ahp.db.sqlbuilder.restrictionevaluator.enums;

/**
 * @author Shankar K. Vaithianathan
 *
 */
public enum RestrictionJoinCondition {
	AND ( " AND " ),
	OR ( " OR " ),
	NOT ( " NOT " );
	
	private String mConditionOperator;
	
	private RestrictionJoinCondition( String pConditionOperator ) {
		this.mConditionOperator = pConditionOperator;
	}
	
	public String getConditionOperator(){
		return this.mConditionOperator;
	}
}