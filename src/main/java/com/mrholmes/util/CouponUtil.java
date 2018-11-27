package com.mrholmes.util;

import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class CouponUtil {

	public static String loadCouponByCuponomia(String shopName) {
		
		try {
				Document doc = DocumentUtil.loadDocument("https://www.cuponomia.com.br");
				List<Element> elementsByDescription = doc.select("span[data-label = "+shopName+"]");		
				String coupon = elementsByDescription.get(0).text();				
				return coupon.replaceAll("Ver Cupom", "").trim();
				
		}catch(Exception ex) {
			return null;
		}
	}
}