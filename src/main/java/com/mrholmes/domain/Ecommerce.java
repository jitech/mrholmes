package com.mrholmes.domain;

public class Ecommerce {

	private String name;
	private String url;
	private PercentHtmlTag percentHtmlTag = new PercentHtmlTag();
	private RatingHtmlTag ratingHtmlTag = new RatingHtmlTag();
	private SalesPriceHtmlTag salesPriceHtmlTag = new SalesPriceHtmlTag();
	
	public class PercentHtmlTag{
		
		private String cssName;
		private String[] tags;
		
		public PercentHtmlTag() {
			super();
		}
		
		public PercentHtmlTag(String cssName, String[] tags) {
			super();
			this.cssName = cssName;
			this.tags = tags;
		}
		
		public String getCssName() {
			return cssName;
		}
		public void setCssName(String cssName) {
			this.cssName = cssName;
		}
		public String[] getTags() {
			return tags;
		}
		public void setTags(String[] tags) {
			this.tags = tags;
		} 
	}
	
	public class RatingHtmlTag{
		
		private String cssName;
		private String[] tags;
		
		public RatingHtmlTag() {
			super();
		}
			
		public RatingHtmlTag(String cssName, String[] tags) {
			super();
			this.cssName = cssName;
			this.tags = tags;
		}

		public String getCssName() {
			return cssName;
		}
		public void setCssName(String cssName) {
			this.cssName = cssName;
		}
		public String[] getTags() {
			return tags;
		}
		public void setTags(String[] tags) {
			this.tags = tags;
		} 
	}
	
	public class SalesPriceHtmlTag{
		
		private String cssName;
		private String[] tags;
		
		public SalesPriceHtmlTag() {
			super();
		}
		
		public SalesPriceHtmlTag(String cssName, String[] tags) {
			super();
			this.cssName = cssName;
			this.tags = tags;
		}
		
		public String getCssName() {
			return cssName;
		}
		public void setCssName(String cssName) {
			this.cssName = cssName;
		}
		public String[] getTags() {
			return tags;
		}
		public void setTags(String[] tags) {
			this.tags = tags;
		} 
	}

	public Ecommerce() {
		super();
	}

	public Ecommerce(String url, String name) {
		super();
		this.name = name;
		this.url = url;
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

	public PercentHtmlTag getPercentHtmlTag() {
		return percentHtmlTag;
	}

	public void setPercentHtmlTag(PercentHtmlTag percentHtmlTag) {
		this.percentHtmlTag = percentHtmlTag;
	}

	public RatingHtmlTag getRatingHtmlTag() {
		return ratingHtmlTag;
	}

	public void setRatingHtmlTag(RatingHtmlTag ratingHtmlTag) {
		this.ratingHtmlTag = ratingHtmlTag;
	}
	
	public SalesPriceHtmlTag getSalesPriceHtmlTag() {
		return salesPriceHtmlTag;
	}

	public void setSalesPriceHtmlTag(SalesPriceHtmlTag salesPriceHtmlTag) {
		this.salesPriceHtmlTag = salesPriceHtmlTag;
	}
	
	public void createPercentHtmlTag(String cssName, String[] tags) {
		percentHtmlTag.setCssName(cssName);
		percentHtmlTag.setTags(tags);
	}
	
	public void createRatingHtmlTag(String cssName, String[] tags) {
		ratingHtmlTag.setCssName(cssName);
		ratingHtmlTag.setTags(tags);
	}

	public void createSalesPriceHtmlTag(String cssName, String[] tags) {
		salesPriceHtmlTag.setCssName(cssName);
		salesPriceHtmlTag.setTags(tags);
	}
}