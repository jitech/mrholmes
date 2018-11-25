package com.mrholmes.util;

import java.util.List;

import com.mrholmes.domain.ProductInfo;

public class IndicationUtil {

	public static Integer loadTotalIndicationByProducts(List<ProductInfo> productInfos) {
		
		try {
				Integer totalIndication = 0;
			
				for(ProductInfo productInfo : productInfos) {					
					totalIndication = totalIndication + (productInfo.getNumberOfEvaluations()*(productInfo.getNumberOfIndications())/100);				
				}
				
				return totalIndication;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
