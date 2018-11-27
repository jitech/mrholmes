package com.mrholmes.enums;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.core.env.Environment;

import com.mrholmes.domain.Message;
import com.mrholmes.domain.ProductInfo;
import com.mrholmes.strategy.HolmesActionReply;
import com.mrholmes.util.CouponUtil;
import com.mrholmes.util.GoogleUtil;
import com.mrholmes.util.IndicationUtil;
import com.mrholmes.util.MessageUtil;
import com.mrholmes.util.ParameterUtil;
import com.mrholmes.util.ProductUtil;
import com.mrholmes.util.ReviewUtil;

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
			
			Map<String, Object> map = MessageUtil.cleanText(text, environment);
			
			if(map.get("message") != null) {
				messages.add((Message) map.get("message"));
			}
			
			List<ProductInfo> productInfos = ProductUtil.loadProductInfosByGoogleLinks(map.get("text").toString(), GoogleUtil.loadLinksByGoogle(map.get("text").toString()));
			
			Integer totalReviews = ReviewUtil.loadTotalReviewByProducts(productInfos);
			Integer totalIndications = IndicationUtil.loadTotalIndicationByProducts(productInfos);
			
			if(productInfos != null && !productInfos.isEmpty()) {

				if(totalReviews > 0 && totalIndications > 0) {
					ParameterUtil.add(totalReviews);			
					ParameterUtil.add(productInfos.size());
					messages.add(MessageUtil.loadMessage("IFOUND_EVALUATIONS", ParameterUtil.loadParameters(), environment));
					
					ParameterUtil.add(new Double(((new Double(totalIndications)/new Double(totalReviews))*100)).intValue());			
					messages.add(MessageUtil.loadMessage("IFOUND_INDICATIONS", ParameterUtil.loadParameters(), environment));
							
					ProductInfo productInfo = ProductUtil.loadLowerPrice(productInfos);								
					ParameterUtil.add(productInfo.getShop());
					ParameterUtil.add(productInfo.getPrice().toString().replace(".", ","));
					ParameterUtil.add(productInfo.getShopUrl());
					messages.add(MessageUtil.loadMessage("SHOP_LOWER_PRICE", ParameterUtil.loadParameters(), environment));	
					
					String coupon = CouponUtil.loadCouponByCuponomia(productInfo.getShop());
					
					if(coupon != null && !coupon.isEmpty()) {
						ParameterUtil.add(coupon);
						messages.add(MessageUtil.loadMessage("COUPON", ParameterUtil.loadParameters(), environment));
					}
					
				}else {
					messages.add(MessageUtil.loadMessage("NOT_FOUND", null, environment));
				}
				
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