package org.ahp.db.sqlbuilder.restrictionevaluator;


import java.sql.Timestamp;
import java.util.Collection;


/**
 * 
 * @author Shankar Karthik Vaithianathan
 *
 */
public class RestrictionField {
	
	private IRestrictionFieldParameters mFieldParameters;
	private Long mId;
	private String mFieldInput;
	private String mBetweenLow;
	private String mBetweenHigh;
	private Timestamp mBeginDate;
	private Timestamp mEndDate;
	private String[] mFieldInputArray;
	private Collection<String> mFieldInputCollection;
	
	public IRestrictionFieldParameters getFieldParameters() {
		return mFieldParameters;
	}
	public void setFieldParameters( IRestrictionFieldParameters pFieldName ) {
		mFieldParameters = pFieldName;
	}
	public String getFieldInput() {
		return mFieldInput;
	}
	public void setFieldInput( String pFieldInput ) {
		mFieldInput = pFieldInput;
	}
	public String getBetweenLow() {
		return mBetweenLow;
	}
	public void setBetweenLow( String pBetweenLow ) {
		mBetweenLow = pBetweenLow;
	}
	public String getBetweenHigh() {
		return mBetweenHigh;
	}
	public void setBetweenHigh( String pBetweenHigh ) {
		mBetweenHigh = pBetweenHigh;
	}
	public Timestamp getStartDate() {
		return mBeginDate;
	}
	public void setStartDate( Timestamp pStartDate ) {
		mBeginDate = pStartDate;
	}
	public Timestamp getEndDate() {
		return mEndDate;
	}
	public void setEndDate( Timestamp pEndDate ) {
		mEndDate = pEndDate;
	}
	public String[] getFieldInputArray() {
		return mFieldInputArray;
	}
	public void setFieldInputArray( String[] pFieldInputArray ) {
		mFieldInputArray = pFieldInputArray;
	}
	public Collection<String> getFieldInputCollection() {
		return mFieldInputCollection;
	}
	public void setFieldInputCollection( Collection<String> pFieldInputCollection ) {
		mFieldInputCollection = pFieldInputCollection;
	}
	public Long getId() {
		return mId;
	}
	public void setId( Long pId ) {
		mId = pId;
	}
	public String getNamedParameter() {
		return ":" + this.getFieldParameters().getRestrictableFieldName().toString();
	}
}
