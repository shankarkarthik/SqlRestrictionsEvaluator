/**
 * 
 */
package org.ahp.db.sqlbuilder.restrictionevaluator.util;

/**
 * @author Shankar K. Vaithianathan
 *
 */
public class StringUtils {

	
	/**
	 * Convenience method to return a String array as a delimited (e.g. CSV)
	 * @param pArray the array to display
	 * @param pDelimiter the delimiter to use (probably a ",")
	 * @return the delimited String
	 */
	public static String arrayToDelimitedString( Object[] pArray, String pDelimiter ) {
		if ( pArray == null ) {
			return "";
		}
		if ( pArray.length == 1) {
			return pArray[0].toString();
		}
		StringBuilder lStringBuilder = new StringBuilder();
		for ( int i = 0; i < pArray.length; i++ ) {
			if ( i > 0 ) {
				lStringBuilder.append( pDelimiter );
			}
			lStringBuilder.append( pArray[i] );
		}
		return lStringBuilder.toString();
	}

	public static String arrayToCommaDelimitedString( Object[] pArray ) {
		return arrayToDelimitedString( pArray, "," );
	}
}
