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
		public String evaluateFieldRestriction( IRestrictionsEvaluator pRestrictionsEvaluator, RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
			return pRestrictionsEvaluator.between( pRestrictionField, pNamedParametersMap );
		}
	},
	EQ {
		public String evaluateFieldRestriction( IRestrictionsEvaluator pRestrictionsEvaluator, RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
			return pRestrictionsEvaluator.eq( pRestrictionField, pNamedParametersMap );
		}
	},
	GE {
		public String evaluateFieldRestriction( IRestrictionsEvaluator pRestrictionsEvaluator, RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
			return pRestrictionsEvaluator.ge( pRestrictionField, pNamedParametersMap );
		}
	},
	GT {
		public String evaluateFieldRestriction( IRestrictionsEvaluator pRestrictionsEvaluator, RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
			return pRestrictionsEvaluator.gt( pRestrictionField, pNamedParametersMap );
		}
	},
	ID_EQ {
		public String evaluateFieldRestriction( IRestrictionsEvaluator pRestrictionsEvaluator, RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
			return pRestrictionsEvaluator.idEq( pRestrictionField, pNamedParametersMap );
		}
	},
	ILIKE_ANYWHERE {
		public String evaluateFieldRestriction( IRestrictionsEvaluator pRestrictionsEvaluator, RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
			return pRestrictionsEvaluator.ilikeAnywhere( pRestrictionField, pNamedParametersMap );
		}
	},		
	ILIKE_END {
		public String evaluateFieldRestriction( IRestrictionsEvaluator pRestrictionsEvaluator, RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
			return pRestrictionsEvaluator.ilikeEnd( pRestrictionField, pNamedParametersMap );
		}
	},
	ILIKE_EXACT {
		public String evaluateFieldRestriction( IRestrictionsEvaluator pRestrictionsEvaluator, RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
			return pRestrictionsEvaluator.ilikeExact( pRestrictionField, pNamedParametersMap );
		}
	},
	ILIKE_START {
		public String evaluateFieldRestriction( IRestrictionsEvaluator pRestrictionsEvaluator, RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap) {
			return pRestrictionsEvaluator.ilikeStart( pRestrictionField, pNamedParametersMap );
		}
	},		
	IN {
		public String evaluateFieldRestriction( IRestrictionsEvaluator pRestrictionsEvaluator, RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
			return pRestrictionsEvaluator.in( pRestrictionField, pNamedParametersMap );
		}
	},
	IS_NOT_NULL {
		public String evaluateFieldRestriction( IRestrictionsEvaluator pRestrictionsEvaluator, RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
			return pRestrictionsEvaluator.isNotNull( pRestrictionField, pNamedParametersMap );
		}
	},
	LE {
		public String evaluateFieldRestriction( IRestrictionsEvaluator pRestrictionsEvaluator, RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
			return pRestrictionsEvaluator.le( pRestrictionField, pNamedParametersMap );
		}
	},
	LIKE_ANYWHERE {
		public String evaluateFieldRestriction( IRestrictionsEvaluator pRestrictionsEvaluator, RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
			return pRestrictionsEvaluator.likeAnywhere( pRestrictionField, pNamedParametersMap );
		}
	},
	LIKE_END {
		public String evaluateFieldRestriction( IRestrictionsEvaluator pRestrictionsEvaluator, RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
			return pRestrictionsEvaluator.likeEnd( pRestrictionField, pNamedParametersMap );
		}
	},
	LIKE_EXACT {
		public String evaluateFieldRestriction( IRestrictionsEvaluator pRestrictionsEvaluator, RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
			return pRestrictionsEvaluator.likeExact( pRestrictionField, pNamedParametersMap );
		}
	},
	LIKE_START {
		public String evaluateFieldRestriction( IRestrictionsEvaluator pRestrictionsEvaluator, RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
			return pRestrictionsEvaluator.likeStart( pRestrictionField, pNamedParametersMap );
		}
	},
	LT {
		public String evaluateFieldRestriction( IRestrictionsEvaluator pRestrictionsEvaluator, RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
			return pRestrictionsEvaluator.lt( pRestrictionField, pNamedParametersMap );
		}
	},
	DISJUNCTION {
		public String evaluateFieldRestriction( IRestrictionsEvaluator pRestrictionsEvaluator, RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
			return pRestrictionsEvaluator.disjunction( pRestrictionField, pNamedParametersMap );
		}
	},
	CONJUNCTION {
		public String evaluateFieldRestriction( IRestrictionsEvaluator pRestrictionsEvaluator, RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
			return pRestrictionsEvaluator.conjunction( pRestrictionField, pNamedParametersMap );
		}
	},
	NE {
		public String evaluateFieldRestriction( IRestrictionsEvaluator pRestrictionsEvaluator, RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
			return pRestrictionsEvaluator.ne( pRestrictionField, pNamedParametersMap );
		}
	};
	
	/**
	 * 
	 * @param pRestrictionsEvaluator
	 * @param pRestrictionField
	 * @param pNamedParametersMap
	 * @return
	 */
	public abstract String evaluateFieldRestriction( IRestrictionsEvaluator pRestrictionsEvaluator, RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap );
}
