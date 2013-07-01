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
	
	private String conditionOperator;
	
	private RestrictionJoinCondition( String conditionOperator ) {
		this.conditionOperator = conditionOperator;
	}
	
	public String getConditionOperator(){
		return this.conditionOperator;
	}
}