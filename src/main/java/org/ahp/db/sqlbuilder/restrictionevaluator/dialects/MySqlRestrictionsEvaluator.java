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

	public String idEq( RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
		namedParametersMap.put( restrictionField.getFieldParameters().toString(), restrictionField.getId() );
		return " " + restrictionField.getFieldParameters().toString() + " = " + restrictionField.getNamedParameter() + " ";
	}

	public String eq( RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
		namedParametersMap.put( restrictionField.getFieldParameters().toString(), restrictionField.getFieldInput() );
		return " " + restrictionField.getFieldParameters().toString() + " = " + restrictionField.getNamedParameter() + " ";
	}

	public String ne( RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
		namedParametersMap.put( restrictionField.getFieldParameters().toString(), restrictionField.getFieldInput() );
		return " " + restrictionField.getFieldParameters().toString() + " <> " + restrictionField.getNamedParameter() + " ";
	}

	public String likeExact( RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
		return eq( restrictionField, namedParametersMap );
	}

	public String likeStart( RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
		namedParametersMap.put( restrictionField.getFieldParameters().toString(), restrictionField.getFieldInput() + "%" );
		return " " + restrictionField.getFieldParameters().toString() + " LIKE " + restrictionField.getNamedParameter() + " ";
	}

	public String likeEnd( RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
		namedParametersMap.put( restrictionField.getFieldParameters().toString(), restrictionField.getFieldInput() + "%" );
		return " " + restrictionField.getFieldParameters().toString() + " LIKE " + restrictionField.getNamedParameter() + " ";
	}

	public String likeAnywhere( RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
		namedParametersMap.put( restrictionField.getFieldParameters().toString(), "%" + restrictionField.getFieldInput() + "%" );
		return " " + restrictionField.getFieldParameters().toString() + " LIKE " + restrictionField.getNamedParameter() + " ";
	}

	public String ilikeExact( RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
		namedParametersMap.put( restrictionField.getFieldParameters().toString(), restrictionField.getFieldInput() );
		return " UPPER(" + restrictionField.getFieldParameters().toString() + ") LIKE " + "UPPER(" + restrictionField.getNamedParameter() + ") ";
	}

	public String ilikeStart( RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
		namedParametersMap.put( restrictionField.getFieldParameters().toString(), restrictionField.getFieldInput() + "%" );
		return " UPPER(" + restrictionField.getFieldParameters().toString() + ") LIKE " + "UPPER(" + restrictionField.getNamedParameter() + ") ";
	}

	public String ilikeEnd( RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
		namedParametersMap.put( restrictionField.getFieldParameters().toString(), "%" + restrictionField.getFieldInput() );
		return " UPPER(" + restrictionField.getFieldParameters().toString() + ") LIKE " + "UPPER(" + restrictionField.getNamedParameter() + ") ";
	}

	public String ilikeAnywhere( RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
		namedParametersMap.put( restrictionField.getFieldParameters().toString(), "%" + restrictionField.getFieldInput() + "%" );
		return " UPPER(" + restrictionField.getFieldParameters().toString() + ") LIKE " + "UPPER(" + restrictionField.getNamedParameter() + ") ";
	}

	public String gt( RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
		namedParametersMap.put( restrictionField.getFieldParameters().toString(), restrictionField.getFieldInput() );
		return " " + restrictionField.getFieldParameters().toString() + " > " + restrictionField.getNamedParameter() + " ";
	}

	public String lt( RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
		namedParametersMap.put( restrictionField.getFieldParameters().toString(), restrictionField.getFieldInput() );
		return " " + restrictionField.getFieldParameters().toString() + " < " + restrictionField.getNamedParameter() + " ";
	}

	public String le( RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
		namedParametersMap.put( restrictionField.getFieldParameters().toString(), restrictionField.getFieldInput() );
		return " " + restrictionField.getFieldParameters().toString() + " <= " + restrictionField.getNamedParameter() + " ";
	}

	public String ge( RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
		namedParametersMap.put( restrictionField.getFieldParameters().toString(), restrictionField.getFieldInput() );
		return " " + restrictionField.getFieldParameters().toString() + " >= " + restrictionField.getNamedParameter() + " ";
	}

	public String between(  RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
		if ( restrictionField.getFieldParameters().getRestrictionDataType() == RestrictionDataType.STRING ) {
			namedParametersMap.put( restrictionField.getFieldParameters().toString() + "High", restrictionField.getBetweenHigh() );
			namedParametersMap.put( restrictionField.getFieldParameters().toString() + "Low", restrictionField.getBetweenLow() );
			return " " + restrictionField.getNamedParameter() + " BETWEEN " + restrictionField.getBetweenLow() + " AND " + restrictionField.getBetweenLow() + " ";
		}
		if ( restrictionField.getFieldParameters().getRestrictionDataType() == RestrictionDataType.NUMBER ) {
			namedParametersMap.put( restrictionField.getFieldParameters().toString() + "High", restrictionField.getBetweenHigh() );
			namedParametersMap.put( restrictionField.getFieldParameters().toString() + "Low", restrictionField.getBetweenLow() );
			return " " + restrictionField.getNamedParameter() + " BETWEEN " + restrictionField.getBetweenLow() + " AND " + restrictionField.getBetweenLow() + " ";
		}
		if ( restrictionField.getFieldParameters().getRestrictionDataType() == RestrictionDataType.DATE ) {
			namedParametersMap.put( restrictionField.getFieldParameters().toString() + "Start" , restrictionField.getStartDate() );
			namedParametersMap.put( restrictionField.getFieldParameters().toString() + "End" , restrictionField.getEndDate() );
			return " " + 
			restrictionField.getFieldParameters().toString() +
			" BETWEEN STR_TO_DATE(" + restrictionField.getNamedParameter() + "Start ,'" + MY_SQL_DATE_TIME_FORMAT + "') " +
			" AND STR_TO_DATE(" + restrictionField.getNamedParameter() + "End ,'" + MY_SQL_DATE_TIME_FORMAT + "')";
		}
		return null;
	}

	public String in( RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
		
		if ( restrictionField.getFieldInputCollection() != null && restrictionField.getFieldInputCollection().size() > 0 ){
			namedParametersMap.put( restrictionField.getFieldParameters().toString(), Arrays.toString( restrictionField.getFieldInputCollection().toArray() ) );
			return " " + restrictionField.getFieldParameters().toString() + " IN (" + restrictionField.getNamedParameter() + ")";
		} 
		namedParametersMap.put( restrictionField.getFieldParameters().toString(), Arrays.toString( restrictionField.getFieldInputCollection().toArray() ) );
		return " " + restrictionField.getFieldParameters().toString() + " IN (" + restrictionField.getNamedParameter() + ")";
	}

	public String isNull( RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
		namedParametersMap.put( restrictionField.getFieldParameters().toString(), restrictionField.getFieldInput() );
		return " " + restrictionField.getNamedParameter() + " IS NULL ";
	}


	public String isNotNull( RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
		namedParametersMap.put( restrictionField.getNamedParameter(), restrictionField.getFieldInput() );
		return " " + restrictionField.getNamedParameter()  + " IS NOT NULL ";
	}
	
	public String conjunction( RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append( " ( " );
		stringBuilder.append( " (1=1) " );
		int lIndex = 0;
		for ( String inputField : restrictionField.getFieldInputCollection() ) {
			namedParametersMap.put( restrictionField.getNamedParameter() + lIndex, restrictionField.getFieldInput() );
			stringBuilder.append( " AND " + restrictionField.getFieldParameters().toString() + " = " + restrictionField.getNamedParameter() + lIndex );
		}
		stringBuilder.append( " ) " );
		return " " + restrictionField.getNamedParameter()  + " IS NOT NULL ";
	}
	
	public String disjunction( RestrictionField restrictionField, Map<String,Object> namedParametersMap ) {
		StringBuilder lStringBuilder = new StringBuilder();
		lStringBuilder.append( " ( " );
		lStringBuilder.append( " 1 = 0 " );
		int lIndex = 0;
		for ( String lStr : restrictionField.getFieldInputCollection() ) {
			namedParametersMap.put( restrictionField.getFieldParameters().toString() + lIndex, lStr );
			lStringBuilder.append( " OR " + restrictionField.getFieldParameters().toString() + " = " + restrictionField.getNamedParameter() + lIndex );
			lIndex++;
		}
		lStringBuilder.append( " ) " );
		return lStringBuilder.toString();
	}
	
	public String orderBy( List<String> pOrderByList, SortOrder pSortOrder ) {
		return " ORDER BY " + StringUtils.arrayToCommaDelimitedString( pOrderByList.toArray( new String[pOrderByList.size()] ) ) + " " + pSortOrder.toString() ;
	}

	public String groupBy( List<String> groupByList ) {
		return " GROUP BY " + StringUtils.arrayToCommaDelimitedString( groupByList.toArray( new String[groupByList.size()] ) ) ;
	}

	public String limit( int limitFrom, int limitTo, int limitSize ) {
		return " LIMIT " + limitFrom + ", " + limitSize;
	}
	
}
