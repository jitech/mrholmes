package com.mrholmes.util;

import java.util.ArrayList;
import java.util.List;

import com.mrholmes.domain.Ecommerce;

public class EcommerceUtil {

	public static Ecommerce loadEcommerceByUrl(String url){
				
		List<Ecommerce> ecommerces = new ArrayList<Ecommerce>();
		ecommerces.add(new Ecommerce("Submarino", "submarino.com.br", "title", "div[class = rating-star-counter]", "text[class = summary-stats-percentage-dial-text]", "p[class = sales-price]"));
		ecommerces.add(new Ecommerce("Americanas", "americanas.com.br", "title", "div[class = rating-star-counter]", "text[class = summary-stats-percentage-dial-text]", "p[class = sales-price]"));
		ecommerces.add(new Ecommerce("Shoptime", "shoptime.com.br", "title", "div[class = rating-star-counter]", "text[class = summary-stats-percentage-dial-text]", "p[class = sales-price]"));
		ecommerces.add(new Ecommerce("Cissa Magazine", "cissamagazine.com.br","title", "meta[itemprop = reviewCount]", "div[class = pct]", "meta[itemprop = price]"));
		
		for(Ecommerce ecommerce : ecommerces) {			
			if(url.toLowerCase().contains(ecommerce.getUrl().toLowerCase())) {
				return ecommerce;
			}
		}
		
		return null;
	}
}