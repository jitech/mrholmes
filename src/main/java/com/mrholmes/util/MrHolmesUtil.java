package com.mrholmes.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MrHolmesUtil {

	private static Log log = LogFactory.getLog("Message");
	
	public static void say(String message) {
		log.info("MrHolmes say: "+message);
	}
}
