package com.mrholmes.enums;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.env.Environment;

import com.mrholmes.domain.Message;
import com.mrholmes.domain.ProductInfo;
import com.mrholmes.strategy.HolmesActionReply;
import com.mrholmes.util.EvaluationUtil;
import com.mrholmes.util.GoogleUtil;
import com.mrholmes.util.IndicationUtil;
import com.mrholmes.util.MessageUtil;
import com.mrholmes.util.ShopUtil;
import com.mrholmes.util.ParameterUtil;

public enum HolmesAction implements HolmesActionReply {
	
	SAY_WELCOME("SAY_WELCOME"){		
		@Override
		public List<Message> reply(String text, Environment environment) throws Exception{
			GoogleUtil.verifyAccess();
			List<Message> messages = new ArrayList<Message>();
			messages.add(MessageUtil.loadMessage("HY", null, environment));
			messages.add(MessageUtil.loadMessage("IM_HOLMES", null, environment));
			return messages;
		}
	},
	
	SAY_EVALUATION_PRODUCT("SAY_EVALUATION_PRODUCT"){	
		@Override
		public List<Message> reply(String text, Environment environment) throws Exception{

			List<Message> messages = new ArrayList<Message>();
			
			/* Varifica se houve saldação */
			Message salute = MessageUtil.loadSalute(text, environment);
			
			if(salute != null) {
				messages.add(salute);
				
				/* Ignora alguns verbos e substantivos */
				text = MessageUtil.loadTextByIgnoreWords(text, environment);
				
				/* +1 pois foi incluido a ! junto a frase */
				if(salute.getText().length() == text.length()) {
					return messages;
				}
				
				/* Remove a saldação do texto de pesquisa */
				text = text.toLowerCase().replace(messages.get(0).getText().toLowerCase(), "");
			}
			
			/* Varifica se houve humor */
			Message humor = MessageUtil.loadHumor(text, environment);
			
			if(humor != null) {
				messages.add(humor);
				return messages;
			}
						
			/* Ignora alguns verbos e substantivos */
			text = MessageUtil.loadTextByIgnoreWords(text, environment);
			
			List<ProductInfo> productInfos = ShopUtil.loadProductInfosByGoogleLinks(GoogleUtil.loadLinksByGoogle(text));
						
			if(productInfos != null && !productInfos.isEmpty()) {
				
				ParameterUtil.add(EvaluationUtil.loadTotalEvaluationByProducts(productInfos));			
				ParameterUtil.add(productInfos.size());
				messages.add(MessageUtil.loadMessage("IFOUND_EVALUATIONS", ParameterUtil.loadParameters(), environment));
					
				ParameterUtil.add(new Double(((new Double(IndicationUtil.loadTotalIndicationByProducts(productInfos))/new Double(EvaluationUtil.loadTotalEvaluationByProducts(productInfos)))*100)).intValue());			
				messages.add(MessageUtil.loadMessage("IFOUND_INDICATIONS", ParameterUtil.loadParameters(), environment));
							
				ProductInfo productInfo = ShopUtil.loadLowerPrice(productInfos);			
				ParameterUtil.add(productInfo.getShopUrl());	
				ParameterUtil.add(productInfo.getShop());
				ParameterUtil.add(productInfo.getPrice().toString().replace(".", ","));
				messages.add(MessageUtil.loadMessage("SHOP_LOWER_PRICE", ParameterUtil.loadParameters(), environment));				
				messages.add(MessageUtil.loadMessage("OTHER_PRODUCT", null, environment));
				
			}else {
				messages.add(MessageUtil.loadMessage("UNDERSTAND", null, environment));
			}
					
			return messages;
		}
	};

	public String value;
	
	HolmesAction(String value) {
		this.value = value;
	}
}