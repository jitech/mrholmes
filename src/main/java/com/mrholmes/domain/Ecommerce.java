package com.mrholmes.domain;

public class Ecommerce {

	private String url;
	private PercentHtmlTag percentHtmlTag = new PercentHtmlTag();
	private RatingHtmlTag ratingHtmlTag = new RatingHtmlTag();
	
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

	public Ecommerce() {
		super();
	}

	public Ecommerce(String url) {
		super();
		this.url = url;
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
	
	public void createPercentHtmlTag(String cssName, String[] tags) {
		percentHtmlTag.setCssName(cssName);
		percentHtmlTag.setTags(tags);
	}
	
	public void createRatingHtmlTag(String cssName, String[] tags) {
		ratingHtmlTag.setCssName(cssName);
		ratingHtmlTag.setTags(tags);
	}
}