package com.mrholmes.util;

import java.net.SocketTimeoutException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.mrholmes.domain.Ecommerce;
import com.mrholmes.domain.Score;

public class GoogleUtil {

	public static List<Score> loadScore(String what) {
		
		try {
				Document doc = Jsoup.connect("https://www.google.com.br/search?q="+what).userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36").get();

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
								
				if(!linksByGoogle.isEmpty()) {
					
					List<Ecommerce> ecommerces = new ArrayList<Ecommerce>();
					
					Ecommerce submarino = new Ecommerce("submarino.com.br");
					String[] tags1 = {"<text x=\"50%\" y=\"60%\" class=\"summary-stats-percentage-dial-text\" text-anchor=\"middle\">", "<!-- -->%", "</text>"};
					submarino.createPercentHtmlTag("summary-stats-percentage-dial-text", tags1);
					String[] tags2 = {"<div class=\"rating-star-counter\">", "</div>", "(", ")"};
					submarino.createRatingHtmlTag("rating-star-counter", tags2);								
					ecommerces.add(submarino);
					
					Ecommerce americanas = new Ecommerce("americanas.com.br");
					String[] tags3 = {"<text x=\"50%\" y=\"60%\" class=\"summary-stats-percentage-dial-text\" text-anchor=\"middle\">", "<!-- -->%", "</text>"};
					americanas.createPercentHtmlTag("summary-stats-percentage-dial-text", tags3);
					String[] tags4 = {"<div class=\"rating-star-counter\">", "</div>", "(", ")"};
					americanas.createRatingHtmlTag("rating-star-counter", tags4);								
					ecommerces.add(americanas);
					
					Ecommerce shoptime = new Ecommerce("shoptime.com.br");
					String[] tags5 = {"<text x=\"50%\" y=\"60%\" class=\"summary-stats-percentage-dial-text\" text-anchor=\"middle\">", "<!-- -->%", "</text>"};
					shoptime.createPercentHtmlTag("summary-stats-percentage-dial-text", tags5);
					String[] tags6 = {"<div class=\"rating-star-counter\">", "</div>", "(", ")"};
					shoptime.createRatingHtmlTag("rating-star-counter", tags6);								
					ecommerces.add(shoptime);
					
					Ecommerce cissamagazine = new Ecommerce("cissamagazine.com.br");
					String[] tags7 = {"<div class=\"pct\">", "%", "</div>"};
					cissamagazine.createPercentHtmlTag("pct", tags7);
					String[] tags8 = {"<div class=\"baseado-em\">", "com base em", "avaliações", "</div>"};
					cissamagazine.createRatingHtmlTag("baseado-em", tags8);								
					ecommerces.add(cissamagazine);
					
					Ecommerce pontofrio = new Ecommerce("pontofrio.com.br");
					String[] tags9 = {"<p class=\"pr-snapshot-consensus-value pr-rounded\">", "%", "</p>"};
					pontofrio.createPercentHtmlTag("pr-snapshot-consensus-value", tags9);
					String[] tags10 = {"<p id=\"pr-review-count\" class=\"pr-review-count\">Avaliado por ", "clientes</p>"};
					pontofrio.createRatingHtmlTag("pr-review-count", tags10);								
					ecommerces.add(pontofrio);
								
					List<Score> scores = new ArrayList<Score>();
										
					for(String linkByGoogle : linksByGoogle) {					
						//MrHolmesUtil.say("Verify link: "+linkByGoogle);
						
						for(Ecommerce ecommerce : ecommerces) {
						
							if(linkByGoogle.contains(ecommerce.getUrl())) {
								MrHolmesUtil.say("Accessing content in "+linkByGoogle);
								
								try {
										doc = Jsoup.connect(linkByGoogle).timeout(6000).get();
									
										List<Element> elementsByRating = doc.getElementsByClass(ecommerce.getRatingHtmlTag().getCssName());
										List<Element> elementsByPercent = doc.getElementsByClass(ecommerce.getPercentHtmlTag().getCssName());
									
										if(elementsByRating != null && !elementsByRating.isEmpty() && elementsByPercent != null && !elementsByPercent.isEmpty()) {
										
											Integer quantity = 0;
											Double percent = 0.0;
																			
											String ratingByTag = elementsByRating.get(0).toString();
											String percentByTag = elementsByPercent.get(0).toString();
																			
											for(int i=0 ; i<ecommerce.getRatingHtmlTag().getTags().length ; i++) {
												String tag = ecommerce.getRatingHtmlTag().getTags()[i];
												ratingByTag = ratingByTag.replace(tag,"");
											}
		
											quantity = Integer.parseInt(ratingByTag.replaceAll(" ", "").trim());									
		
											for(int i=0 ; i<ecommerce.getPercentHtmlTag().getTags().length ; i++) {
												String tag = ecommerce.getPercentHtmlTag().getTags()[i];										
												percentByTag = percentByTag.replace(tag,"");
											}
										
											percentByTag = percentByTag.replaceAll(" ", "").trim();
										
											percent = Double.parseDouble(percentByTag);								
																		
											Double x = (quantity * (percent)/100);
							
											//MrHolmesUtil.say("Quantity: "+quantity+ " - Indications: "+x.intValue());
											scores.add(new Score(doc.title(), quantity, x.intValue()));
										}
																	
								}catch(SocketTimeoutException ex) {									
									//MrHolmesUtil.say("Não consegui acessar! Time out");
								}
							}else {
								MrHolmesUtil.say("Site not mapped "+linkByGoogle);
							}
						}
					}
					
					return scores;
				}
					
				return null;
		
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}