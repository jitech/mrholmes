package com.mrholmes.util;

import java.util.HashMap;
import java.util.Map;

public class StringUtil {

	public static String format(String words) throws Exception{
		
		Map<String, String> map = new HashMap<String,String>();
		map.put("&ccedil;", "ç");
		map.put("&aacute;", "á");
		map.put("&atilde;", "ã");
		map.put("&eacute;", "é");
		map.put("&ecirc;", "ê");
		map.put("&iacute;", "í");
		map.put("&ocirc;", "ó");
		map.put("&otilde;", "õ");
		map.put("&uacute;", "ú");
		
		for (Map.Entry<String, String> entry : map.entrySet()) {		
			words = words.replace(entry.getKey(), entry.getValue());
		}
		
		return words;
	}
}