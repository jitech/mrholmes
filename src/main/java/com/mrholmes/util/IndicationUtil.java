package com.mrholmes.util;

import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.mrholmes.domain.ProductInfo;

public class IndicationUtil {

	public static Double loadPercentIndicationsByURL(Document document, String tagConfig) {
		
		try {
				if(tagConfig != null) {
					
					String tags[] = StringUtil.loadStringIgnores();

					List<Element> elements = DocumentUtil.loadElementsByTag(document, tagConfig);
			
					/* Get value inner tag */
					String indication = elements.get(0).text();
				
					if(indication == null || indication.isEmpty()) {
						/* Get value and extract from inner tags */
						indication = elements.get(0).toString();
					}
				
					for(int i=0 ; i<tags.length ; i++) {
						indication = indication.replaceAll(tags[i], "");
					}			
				
					indication = indication.replace("(", "");
					indication = indication.replace(")", "");
				
					if(indication.contains(",")) {
						indication = indication.replace(",", ".");
					}
					
					return Double.parseDouble(indication);
				}
				
				return 0.0;
			
		}catch(Exception ex) {
			return null;
		}
	}
	
	public static Integer loadTotalIndicationByProducts(List<ProductInfo> productInfos) {
		
		try {
				Integer totalIndication = 0;
			
				for(ProductInfo productInfo : productInfos) {			
					
					if(productInfo.getNumberOfReviews() != null && productInfo.getPercentOfIndications() != null) {
						totalIndication = (int) (totalIndication + (productInfo.getNumberOfReviews()*(productInfo.getPercentOfIndications())/100));	
					}
				}
				
				return totalIndication;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}