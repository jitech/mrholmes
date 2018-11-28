package com.mrholmes.util;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.mrholmes.domain.Ecommerce;
import com.mrholmes.domain.ProductInfo;

public class ProductUtil {

	/* Load the product with lower price */
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
	
	/* Load products by Google links */
	public static List<ProductInfo> loadProductInfosByGoogleLinks(String text, List<String> shopLinks){
		
		try {
				if(shopLinks != null && !shopLinks.isEmpty()) {
					
					List<ProductInfo> productInfos = new ArrayList<ProductInfo>();
					
					for(String shopLink : shopLinks) {
						
						Ecommerce ecommerce = EcommerceUtil.loadEcommerceByUrl(shopLink);
						
						try {						
								if(ecommerce != null) {
								
									MrHolmesUtil.say("Acessando: "+shopLink);
								
									Document doc = DocumentUtil.loadDocument(shopLink);
							
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
							MrHolmesUtil.say("Não consegui acessar: "+shopLink);
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
	
	/* Load product description tag by site */
	public static String loadDescriptionByURL(Document document, String tagConfig) {
		
		try {							
				List<Element> elements = DocumentUtil.loadElementsByTag(document, tagConfig);
						
				/* Get value inner tag */
				String description = elements.get(0).text();
				
				if(description == null || description.isEmpty()) {
					/* Get value and extract from inner tags */
					description = elements.get(0).toString();
				}
			
				return description;
			
		}catch(Exception ex) {
			return null;
		}
	}
	
	/* Verify if product is valid. Sometimes the google can be returned others products */
	public static boolean isProductValid(String textByUser, String textByGoogle) {
		
		try {
				/*String textByUserArray[] = textByUser.toLowerCase().split(" ");
				String textByGoogleArray[] = textByGoogle.toLowerCase().split(" ");
				
				int count = 0;
				
				for(int i=0 ; i<textByUserArray.length ; i++) {
					for(int j=0 ; j<textByGoogleArray.length ; j++) {
						if(textByUserArray[i].equals(textByGoogleArray[j])) {
							count++;
							break;
						}
					}
				}*/
			
				String textByUserArray[] = textByUser.toLowerCase().split(" ");
								
				int count = 0;
				
				for(int i=0 ; i<textByUserArray.length ; i++) {
					if(textByGoogle.toLowerCase().contains(textByUserArray[i])) {
						count++;
					}	
				}
				
				return textByUserArray.length == count;
			
		}catch(Exception ex) {
			return false;
		}
	}
}