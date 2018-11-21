package com.mrholmes.domain;

public class Score {

	private String site;
	private Integer numberOfEvaluations;
	private Integer numberOfIndications;
	
	public Score() {
		super();
	}
	
	public Score(String site, Integer numberOfEvaluations, Integer numberOfIndications) {
		super();
		this.site = site;
		this.numberOfEvaluations = numberOfEvaluations;
		this.numberOfIndications = numberOfIndications;
	}
	
	public String getSite() {
		return site;
	}
	
	public void setSite(String site) {
		this.site = site;
	}
	
	public Integer getNumberOfEvaluations() {
		return numberOfEvaluations;
	}
	
	public void setNumberOfEvaluations(Integer numberOfEvaluations) {
		this.numberOfEvaluations = numberOfEvaluations;
	}
	
	public Integer getNumberOfIndications() {
		return numberOfIndications;
	}
	
	public void setNumberOfIndications(Integer numberOfIndications) {
		this.numberOfIndications = numberOfIndications;
	}
}