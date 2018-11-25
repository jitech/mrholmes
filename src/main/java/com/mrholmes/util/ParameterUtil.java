package com.mrholmes.util;

import java.util.ArrayList;
import java.util.List;

public class ParameterUtil {

	private static List<Object> parameters;
	
	public static void add(Object value) {
		
		if(parameters == null) {
			parameters = new ArrayList<Object>();
		}
		parameters.add(value);
	}

	public static List<Object> loadParameters() {
		
		List<Object> list = new ArrayList<Object>();
		
		for(Object value : parameters) {
			list.add(value);
		}
		
		parameters = null;
		return list;
	}
}