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
	 * @param array the array to display
	 * @param delimiter the delimiter to use (probably a ",")
	 * @return the delimited String
	 */
	public static String arrayToDelimitedString( Object[] array, String delimiter ) {
		if ( array == null ) {
			return "";
		}
		if ( array.length == 1) {
			return array[0].toString();
		}
		StringBuilder lStringBuilder = new StringBuilder();
		for ( int i = 0; i < array.length; i++ ) {
			if ( i > 0 ) {
				lStringBuilder.append( delimiter );
			}
			lStringBuilder.append( array[i] );
		}
		return lStringBuilder.toString();
	}

	public static String arrayToCommaDelimitedString( Object[] array ) {
		return arrayToDelimitedString( array, "," );
	}
}
