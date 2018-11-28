package com.mrholmes.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mrholmes.controller.GenericController;
import com.mrholmes.domain.Message;
import com.mrholmes.enums.HolmesAction;
import com.mrholmes.util.MessageUtil;

@RestController
@RequestMapping(value="/mrholmes")
public class MrHolmesRestController extends GenericController {
	
	@RequestMapping(value = "/talk", method = RequestMethod.POST)
    public List<Message> talk(@RequestParam(value="topic", required = true, defaultValue = "SAY_WELCOME") String topic, @RequestParam(value="text", required = false) String text) throws Exception{ 		 
		
		try {			
				System.out.println("Acessando serviço...");
				return HolmesAction.valueOf(HolmesAction.class, topic).reply(text, environment);
						
		}catch(Exception ex) {		
			ex.printStackTrace();
			List<Message> messagesError = new ArrayList<Message>();			
			messagesError.add(MessageUtil.loadMessage("ERROR", null, environment));			
			return messagesError;
		}	
    }
}