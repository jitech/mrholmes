package com.mrholmes.util;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.mrholmes.domain.Ecommerce;
import com.mrholmes.domain.ProductInfo;

public class ShopUtil {

	public static ProductInfo loadLowerPrice(List<ProductInfo> productInfos) throws Exception{
		
		ProductInfo productWithLowerPrice = productInfos.get(0);
				
		productInfos.remove(0);
			
		for(ProductInfo productInfo : productInfos) {
					
			if(productWithLowerPrice.getPrice() > productInfo.getPrice()) {
				productWithLowerPrice = productInfo;
			}
		}
				
		return productWithLowerPrice;
	}
	
	public static List<ProductInfo> loadProductInfosByGoogleLinks(List<String> shopLinks) throws Exception{
		

				if(shopLinks != null && !shopLinks.isEmpty()) {
					
					List<ProductInfo> productInfos = new ArrayList<ProductInfo>();
					
					for(String shopLink : shopLinks) {
						
						Ecommerce ecommerce = EcommerceUtil.loadEcommerceByUrl(shopLink);
						
						try {
								
								if(ecommerce != null) {
									
									MrHolmesUtil.say("Acessando: "+shopLink);
									
									Document doc = Jsoup.connect(shopLink).timeout(6000).get();
								
									List<Element> evaluationsElements = doc.getElementsByClass(ecommerce.getRatingHtmlTag().getCssName());
									List<Element> percentElements = doc.getElementsByClass(ecommerce.getPercentHtmlTag().getCssName());	
									List<Element> priceElements = doc.getElementsByClass(ecommerce.getSalesPriceHtmlTag().getCssName());
								
									
									ProductInfo productInfo = new ProductInfo();
									productInfo.setShop(ecommerce.getName());
									productInfo.setShopUrl(shopLink);
									
									
									/* Carregar Rating e Percent */
									if(evaluationsElements != null && !evaluationsElements.isEmpty() && percentElements != null && !percentElements.isEmpty()) 
									{					
										String evaluation = evaluationsElements.get(0).toString();
										
										for(int i=0 ; i<ecommerce.getRatingHtmlTag().getTags().length ; i++) {							
											evaluation = evaluation.replace(ecommerce.getRatingHtmlTag().getTags()[i], "");
										}	
										
										productInfo.setNumberOfEvaluations(Integer.parseInt(evaluation.trim().replaceAll(" ", "")));
										
										String percent = percentElements.get(0).toString();
										
										for(int i=0 ; i<ecommerce.getPercentHtmlTag().getTags().length ; i++) {							
											percent = percent.replace(ecommerce.getPercentHtmlTag().getTags()[i], "");
										}
										
										productInfo.setNumberOfIndications(Integer.parseInt(percent.trim().replaceAll(" ", "")));
									}
								
									/* Carregar Price */
									if(priceElements != null && !priceElements.isEmpty()) {
									
										String price = priceElements.get(0).toString();
										
										for(int i=0 ; i<ecommerce.getSalesPriceHtmlTag().getTags().length ; i++) {							
											price = price.replace(ecommerce.getSalesPriceHtmlTag().getTags()[i], "");
										}
										
										productInfo.setPrice(Double.parseDouble(price.trim().replaceAll(" ", "").replace(".", "").replaceAll(",", ".")));
									}
									
									productInfos.add(productInfo);								
								}
						
						}catch(Exception ex) {
							MrHolmesUtil.say("Erro: "+ex.getMessage());
						}
					}
					
					return productInfos;
				}
			
				return null;
	}
}