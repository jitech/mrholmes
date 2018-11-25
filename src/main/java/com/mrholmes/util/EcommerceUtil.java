package com.mrholmes.util;

import java.util.ArrayList;
import java.util.List;

import com.mrholmes.domain.Ecommerce;

public class EcommerceUtil {

	public static Ecommerce loadEcommerceByUrl(String url){
				
		List<Ecommerce> ecommerces = new ArrayList<Ecommerce>();
		
		Ecommerce submarino = new Ecommerce("submarino.com.br", "Submarino");
		String[] submarinoTag1 = {"<text x=\"50%\" y=\"60%\" class=\"summary-stats-percentage-dial-text\" text-anchor=\"middle\">", "<!-- -->%", "</text>"};
		submarino.createPercentHtmlTag("summary-stats-percentage-dial-text", submarinoTag1);
		String[] submarinoTag2 = {"<div class=\"rating-star-counter\">", "</div>", "(", ")"};
		submarino.createRatingHtmlTag("rating-star-counter", submarinoTag2);	
		String[] submarinoTag3 = {"<p class=\"sales-price\">R$ ", "<svg class=\"svg-icon prime\" aria-labelledby=\"\" role=\"img\">", "<use xlink:href=\"#icon-prime\">","</use>", "</svg>","</p>"};
		submarino.createSalesPriceHtmlTag("sales-price", submarinoTag3);	
		ecommerces.add(submarino);
		
		Ecommerce americanas = new Ecommerce("americanas.com.br", "Americanas");
		String[] americanasTag1 = {"<text x=\"50%\" y=\"60%\" class=\"summary-stats-percentage-dial-text\" text-anchor=\"middle\">", "<!-- -->%", "</text>"};
		americanas.createPercentHtmlTag("summary-stats-percentage-dial-text", americanasTag1);
		String[] americanasTag2 = {"<div class=\"rating-star-counter\">", "</div>", "(", ")"};
		americanas.createRatingHtmlTag("rating-star-counter", americanasTag2);
		String[] americanasTag3 = {"<p class=\"sales-price\">R$ ", "<svg class=\"svg-icon prime\" aria-labelledby=\"\" role=\"img\">", "<use xlink:href=\"#icon-prime\">","</use>", "</svg>","</p>"};
		americanas.createSalesPriceHtmlTag("sales-price", americanasTag3);
		ecommerces.add(americanas);
		
		Ecommerce shoptime = new Ecommerce("shoptime.com.br", "Shoptime");
		String[] shoptimeTag1 = {"<text x=\"50%\" y=\"60%\" class=\"summary-stats-percentage-dial-text\" text-anchor=\"middle\">", "<!-- -->%", "</text>"};
		shoptime.createPercentHtmlTag("summary-stats-percentage-dial-text", shoptimeTag1);
		String[] shoptimeTag2 = {"<div class=\"rating-star-counter\">", "</div>", "(", ")"};
		shoptime.createRatingHtmlTag("rating-star-counter", shoptimeTag2);
		String[] shoptimeTag3 = {"<p class=\"sales-price\">R$ ", "<svg class=\"svg-icon prime\" aria-labelledby=\"\" role=\"img\">", "<use xlink:href=\"#icon-prime\">","</use>", "</svg>","</p>"};
		shoptime.createSalesPriceHtmlTag("sales-price", shoptimeTag3);
		ecommerces.add(shoptime);
		
		for(Ecommerce ecommerce : ecommerces) {
			
			if(url.toLowerCase().contains(ecommerce.getUrl())) {
				return ecommerce;
			}
		}
		
		return null;
	}
}