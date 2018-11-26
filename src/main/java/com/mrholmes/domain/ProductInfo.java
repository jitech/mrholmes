package com.mrholmes.domain;

public class ProductInfo {

	private String shop;
	private String shopUrl;
	private Double price;
	private Integer numberOfReviews = 0;
	private Double percentOfIndications = 0.0;
		
	public ProductInfo() {
		super();
	}
	
	public ProductInfo(String shop, String shopUrl, Double price, Integer numberOfReviews, Double numberOfIndications) {
		super();
		this.shop = shop;
		this.shopUrl = shopUrl;
		this.price = price;
		this.numberOfReviews = numberOfReviews;
		this.percentOfIndications = numberOfIndications;
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
	
	public Integer getNumberOfReviews() {
		return numberOfReviews;
	}
	
	public void setNumberOfEvaluations(Integer numberOfReviews) {
		this.numberOfReviews = numberOfReviews;
	}
	
	public Double getPercentOfIndications() {
		return percentOfIndications;
	}
	
	public void setPercentOfIndications(Double numberOfIndications) {
		this.percentOfIndications = numberOfIndications;
	}
	
	@Override
	public String toString() {
		return "ProductInfo [shopUrl=" + shopUrl + ", price=" + price + ", numberOfReviews=" + numberOfReviews
				+ ", percentOfIndications=" + percentOfIndications + "]";
	}
}