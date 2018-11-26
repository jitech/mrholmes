package com.mrholmes.domain;

public class Ecommerce {

	private String name;
	private String url;
	private String tagDescription;
	private String tagReview;
	private String tagIndication;
	private String tagPrice;
	
	public Ecommerce() {
		super();
	}
	
	public Ecommerce(String name, String url, String tagDescription, String tagReview, String tagIndication, String tagPrice) {
		super();
		this.name = name;
		this.url = url;
		this.tagDescription = tagDescription;
		this.tagReview = tagReview;
		this.tagIndication = tagIndication;
		this.tagPrice = tagPrice;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTagDescription() {
		return tagDescription;
	}
	public void setTagDescription(String tagDescription) {
		this.tagDescription = tagDescription;
	}
	public String getTagReview() {
		return tagReview;
	}
	public void setTagReview(String tagReview) {
		this.tagReview = tagReview;
	}
	public String getTagIndication() {
		return tagIndication;
	}
	public void setTagIndication(String tagIndication) {
		this.tagIndication = tagIndication;
	}
	public String getTagPrice() {
		return tagPrice;
	}
	public void setTagPrice(String tagPrice) {
		this.tagPrice = tagPrice;
	}

	@Override
	public String toString() {
		return "Ecommerce [name=" + name + ", url=" + url + ", tagDescription=" + tagDescription + ", tagReview="
				+ tagReview + ", tagIndication=" + tagIndication + ", tagPrice=" + tagPrice + "]";
	}
}	