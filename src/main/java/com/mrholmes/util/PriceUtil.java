package com.mrholmes.util;

import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class PriceUtil {

	public static Double loadPriceByURL(Document document, String tagConfig) {
		
		try {
				String tags[] = StringUtil.loadStringIgnores();
			
				List<Element> elements = DocumentUtil.loadElementsByTag(document, tagConfig);
			
				/* Get value inner tag */
				String price = elements.get(0).text();
				
				if(price == null || price.isEmpty()) {
					/* Get value and extract from inner tags */
					price = elements.get(0).toString();
				}
			
				for(int i=0 ; i<tags.length ; i++) {
					price = price.replaceAll(tags[i], "");
				}
			
				price = price.replace("R$", "");
				
				if(price.contains(",")) {
					price = price.replace(".", "");
					price = price.replace(",", ".");
				}			
				
				return Double.parseDouble(price);
			
		}catch(Exception ex) {
			return null;
		}
	}
}
