package com.mrholmes.enums;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.env.Environment;

import com.mrholmes.domain.Message;
import com.mrholmes.domain.Score;
import com.mrholmes.strategy.HolmesActionReply;
import com.mrholmes.util.GoogleUtil;
import com.mrholmes.util.StringListUtil;

public enum HolmesAction implements HolmesActionReply {

	SAY_WELCOME("SAY_WELCOME"){		
		@Override
		public List<Message> reply(String text, Environment environment) throws Exception{			
			List<Message> messages = new ArrayList<Message>();
			messages.add(loadMessage("HY", null, environment));
			messages.add(loadMessage("IM_HOLMES", null, environment));
			return messages;
		}
	},
	
	SAY_EVALUATION_SEARCH_RESULT("SAY_EVALUATION_SEARCH_RESULT"){	
		@Override
		public List<Message> reply(String text, Environment environment) throws Exception{

			List<Message> messages = new ArrayList<Message>();
			
			/* Varifica se houve saldação */
			Message salute = loadSalute(text, environment);
			
			if(salute != null) {
				messages.add(salute);
				
				/* Ignora alguns verbos e substantivos */
				text = loadTextByIgnoreWords(text, environment);
				
				/* +1 pois foi incluido a ! junto a frase */
				if(salute.getText().length() == text.length()) {
					return messages;
				}
				
				/* Remove a saldação do texto de pesquisa */
				text = text.toLowerCase().replace(messages.get(0).getText().toLowerCase(), "");
			}
			
			/* Ignora alguns verbos e substantivos */
			text = loadTextByIgnoreWords(text, environment);

			Integer evaluations = 0;
			Integer indications = 0;
			Integer count = 0;
			
			List<Score> scores = GoogleUtil.loadScore(text);
			
			if(scores != null) {
			
				for(Score score : scores) {
					evaluations = evaluations + score.getNumberOfEvaluations();	
					indications = indications + score.getNumberOfIndications();
					count++;
				}
			
				if(!scores.isEmpty()) {			
					StringListUtil.add(evaluations.toString());
					StringListUtil.add(count.toString());
					messages.add(loadMessage("IFOUND_EVALUATIONS", StringListUtil.loadParameters(), environment));
				
					StringListUtil.add(new Double(((new Double(indications)/new Double(evaluations))*100)).intValue());
					messages.add(loadMessage("IFOUND_INDICATIONS", StringListUtil.loadParameters(), environment));
					messages.add(loadMessage("OTHER_PRODUCT", null, environment));
				
				}else {
					messages.add(loadMessage("NOT_FOUND", null, environment));
				}
			
			}else {
				messages.add(loadMessage("UNDERSTAND", null, environment));
			}
						
			return messages;
		}
	};

	public String value;
	
	HolmesAction(String value) {
		this.value = value;
	}
}