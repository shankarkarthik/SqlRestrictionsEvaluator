package org.ahp.db.sqlbuilder.restrictionevaluator;

import java.util.List;
import java.util.Map;

import org.ahp.db.sqlbuilder.restrictionevaluator.enums.SortOrder;

/**
 * @author Shankar K. Vaithianathan
 *
 */
public interface IRestrictionsEvaluator {

	public String idEq( RestrictionField restrictionField, Map<String,Object> namedParametersMap );
	
	public String eq( RestrictionField restrictionField, Map<String,Object> namedParametersMap );
	
	public String ne( RestrictionField restrictionField, Map<String,Object> namedParametersMap );
	
	public String likeExact( RestrictionField restrictionField, Map<String,Object> namedParametersMap );
	
	public String likeStart( RestrictionField restrictionField, Map<String,Object> namedParametersMap );
	
	public String likeEnd( RestrictionField restrictionField, Map<String,Object> namedParametersMap );
	
	public String likeAnywhere( RestrictionField restrictionField, Map<String,Object> namedParametersMap );
	
	public String ilikeExact( RestrictionField restrictionField, Map<String,Object> namedParametersMap );
	
	public String ilikeStart( RestrictionField restrictionField, Map<String,Object> namedParametersMap );
	
	public String ilikeEnd( RestrictionField restrictionField, Map<String,Object> namedParametersMap );
	
	public String ilikeAnywhere( RestrictionField restrictionField, Map<String,Object> namedParametersMap );
	
	public String gt( RestrictionField restrictionField, Map<String,Object> namedParametersMap );
	
	public String lt( RestrictionField restrictionField, Map<String,Object> namedParametersMap );

	public String le( RestrictionField restrictionField, Map<String,Object> namedParametersMap );
	
	public String ge( RestrictionField restrictionField, Map<String,Object> namedParametersMap);
	
	public String between(  RestrictionField restrictionField, Map<String,Object> namedParametersMap );
	
	public String in( RestrictionField restrictionField, Map<String,Object> namedParametersMap );
	
	public String isNull( RestrictionField restrictionField, Map<String,Object> namedParametersMap );
	
	public String isNotNull( RestrictionField restrictionField, Map<String,Object> namedParametersMap );
	
	public String conjunction( RestrictionField restrictionField, Map<String,Object> namedParametersMap );
	
	public String disjunction( RestrictionField restrictionField, Map<String,Object> namedParametersMap );
	
	public String orderBy( List<String> orderByList, SortOrder sortOrder );
	
	public String groupBy( List<String> groupByList );
	
	public String limit( int limitFrom, int limitTo, int limitSize );
	
}
