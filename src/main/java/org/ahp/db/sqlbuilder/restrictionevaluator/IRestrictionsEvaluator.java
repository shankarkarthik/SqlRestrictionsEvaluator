package org.ahp.db.sqlbuilder.restrictionevaluator;

import java.util.List;
import java.util.Map;

import org.ahp.db.sqlbuilder.restrictionevaluator.enums.SortOrder;

/**
 * @author Shankar K. Vaithianathan
 *
 */
public interface IRestrictionsEvaluator {

	public String idEq( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap );
	public String eq( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap );
	public String ne( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap );
	public String likeExact( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap );
	public String likeStart( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap );
	public String likeEnd( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap );
	public String likeAnywhere( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap );
	public String ilikeExact( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap );
	public String ilikeStart( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap );
	public String ilikeEnd( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap );
	public String ilikeAnywhere( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap );
	public String gt( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap );
	public String lt( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap );
	public String le( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap );
	public String ge( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap);
	public String between(  RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap );
	public String in( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap );
	public String isNull( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap );
	public String isNotNull( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap );
	public String conjunction( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap );
	public String disjunction( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap );
	public String orderBy( List<String> pOrderByList, SortOrder pSortOrder );
	public String groupBy( List<String> pGroupByList );
	public String limit( int pLimitFrom, int pLimitTo, int pLimitSize );
	
}
