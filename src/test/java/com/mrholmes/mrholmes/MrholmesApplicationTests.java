package com.mrholmes.mrholmes;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import com.mrholmes.domain.Message;
import com.mrholmes.enums.HolmesAction;
import com.mrholmes.util.DocumentUtil;
import com.mrholmes.util.IndicationUtil;
import com.mrholmes.util.MrHolmesUtil;
import com.mrholmes.util.PriceUtil;
import com.mrholmes.util.ReviewUtil;
import com.mrholmes.util.StringUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MrholmesApplicationTests {

	@Autowired
    public Environment environment;
	
	//@Test
	public void loadMessage1() throws Exception{
		List<Message> messages = HolmesAction.SAY_EVALUATION_PRODUCT.reply("panela elétrica walita", environment);
		
		for(Message message : messages){
			MrHolmesUtil.say(message.getText());
		}
		
		Assert.assertNotNull(messages);
	}
	
	@Test
	public void loadMessage2() throws Exception{
		
		Document document = DocumentUtil.loadDocument("https://172.217.28.4/search?q=moto g6 plus");
		
		List<Element> elements = DocumentUtil.loadElementsByTag(document, "a[class = plantl]");
				
		for (Element link : elements) {				
			System.out.println(link.attr("href"));
		}
	}
	
	//@Test
	public void loadPriceByCissaMagazine() throws Exception {
				
		Double price = PriceUtil.loadPriceByURL(DocumentUtil.loadDocument("https://www.cissamagazine.com.br/smartphone-motorola-moto-g6-plus-xt1926-indigo?utm_source=google&utm_medium=Shopping&utm_campaign=smartphone-motorola-moto-g6-plus-xt1926-indigo&inStock"), "meta[itemprop = price]");
		Integer reviews = ReviewUtil.loadQuantReviewByURL(DocumentUtil.loadDocument("https://www.cissamagazine.com.br/smartphone-motorola-moto-g6-plus-xt1926-indigo?utm_source=google&utm_medium=Shopping&utm_campaign=smartphone-motorola-moto-g6-plus-xt1926-indigo&inStock"), "meta[itemprop = reviewCount]");	
		Double indications = IndicationUtil.loadPercentIndicationsByURL(DocumentUtil.loadDocument("https://www.cissamagazine.com.br/smartphone-motorola-moto-g6-plus-xt1926-indigo?utm_source=google&utm_medium=Shopping&utm_campaign=smartphone-motorola-moto-g6-plus-xt1926-indigo&inStock"), "div[class = pct]");
		
		MrHolmesUtil.say("Dados na CissaMagazine: ");
		MrHolmesUtil.say("Price: "+price);
		MrHolmesUtil.say("Reviews: "+reviews);
		MrHolmesUtil.say("Indications: "+indications+"%");
		
		Assert.assertNotNull(price);
		Assert.assertNotNull(reviews);
		Assert.assertNotNull(indications);
	}
	
	//@Test
	public void loadPriceByAmericanas() throws Exception {
		
		Double price = PriceUtil.loadPriceByURL(DocumentUtil.loadDocument("https://www.americanas.com.br/produto/133741110/smartphone-motorola-moto-g6-plus-64gb-dual-chip-android-oreo-8-0-tela-5-9-octa-core-2-2-ghz-4g-camera-12-5mp-dual-traseira-azul-topazio?epar=%7Bifpla%3A%7B_epar%7D%7D%7Bifdyn%3A%7B_epar%7D%7D%7Bifdbm%3Ads_at_ov_db_acom%24%7BCAMPAIGN_ID%7D%7D&opn=YSMESP&sellerId=00776574000660"), "span[class = sales-price]");		
		Integer reviews = ReviewUtil.loadQuantReviewByURL(DocumentUtil.loadDocument("https://www.americanas.com.br/produto/133741110/smartphone-motorola-moto-g6-plus-64gb-dual-chip-android-oreo-8-0-tela-5-9-octa-core-2-2-ghz-4g-camera-12-5mp-dual-traseira-azul-topazio?epar=%7Bifpla%3A%7B_epar%7D%7D%7Bifdyn%3A%7B_epar%7D%7D%7Bifdbm%3Ads_at_ov_db_acom%24%7BCAMPAIGN_ID%7D%7D&opn=YSMESP&sellerId=00776574000660"), "div[class = rating-star-counter]");
		Double indications = IndicationUtil.loadPercentIndicationsByURL(DocumentUtil.loadDocument("https://www.cissamagazine.com.br/smartphone-motorola-moto-g6-plus-xt1926-indigo?utm_source=google&utm_medium=Shopping&utm_campaign=smartphone-motorola-moto-g6-plus-xt1926-indigo&inStock"), "div[class = pct]");
		
		MrHolmesUtil.say("Dados na Americanas: ");
		MrHolmesUtil.say("Price: "+price);
		MrHolmesUtil.say("Reviews: "+reviews);
		MrHolmesUtil.say("Indications: "+indications+"%");
		
		Assert.assertNotNull(price);
		Assert.assertNotNull(reviews);
		Assert.assertNotNull(indications);
	}
	
	//@Test
	public void loadPriceBySubmarino() throws Exception {
		
		Double price = PriceUtil.loadPriceByURL(DocumentUtil.loadDocument("https://www.submarino.com.br/produto/133741110/smartphone-motorola-moto-g6-plus-64gb-dual-chip-android-oreo-8-0-tela-5-9-octa-core-2-2-ghz-4g-camera-12-5mp-dual-traseira-azul-topazio?epar=314766&opn=XMLGOOGLE&sellerId=00776574000660"), "p[class = sales-price]");	
		Integer reviews = ReviewUtil.loadQuantReviewByURL(DocumentUtil.loadDocument("https://www.submarino.com.br/produto/133741110/smartphone-motorola-moto-g6-plus-64gb-dual-chip-android-oreo-8-0-tela-5-9-octa-core-2-2-ghz-4g-camera-12-5mp-dual-traseira-azul-topazio?epar=314766&opn=XMLGOOGLE&sellerId=00776574000660"), "div[class = rating-star-counter]");
		Double indications = IndicationUtil.loadPercentIndicationsByURL(DocumentUtil.loadDocument("https://www.submarino.com.br/produto/133741110/smartphone-motorola-moto-g6-plus-64gb-dual-chip-android-oreo-8-0-tela-5-9-octa-core-2-2-ghz-4g-camera-12-5mp-dual-traseira-azul-topazio?epar=314766&opn=XMLGOOGLE&sellerId=00776574000660"), "text[class = summary-stats-percentage-dial-text]");
		
		MrHolmesUtil.say("Dados no Submarino: ");
		MrHolmesUtil.say("Price: "+price);
		MrHolmesUtil.say("Reviews: "+reviews);
		MrHolmesUtil.say("Indications: "+indications+"%");
		
		Assert.assertNotNull(price);
		Assert.assertNotNull(reviews);
		Assert.assertNotNull(indications);
	}
	
	//@Test
	public void loadPriceByShopTime() throws Exception {
		
		Double price = PriceUtil.loadPriceByURL(DocumentUtil.loadDocument("https://www.shoptime.com.br/produto/133741110/smartphone-motorola-moto-g6-plus-64gb-dual-chip-android-oreo-8-0-tela-5-9-octa-core-2-2-ghz-4g-camera-12-5mp-dual-traseira-azul-topazio?pfm_carac=moto%20g6%20plus&pfm_index=0&pfm_page=search&pfm_pos=grid&pfm_type=search_page%20"), "p[class = sales-price]");		
		Integer reviews = ReviewUtil.loadQuantReviewByURL(DocumentUtil.loadDocument("https://www.shoptime.com.br/produto/133741110/smartphone-motorola-moto-g6-plus-64gb-dual-chip-android-oreo-8-0-tela-5-9-octa-core-2-2-ghz-4g-camera-12-5mp-dual-traseira-azul-topazio?pfm_carac=moto%20g6%20plus&pfm_index=0&pfm_page=search&pfm_pos=grid&pfm_type=search_page%20"), "div[class = rating-star-counter]");
		Double indications = IndicationUtil.loadPercentIndicationsByURL(DocumentUtil.loadDocument("https://www.submarino.com.br/produto/133741110/smartphone-motorola-moto-g6-plus-64gb-dual-chip-android-oreo-8-0-tela-5-9-octa-core-2-2-ghz-4g-camera-12-5mp-dual-traseira-azul-topazio?epar=314766&opn=XMLGOOGLE&sellerId=00776574000660"), "text[class = summary-stats-percentage-dial-text]");

		MrHolmesUtil.say("Dados na Shoptime: ");
		MrHolmesUtil.say("Price: "+price);
		MrHolmesUtil.say("Reviews: "+reviews);
		MrHolmesUtil.say("Indications: "+indications+"%");
		
		Assert.assertNotNull(price);
		Assert.assertNotNull(reviews);
		Assert.assertNotNull(indications);
	}
}