package com.mrholmes.util;

import java.util.Date;
import java.util.List;

import org.springframework.core.env.Environment;

import com.mrholmes.domain.Message;
import com.mrholmes.enums.MessageOrigin;

public class MessageUtil {

	public static Message loadMessage(String tag, List<Object> parameters, Environment environment) throws Exception{
		
		String message = environment.getProperty(tag+"_"+environment.getProperty("language"));
		
		if(parameters != null && !parameters.isEmpty()) {			
			for(int i = 1 ; i <= parameters.size() ; i++) {
				message = message.replace("PARAM"+i, parameters.get(i-1).toString());
			}
		}
		
		return new Message(message, MessageOrigin.ROBOT, new Date());
	}
	
	public static Message loadSalute(String text, Environment environment) throws Exception{
		
		String[] salutes = environment.getProperty("SALUTE_"+environment.getProperty("language")).split(",");			
		String[] words = text.replaceAll("!", "").replaceAll("\\?", "").split(" ");
				
		if(salutes != null && salutes.length > 0 && words != null && words.length > 0) {		
			for(int i = 0 ; i < words.length ; i++) {				
				for(int j = 0 ; j < salutes.length ; j++) {										
					if(words[i].toLowerCase().equals(StringUtil.format(salutes[j]).toLowerCase())) {												
						return new Message("Olá!", MessageOrigin.ROBOT, new Date());
					}
				}
			}
		}
		
		return null;
	}
		
	public static Message loadHumor(String text, Environment environment) throws Exception{
		
		String[] humor = StringUtil.format(environment.getProperty("HUMOR_"+environment.getProperty("language"))).split(",");			
				
		if(humor != null && humor.length > 0) {		
			for(int i = 0 ; i < humor.length ; i++) {				
				if(text.trim().toLowerCase().equals(humor[i].trim().toLowerCase())) {
					return new Message("rs", MessageOrigin.ROBOT, new Date());
				}
			}
		}
		
		return null;
	}
		
	public static String loadTextByIgnoreWords(String text, Environment environment) throws Exception{
		
		String[] ignores = StringUtil.format(environment.getProperty("IGNORE_"+environment.getProperty("language"))).split(",");			
		String[] words = text.split(" ");
				
		if(ignores != null && ignores.length > 0 && words != null && words.length > 0) {		
			for(int i = 0 ; i < words.length ; i++) {				
				for(int j = 0 ; j < ignores.length ; j++) {										
					if(words[i].toLowerCase().equals(ignores[j].toLowerCase())) {												
						text = text.toLowerCase().replaceFirst(ignores[j].toLowerCase(), "");											
						break;
					}
				}
			}
		}
		
		return text.trim();
	}
}