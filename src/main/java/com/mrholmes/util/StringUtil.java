package com.mrholmes.util;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class StringUtil {

	public static String[] loadStringIgnores() {
		String tags[] = {"<",">","\"","=",":","!","meta","itemprop","price","reviewCount","content","div","class","pct","%","/","\n"," ","span","sales","-","svg","icon","prime","aria","labelledby","role","img","use","xlink","link","href","#","p","rating","star","counter","Avaliado por","clientes"};
		return tags;
	}
	
	public static String format(String words) throws Exception{
		
		Map<String, String> map = new HashMap<String,String>();
		map.put("&ccedil;", "ç");
		map.put("&aacute;", "á");
		map.put("&atilde;", "ã");
		map.put("&eacute;", "é");
		map.put("&ecirc;", "ê");
		map.put("&iacute;", "í");
		map.put("&oacute;", "ó");
		map.put("&otilde;", "õ");
		map.put("&ocirc;", "ô");		
		map.put("&uacute;", "ú");
		
		for (Map.Entry<String, String> entry : map.entrySet()) {		
			words = words.replace(entry.getKey(), entry.getValue());
		}
		
		return words;
	}
	
	public static String formatToMoney(Double value) {		
		DecimalFormat decimal = new DecimalFormat("###,###,###,##0.00");
		return decimal.format(value);
	}
}