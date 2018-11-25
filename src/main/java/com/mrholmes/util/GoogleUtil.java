package com.mrholmes.util;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class GoogleUtil {

	public static void verifyAccess() throws Exception{
		Jsoup.connect("https://www.google.com").userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36").get();
	}
	
	public static List<String> loadLinksByGoogle(String text) throws Exception{
		
		Document doc = Jsoup.connect("https://www.google.com.br/search?q="+text).userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36").get();

		List<String> linksByGoogle = new ArrayList<String>();
		
		for (Element link : doc.getElementsByClass("plantl")) {	
			
			if(link.toString().contains("class=\"plantl\"")) {
			
				boolean addLink = true;
				String link_ = null;
				String domain = null;
				
				while(link_ == null && domain == null) {
					
					link_ = link.attr("href");
					
					for(String url : linksByGoogle) {
						URI uri = new URI(link_);
						domain = uri.getHost();
					
						if(url.equals(link_) || url.contains(domain)) {
							addLink = false;
							break;
						}
					}
				}

				if(addLink) {							
					linksByGoogle.add(link_);
				}
			}
		}
		
		return linksByGoogle;
	}
}