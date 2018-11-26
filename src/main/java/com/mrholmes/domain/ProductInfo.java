package com.mrholmes.domain;

public class ProductInfo {

	private String shop;
	private String shopUrl;
	private String description;
	private Double price;
	private Integer numberOfReviews = 0;
	private Double percentOfIndications = 0.0;
		
	public ProductInfo() {
		super();
	}
	
	public ProductInfo(String shop, String shopUrl, String description, Double price, Integer numberOfReviews, Double numberOfIndications) {
		super();
		this.shop = shop;
		this.shopUrl = shopUrl;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public void setNumberOfReviews(Integer numberOfReviews) {
		this.numberOfReviews = numberOfReviews;
	}

	public Double getPercentOfIndications() {
		return percentOfIndications;
	}

	public void setPercentOfIndications(Double percentOfIndications) {
		this.percentOfIndications = percentOfIndications;
	}

	@Override
	public String toString() {
		return "ProductInfo [shop=" + shop + ", shopUrl=" + shopUrl + ", description=" + description + ", price="
				+ price + ", numberOfReviews=" + numberOfReviews + ", percentOfIndications=" + percentOfIndications
				+ "]";
	}
}