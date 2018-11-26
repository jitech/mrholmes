package com.mrholmes.util;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

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
	
	public static List<ProductInfo> loadProductInfosByGoogleLinks(List<String> shopLinks){
		
		try {
				if(shopLinks != null && !shopLinks.isEmpty()) {
					
					List<ProductInfo> productInfos = new ArrayList<ProductInfo>();
					
					for(String shopLink : shopLinks) {
						
						Ecommerce ecommerce = EcommerceUtil.loadEcommerceByUrl(shopLink);
						
						try {						
								if(ecommerce != null) {
								
									MrHolmesUtil.say("Acessando: "+shopLink);
								
									Document doc = Jsoup.connect(shopLink).timeout(6000).get();
							
									productInfos.add(
											new ProductInfo(ecommerce.getName(), 
													shopLink, 
													PriceUtil.loadPriceByURL(doc, ecommerce.getTagPrice()), 
													ReviewUtil.loadQuantReviewByURL(doc, ecommerce.getTagReview()), 
													IndicationUtil.loadPercentIndicationsByURL(doc, ecommerce.getTagIndication())
													)
											);								
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
}