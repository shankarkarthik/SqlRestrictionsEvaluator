package org.ahp.db.sqlbuilder.restrictionevaluator.dialects;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.ahp.db.sqlbuilder.restrictionevaluator.IRestrictionsEvaluator;
import org.ahp.db.sqlbuilder.restrictionevaluator.RestrictionField;
import org.ahp.db.sqlbuilder.restrictionevaluator.enums.RestrictionDataType;
import org.ahp.db.sqlbuilder.restrictionevaluator.enums.SortOrder;
import org.ahp.db.sqlbuilder.restrictionevaluator.util.StringUtils;

/**
 * 
 * @author Shankar K. Vaithianathan
 * 
 */
public class MySqlRestrictionsEvaluator implements IRestrictionsEvaluator {

	final String MY_SQL_DATE_TIME_FORMAT = "%Y-%m-%d %H:%i:%s.%f";
	
	public MySqlRestrictionsEvaluator() {
	}

	public String idEq( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
		pNamedParametersMap.put( pRestrictionField.getFieldParameters().toString(), pRestrictionField.getId() );
		return " " + pRestrictionField.getFieldParameters().toString() + " = " + pRestrictionField.getNamedParameter() + " ";
	}

	public String eq( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
		pNamedParametersMap.put( pRestrictionField.getFieldParameters().toString(), pRestrictionField.getFieldInput() );
		return " " + pRestrictionField.getFieldParameters().toString() + " = " + pRestrictionField.getNamedParameter() + " ";
	}

	public String ne( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
		pNamedParametersMap.put( pRestrictionField.getFieldParameters().toString(), pRestrictionField.getFieldInput() );
		return " " + pRestrictionField.getFieldParameters().toString() + " <> " + pRestrictionField.getNamedParameter() + " ";
	}

	public String likeExact( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
		return eq( pRestrictionField, pNamedParametersMap );
	}

	public String likeStart( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
		pNamedParametersMap.put( pRestrictionField.getFieldParameters().toString(), pRestrictionField.getFieldInput() + "%" );
		return " " + pRestrictionField.getFieldParameters().toString() + " LIKE " + pRestrictionField.getNamedParameter() + " ";
	}

	public String likeEnd( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
		pNamedParametersMap.put( pRestrictionField.getFieldParameters().toString(), pRestrictionField.getFieldInput() + "%" );
		return " " + pRestrictionField.getFieldParameters().toString() + " LIKE " + pRestrictionField.getNamedParameter() + " ";
	}

	public String likeAnywhere( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
		pNamedParametersMap.put( pRestrictionField.getFieldParameters().toString(), "%" + pRestrictionField.getFieldInput() + "%" );
		return " " + pRestrictionField.getFieldParameters().toString() + " LIKE " + pRestrictionField.getNamedParameter() + " ";
	}

	public String ilikeExact( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
		pNamedParametersMap.put( pRestrictionField.getFieldParameters().toString(), pRestrictionField.getFieldInput() );
		return " UPPER(" + pRestrictionField.getFieldParameters().toString() + ") LIKE " + "UPPER(" + pRestrictionField.getNamedParameter() + ") ";
	}

	public String ilikeStart( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
		pNamedParametersMap.put( pRestrictionField.getFieldParameters().toString(), pRestrictionField.getFieldInput() + "%" );
		return " UPPER(" + pRestrictionField.getFieldParameters().toString() + ") LIKE " + "UPPER(" + pRestrictionField.getNamedParameter() + ") ";
	}

	public String ilikeEnd( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
		pNamedParametersMap.put( pRestrictionField.getFieldParameters().toString(), "%" + pRestrictionField.getFieldInput() );
		return " UPPER(" + pRestrictionField.getFieldParameters().toString() + ") LIKE " + "UPPER(" + pRestrictionField.getNamedParameter() + ") ";
	}

	public String ilikeAnywhere( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
		pNamedParametersMap.put( pRestrictionField.getFieldParameters().toString(), "%" + pRestrictionField.getFieldInput() + "%" );
		return " UPPER(" + pRestrictionField.getFieldParameters().toString() + ") LIKE " + "UPPER(" + pRestrictionField.getNamedParameter() + ") ";
	}

	public String gt( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
		pNamedParametersMap.put( pRestrictionField.getFieldParameters().toString(), pRestrictionField.getFieldInput() );
		return " " + pRestrictionField.getFieldParameters().toString() + " > " + pRestrictionField.getNamedParameter() + " ";
	}

	public String lt( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
		pNamedParametersMap.put( pRestrictionField.getFieldParameters().toString(), pRestrictionField.getFieldInput() );
		return " " + pRestrictionField.getFieldParameters().toString() + " < " + pRestrictionField.getNamedParameter() + " ";
	}

	public String le( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
		pNamedParametersMap.put( pRestrictionField.getFieldParameters().toString(), pRestrictionField.getFieldInput() );
		return " " + pRestrictionField.getFieldParameters().toString() + " <= " + pRestrictionField.getNamedParameter() + " ";
	}

	public String ge( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap) {
		pNamedParametersMap.put( pRestrictionField.getFieldParameters().toString(), pRestrictionField.getFieldInput() );
		return " " + pRestrictionField.getFieldParameters().toString() + " >= " + pRestrictionField.getNamedParameter() + " ";
	}

	public String between(  RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
		if ( pRestrictionField.getFieldParameters().getRestrictionDataType() == RestrictionDataType.STRING ) {
			pNamedParametersMap.put( pRestrictionField.getFieldParameters().toString() + "High", pRestrictionField.getBetweenHigh() );
			pNamedParametersMap.put( pRestrictionField.getFieldParameters().toString() + "Low", pRestrictionField.getBetweenLow() );
			return " " + pRestrictionField.getNamedParameter() + " BETWEEN " + pRestrictionField.getBetweenLow() + " AND " + pRestrictionField.getBetweenLow() + " ";
		}
		if ( pRestrictionField.getFieldParameters().getRestrictionDataType() == RestrictionDataType.NUMBER ) {
			pNamedParametersMap.put( pRestrictionField.getFieldParameters().toString() + "High", pRestrictionField.getBetweenHigh() );
			pNamedParametersMap.put( pRestrictionField.getFieldParameters().toString() + "Low", pRestrictionField.getBetweenLow() );
			return " " + pRestrictionField.getNamedParameter() + " BETWEEN " + pRestrictionField.getBetweenLow() + " AND " + pRestrictionField.getBetweenLow() + " ";
		}
		if ( pRestrictionField.getFieldParameters().getRestrictionDataType() == RestrictionDataType.DATE ) {
			pNamedParametersMap.put( pRestrictionField.getFieldParameters().toString() + "Start" , pRestrictionField.getStartDate() );
			pNamedParametersMap.put( pRestrictionField.getFieldParameters().toString() + "End" , pRestrictionField.getEndDate() );
			return " " + 
			pRestrictionField.getFieldParameters().toString() +
			" BETWEEN STR_TO_DATE(" + pRestrictionField.getNamedParameter() + "Start ,'" + MY_SQL_DATE_TIME_FORMAT + "') " +
			" AND STR_TO_DATE(" + pRestrictionField.getNamedParameter() + "End ,'" + MY_SQL_DATE_TIME_FORMAT + "')";
		}
		return null;
	}

	public String in( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
		
		if ( pRestrictionField.getFieldInputCollection() != null && pRestrictionField.getFieldInputCollection().size() > 0 ){
			pNamedParametersMap.put( pRestrictionField.getFieldParameters().toString(), Arrays.toString( pRestrictionField.getFieldInputCollection().toArray() ) );
			return " " + pRestrictionField.getFieldParameters().toString() + " IN (" + pRestrictionField.getNamedParameter() + ")";
		} 
		pNamedParametersMap.put( pRestrictionField.getFieldParameters().toString(), Arrays.toString( pRestrictionField.getFieldInputCollection().toArray() ) );
		return " " + pRestrictionField.getFieldParameters().toString() + " IN (" + pRestrictionField.getNamedParameter() + ")";
	}

	public String isNull( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
		pNamedParametersMap.put( pRestrictionField.getFieldParameters().toString(), pRestrictionField.getFieldInput() );
		return " " + pRestrictionField.getNamedParameter() + " IS NULL ";
	}


	public String isNotNull( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
		pNamedParametersMap.put( pRestrictionField.getNamedParameter(), pRestrictionField.getFieldInput() );
		return " " + pRestrictionField.getNamedParameter()  + " IS NOT NULL ";
	}
	
	public String conjunction( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
		StringBuilder lStringBuilder = new StringBuilder();
		lStringBuilder.append( " ( " );
		lStringBuilder.append( " (1=1) " );
		int lIndex = 0;
		for ( String lStr : pRestrictionField.getFieldInputCollection() ) {
			pNamedParametersMap.put( pRestrictionField.getNamedParameter() + lIndex, pRestrictionField.getFieldInput() );
			lStringBuilder.append( " AND " + pRestrictionField.getFieldParameters().toString() + " = " + pRestrictionField.getNamedParameter() + lIndex );
		}
		lStringBuilder.append( " ) " );
		return " " + pRestrictionField.getNamedParameter()  + " IS NOT NULL ";
	}
	
	public String disjunction( RestrictionField pRestrictionField, Map<String,Object> pNamedParametersMap ) {
		StringBuilder lStringBuilder = new StringBuilder();
		lStringBuilder.append( " ( " );
		lStringBuilder.append( " 1=0 " );
		int lIndex = 0;
		for ( String lStr : pRestrictionField.getFieldInputCollection() ) {
			pNamedParametersMap.put( pRestrictionField.getFieldParameters().toString() + lIndex, lStr );
			lStringBuilder.append( " OR " + pRestrictionField.getFieldParameters().toString() + " = " + pRestrictionField.getNamedParameter() + lIndex );
			lIndex++;
		}
		lStringBuilder.append( " ) " );
		return lStringBuilder.toString();
	}
	
	public String orderBy( List<String> pOrderByList, SortOrder pSortOrder ) {
		return " ORDER BY " + StringUtils.arrayToCommaDelimitedString( pOrderByList.toArray( new String[pOrderByList.size()] ) ) + " " + pSortOrder.toString() ;
	}

	public String groupBy( List<String> pGroupByList ) {
		return " GROUP BY " + StringUtils.arrayToCommaDelimitedString( pGroupByList.toArray( new String[pGroupByList.size()] ) ) ;
	}

	public String limit( int pLimitFrom, int pLimitTo, int pLimitSize ) {
		return " LIMIT " + pLimitFrom + ", " + pLimitSize;
	}
	
}
