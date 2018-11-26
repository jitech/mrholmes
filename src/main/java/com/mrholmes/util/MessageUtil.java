package com.mrholmes.util;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.env.Environment;

import com.mrholmes.domain.Message;
import com.mrholmes.enums.MessageOrigin;

public class MessageUtil {

	public static Map<String, Object> cleanText(String text, Environment environment){
		
		try {
				Map<String, Object> map = new HashMap<String, Object>();
				
				text = text.toLowerCase();
				
				
				String[] salutes = environment.getProperty("SALUTE_"+environment.getProperty("language")).split(",");	
				String[] ignores = StringUtil.format(environment.getProperty("IGNORE_"+environment.getProperty("language"))).split(",");
				
				text = text.toLowerCase();
				
				boolean isSalute = false;
				
				for(int c=0 ; c< text.length(); c++) {				
					for(int s=0 ; s<salutes.length ; s++) {					
						if(text.contains(salutes[s].toLowerCase())) {
							map.put("message", new Message(salutes[s]+"!", MessageOrigin.ROBOT, new Date()));
							isSalute = true;
							break;
						}
					}
				}
				
				/* Remove salutes */
				if(isSalute) {
					for(int c=0 ; c< text.length(); c++) {				
						for(int s=0 ; s<salutes.length ; s++) {					
							if(text.contains(salutes[s].toLowerCase())) {
								text = text.replaceAll(salutes[s].toLowerCase(), "");
							}
						}
					}
				}							
				
				/* Remove ignore caracteres */
				String wordsByText[] = text.toLowerCase().split(" ");
				for(int c=0 ; c<wordsByText.length ; c++) {
					for(int i=0 ; i<ignores.length ; i++) {					
						if(wordsByText[c].equals(ignores[i].toLowerCase())) {
							text = text.replaceAll(wordsByText[c], "");
						}
					}
				}
				
				map.put("text", text.trim());
				
				return map;
				
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public static Message loadMessage(String tag, List<Object> parameters, Environment environment) throws Exception{
		
		String message = environment.getProperty(tag+"_"+environment.getProperty("language"));
		
		if(parameters != null && !parameters.isEmpty()) {			
			for(int i = 1 ; i <= parameters.size() ; i++) {
				message = message.replace("PARAM"+i, parameters.get(i-1).toString());
			}
		}
		
		return new Message(message, MessageOrigin.ROBOT, new Date());
	}
}