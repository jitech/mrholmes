package com.mrholmes.util;

import java.util.List;

import com.mrholmes.domain.ProductInfo;

public class Test {

	public static void main(String[] args) throws Exception {
				
		List<ProductInfo> productInfos = ShopUtil.loadProductInfosByGoogleLinks(GoogleUtil.loadLinksByGoogle("moto g6 plus"));
		
		
		System.out.println("Avaliações totais: "+EvaluationUtil.loadTotalEvaluationByProducts(productInfos));
		System.out.println("Recomendações totais: "+IndicationUtil.loadTotalIndicationByProducts(productInfos));
		
		ProductInfo productInfo = ShopUtil.loadLowerPrice(productInfos);
		
		System.out.println(productInfo);
	}
}
