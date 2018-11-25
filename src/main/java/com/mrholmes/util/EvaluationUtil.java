package com.mrholmes.util;

import java.util.List;

import com.mrholmes.domain.ProductInfo;

public class EvaluationUtil {

	public static Integer loadTotalEvaluationByProducts(List<ProductInfo> productInfos) {
		
		try {
				Integer totalEvaluation = 0;
			
				for(ProductInfo productInfo : productInfos) {
					totalEvaluation = totalEvaluation + productInfo.getNumberOfEvaluations();
				}
				
				return totalEvaluation;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
