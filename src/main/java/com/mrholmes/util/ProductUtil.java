package com.mrholmes.util;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.mrholmes.domain.Ecommerce;
import com.mrholmes.domain.ProductInfo;

public class ProductUtil {

	public static ProductInfo loadLowerPrice(List<ProductInfo> productInfos) {
		
		try {
				ProductInfo productWithLowerPrice = productInfos.get(0);			
				productInfos.remove(0);
			
				for(ProductInfo productInfo : productInfos) {				
					if(productWithLowerPrice.getPrice() != null && productInfo.getPrice() != null && productWithLowerPrice.getPrice() > productInfo.getPrice()) {				
						productWithLowerPrice = productInfo;
					}
				}
				
				return productWithLowerPrice;
				
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public static List<ProductInfo> loadProductInfosByGoogleLinks(String text, List<String> shopLinks){
		
		try {
				if(shopLinks != null && !shopLinks.isEmpty()) {
					
					List<ProductInfo> productInfos = new ArrayList<ProductInfo>();
					
					for(String shopLink : shopLinks) {
						
						Ecommerce ecommerce = EcommerceUtil.loadEcommerceByUrl(shopLink);
						
						try {						
								if(ecommerce != null) {
								
									MrHolmesUtil.say("Acessando: "+shopLink);
								
									Document doc = Jsoup.connect(shopLink).timeout(6000).get();
							
									String title = ProductUtil.loadDescriptionByURL(doc, ecommerce.getTagDescription());
									
									if(isProductValid(text, title)) {
									
									productInfos.add(
											new ProductInfo(ecommerce.getName(), 
													shopLink, 
													ProductUtil.loadDescriptionByURL(doc, ecommerce.getTagDescription()),
													PriceUtil.loadPriceByURL(doc, ecommerce.getTagPrice()), 
													ReviewUtil.loadQuantReviewByURL(doc, ecommerce.getTagReview()), 
													IndicationUtil.loadPercentIndicationsByURL(doc, ecommerce.getTagIndication())
													)
											);	
									}
							}
														
						}catch(Exception ex) {
							ex.printStackTrace();
						}
					}
					
					return productInfos;
				}
				
			return null;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}				
	}
	
	public static String loadDescriptionByURL(Document doc, String tagConfig) {
		
		try {			
				List<Element> elementsByDescription = doc.select(tagConfig);
			
				/* Get value inner tag */
				String description = elementsByDescription.get(0).text();
				
				if(description == null || description.isEmpty()) {
					/* Get value and extract from inner tags */
					description = elementsByDescription.get(0).toString();
				}
			
				return description;
			
		}catch(Exception ex) {
			return null;
		}
	}
	
	public static boolean isProductValid(String textByUser, String textByGoogle) {
		
		try {
				String textByUserArray[] = textByUser.toLowerCase().split(" ");
				String textByGoogleArray[] = textByGoogle.toLowerCase().split(" ");
				
				int count = 0;
				
				for(int i=0 ; i<textByUserArray.length ; i++) {
					for(int j=0 ; j<textByGoogleArray.length ; j++) {
						if(textByUserArray[i].equals(textByGoogleArray[j])) {
							count++;
							break;
						}
					}
				}
				
				return textByUserArray.length == count;
			
		}catch(Exception ex) {
			return false;
		}
	}
}