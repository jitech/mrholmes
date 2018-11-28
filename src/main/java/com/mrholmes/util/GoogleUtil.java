package com.mrholmes.util;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class GoogleUtil {

	public static void verifyAccess() throws Exception{
		DocumentUtil.loadDocument("https://www.google.com.br");
	}
	
	public static List<String> loadLinksByGoogle(String text) throws Exception{
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");		
		String site = "https://www.submarino.com.br/produto/133741110/smartphone-motorola-moto-g6-plus-64gb-dual-chip-android-oreo-8-0-tela-5-9-octa-core-2-2-ghz-4g-camera-12-5mp-dual-traseira-azul-topazio?epar=314766&opn=XMLGOOGLE&sellerId=00776574000660";
		Document codeSite = DocumentUtil.loadDocument(site);
		System.out.println("Description: "+ProductUtil.loadDescriptionByURL(codeSite, "meta[name = description]"));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		Document document = DocumentUtil.loadDocument("https://www.google.com.br/search?q="+text);
				
		List<Element> elements = DocumentUtil.loadElementsByTag(document, "a[class = plantl]");
		
		List<String> linksByGoogle = new ArrayList<String>();
		
		for (Element link : elements) {	
			
			boolean addLink = true;
			String link_ = null;
			String domain = null;
				
			while(link_ == null && domain == null) {
					
				link_ = link.attr("href");
				
				System.out.println("Link encontrado: "+link);
					
				for(String url : linksByGoogle) {
															
					while(domain == null) {
						
						URI uri = new URI(link_);
						domain = uri.getHost();
						
						if(domain != null && (url.equals(link_) || url.contains(domain))) {
							addLink = false;
							break;
						}
					}
					
					if(!addLink) {
						break;
					}
				}
			}

			if(addLink) {							
				linksByGoogle.add(link_);
			}
			
		}
		
		return linksByGoogle;
	}
}