package org.ahp.db.sqlbuilder.restrictionevaluator;


import java.sql.Timestamp;
import java.util.Collection;


/**
 * 
 * @author Shankar K. Vaithianathan
 *
 */
public class RestrictionField {
	
	private IRestrictionFieldParameters fieldParameters;
	private Long id;
	private String fieldInput;
	private String betweenLow;
	private String betweenHigh;
	private Timestamp beginDate;
	private Timestamp endDate;
	private String[] fieldInputArray;
	private Collection<String> fieldInputCollection;
	
	public IRestrictionFieldParameters getFieldParameters() {
		return this.fieldParameters;
	}
	public void setFieldParameters( IRestrictionFieldParameters fieldParameters ) {
		this.fieldParameters = fieldParameters;
	}
	public String getFieldInput() {
		return this.fieldInput;
	}
	public void setFieldInput( String fieldInput ) {
		this.fieldInput = fieldInput;
	}
	public String getBetweenLow() {
		return this.betweenLow;
	}
	public void setBetweenLow( String betweenLow ) {
		betweenLow = betweenLow;
	}
	public String getBetweenHigh() {
		return this.betweenHigh;
	}
	public void setBetweenHigh( String betweenHigh ) {
		this.betweenHigh = betweenHigh;
	}
	public Timestamp getStartDate() {
		return this.beginDate;
	}
	public void setStartDate( Timestamp startDate ) {
		this.beginDate = startDate;
	}
	public Timestamp getEndDate() {
		return this.endDate;
	}
	public void setEndDate( Timestamp endDate ) {
		this.endDate = endDate;
	}
	public String[] getFieldInputArray() {
		return fieldInputArray;
	}
	public void setFieldInputArray( String[] fieldInputArray ) {
		this.fieldInputArray = fieldInputArray;
	}
	public Collection<String> getFieldInputCollection() {
		return fieldInputCollection;
	}
	public void setFieldInputCollection( Collection<String> fieldInputCollection ) {
		this.fieldInputCollection = fieldInputCollection;
	}
	public Long getId() {
		return id;
	}
	public void setId( Long pId ) {
		this.id = pId;
	}
	public String getNamedParameter() {
		return ":" + this.getFieldParameters().getRestrictableFieldName().toString();
	}
}
