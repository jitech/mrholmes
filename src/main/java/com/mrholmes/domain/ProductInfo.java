package com.mrholmes.domain;

public class ProductInfo {

	private String shop;
	private String shopUrl;
	private Double price;
	private Integer numberOfEvaluations;
	private Integer numberOfIndications;
		
	public ProductInfo() {
		super();
	}
	
	public ProductInfo(String shop, String shopUrl, Double price, Integer numberOfEvaluations, Integer numberOfIndications) {
		super();
		this.shop = shop;
		this.shopUrl = shopUrl;
		this.price = price;
		this.numberOfEvaluations = numberOfEvaluations;
		this.numberOfIndications = numberOfIndications;
	}
	
	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

	public String getShopUrl() {
		return shopUrl;
	}
	
	public void setShopUrl(String shopUrl) {
		this.shopUrl = shopUrl;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
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
	
	@Override
	public String toString() {
		return "ProductInfo [shopUrl=" + shopUrl + ", price=" + price + ", numberOfEvaluations=" + numberOfEvaluations
				+ ", numberOfIndications=" + numberOfIndications + "]";
	}
}