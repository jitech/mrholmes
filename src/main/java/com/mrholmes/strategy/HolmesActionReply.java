package com.mrholmes.strategy;

import java.util.Date;
import java.util.List;

import org.springframework.core.env.Environment;

import com.mrholmes.domain.Message;
import com.mrholmes.enums.MessageOrigin;
import com.mrholmes.util.StringUtil;

public interface HolmesActionReply{
	
	public List<Message> reply(String text, Environment environment) throws Exception;
	
	public default Message loadMessage(String tag, List<Object> parameters, Environment environment) throws Exception{
		
		String message = environment.getProperty(tag+"_"+environment.getProperty("language"));
		
		if(parameters != null && !parameters.isEmpty()) {			
			for(int i = 1 ; i <= parameters.size() ; i++) {
				message = message.replace("PARAM"+i, parameters.get(i-1).toString());
			}
		}
		
		return new Message(message, MessageOrigin.ROBOT, new Date());
	}
	
	public default Message loadSalute(String text, Environment environment) throws Exception{
		
		String[] salutes = environment.getProperty("SALUTE_"+environment.getProperty("language")).split(",");
				
		if(salutes != null && salutes.length > 0) {
						
			for(int i = 0 ; i < salutes.length ; i++) {			
				if(text.toLowerCase().contains(salutes[i].toLowerCase())) {
					return new Message(salutes[i], MessageOrigin.ROBOT, new Date());
				}
			}
		}
		
		return null;
	}
		
	public default String loadTextByIgnoreWords(String text, Environment environment) throws Exception{
		
		String[] ignores = StringUtil.format(environment.getProperty("IGNORE_"+environment.getProperty("language"))).split(",");
				
		String[] words = text.split(" ");
		
		if(ignores != null && ignores.length > 0 && words != null && words.length > 0) {
			
			for(int i = 0 ; i < words.length ; i++) {				
				for(int j = 0 ; j < ignores.length ; j++) {			
					if(words[i].toLowerCase().equals(ignores[j].toLowerCase())) {
						text = text.toLowerCase().replace(ignores[j].toLowerCase(), "");
					}
				}
			}
		}
		
		return text;
	}
}