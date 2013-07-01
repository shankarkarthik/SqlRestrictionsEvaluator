/**
 * 
 */
package org.ahp.db.sqlbuilder.restrictionevaluator.enums;

import java.util.Map;

import org.ahp.db.sqlbuilder.restrictionevaluator.IRestrictionsEvaluator;
import org.ahp.db.sqlbuilder.restrictionevaluator.RestrictionField;

/**
 * 
 * @author Shankar K. Vaithianathan
 *
 */
public enum Restriction {
	BETWEEN	{
		public String evaluateFieldRestriction( IRestrictionsEvaluator restrictionsEvaluator, RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
			return restrictionsEvaluator.between( restrictionField, namedParametersMap );
		}
	},
	EQ {
		public String evaluateFieldRestriction( IRestrictionsEvaluator restrictionsEvaluator, RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
			return restrictionsEvaluator.eq( restrictionField, namedParametersMap );
		}
	},
	GE {
		public String evaluateFieldRestriction( IRestrictionsEvaluator restrictionsEvaluator, RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
			return restrictionsEvaluator.ge( restrictionField, namedParametersMap );
		}
	},
	GT {
		public String evaluateFieldRestriction( IRestrictionsEvaluator restrictionsEvaluator, RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
			return restrictionsEvaluator.gt( restrictionField, namedParametersMap );
		}
	},
	ID_EQ {
		public String evaluateFieldRestriction( IRestrictionsEvaluator restrictionsEvaluator, RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
			return restrictionsEvaluator.idEq( restrictionField, namedParametersMap );
		}
	},
	ILIKE_ANYWHERE {
		public String evaluateFieldRestriction( IRestrictionsEvaluator restrictionsEvaluator, RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
			return restrictionsEvaluator.ilikeAnywhere( restrictionField, namedParametersMap );
		}
	},		
	ILIKE_END {
		public String evaluateFieldRestriction( IRestrictionsEvaluator restrictionsEvaluator, RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
			return restrictionsEvaluator.ilikeEnd( restrictionField, namedParametersMap );
		}
	},
	ILIKE_EXACT {
		public String evaluateFieldRestriction( IRestrictionsEvaluator restrictionsEvaluator, RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
			return restrictionsEvaluator.ilikeExact( restrictionField, namedParametersMap );
		}
	},
	ILIKE_START {
		public String evaluateFieldRestriction( IRestrictionsEvaluator restrictionsEvaluator, RestrictionField restrictionField, Map<String,Object> namedParametersMap) {
			return restrictionsEvaluator.ilikeStart( restrictionField, namedParametersMap );
		}
	},		
	IN {
		public String evaluateFieldRestriction( IRestrictionsEvaluator restrictionsEvaluator, RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
			return restrictionsEvaluator.in( restrictionField, namedParametersMap );
		}
	},
	IS_NOT_NULL {
		public String evaluateFieldRestriction( IRestrictionsEvaluator restrictionsEvaluator, RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
			return restrictionsEvaluator.isNotNull( restrictionField, namedParametersMap );
		}
	},
	LE {
		public String evaluateFieldRestriction( IRestrictionsEvaluator restrictionsEvaluator, RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
			return restrictionsEvaluator.le( restrictionField, namedParametersMap );
		}
	},
	LIKE_ANYWHERE {
		public String evaluateFieldRestriction( IRestrictionsEvaluator restrictionsEvaluator, RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
			return restrictionsEvaluator.likeAnywhere( restrictionField, namedParametersMap );
		}
	},
	LIKE_END {
		public String evaluateFieldRestriction( IRestrictionsEvaluator restrictionsEvaluator, RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
			return restrictionsEvaluator.likeEnd( restrictionField, namedParametersMap );
		}
	},
	LIKE_EXACT {
		public String evaluateFieldRestriction( IRestrictionsEvaluator restrictionsEvaluator, RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
			return restrictionsEvaluator.likeExact( restrictionField, namedParametersMap );
		}
	},
	LIKE_START {
		public String evaluateFieldRestriction( IRestrictionsEvaluator restrictionsEvaluator, RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
			return restrictionsEvaluator.likeStart( restrictionField, namedParametersMap );
		}
	},
	LT {
		public String evaluateFieldRestriction( IRestrictionsEvaluator restrictionsEvaluator, RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
			return restrictionsEvaluator.lt( restrictionField, namedParametersMap );
		}
	},
	DISJUNCTION {
		public String evaluateFieldRestriction( IRestrictionsEvaluator restrictionsEvaluator, RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
			return restrictionsEvaluator.disjunction( restrictionField, namedParametersMap );
		}
	},
	CONJUNCTION {
		public String evaluateFieldRestriction( IRestrictionsEvaluator restrictionsEvaluator, RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
			return restrictionsEvaluator.conjunction( restrictionField, namedParametersMap );
		}
	},
	NE {
		public String evaluateFieldRestriction( IRestrictionsEvaluator restrictionsEvaluator, RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
			return restrictionsEvaluator.ne( restrictionField, namedParametersMap );
		}
	};
	
	/**
	 * 
	 * @param restrictionsEvaluator
	 * @param restrictionField
	 * @param namedParametersMap
	 * @return
	 */
	public abstract String evaluateFieldRestriction( IRestrictionsEvaluator restrictionsEvaluator, RestrictionField restrictionField, Map<String,Object> namedParametersMap );
}
