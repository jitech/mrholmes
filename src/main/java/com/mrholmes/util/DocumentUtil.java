package com.mrholmes.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class DocumentUtil {

	public static Document loadDocument(String pageUrl) throws Exception{
		return Jsoup.connect(pageUrl).timeout(6000).get();
	}
}