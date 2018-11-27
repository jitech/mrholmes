package com.mrholmes.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class DocumentUtil {

	public static Document loadDocument(String pageUrl) throws Exception{
		return Jsoup.connect(pageUrl).userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36").timeout(5 * 1000).validateTLSCertificates(false).get();
	}
}