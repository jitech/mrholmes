package com.mrholmes.util;

import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.mrholmes.domain.ProductInfo;

public class ReviewUtil {

	public static Integer loadQuantReviewByURL(Document doc, String tagConfig) {
		
		try {
				String tags[] = StringUtil.loadStringIgnores();
			
				List<Element> elementsByReview = doc.select(tagConfig);
							
				/* Get value inner tag */
				String review = elementsByReview.get(0).text();
				
				if(review == null || review.isEmpty()) {
					/* Get value and extract from inner tags */
					review = elementsByReview.get(0).toString();
				}
			
				for(int i=0 ; i<tags.length ; i++) {
					review = review.replaceAll(tags[i], "");
				}			
				
				review = review.replace("(", "");
				review = review.replace(")", "");
				
				return Integer.parseInt(review);
			
		}catch(Exception ex) {
			return null;
		}
	}
	
	public static Integer loadTotalReviewByProducts(List<ProductInfo> productInfos) {
		
		try {
				Integer totalReview = 0;
			
				for(ProductInfo productInfo : productInfos) {
					totalReview = totalReview + productInfo.getNumberOfReviews();
				}
				
				return totalReview;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
