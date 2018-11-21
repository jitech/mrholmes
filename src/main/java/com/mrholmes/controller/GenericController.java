package com.mrholmes.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class GenericController {
	
	@Autowired
    public Environment environment;
	
	public HttpSession loadSession() throws Exception{
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();
		return session;
	}
	
	public Object loadAttributeInSession(String name) throws Exception{
		HttpSession session = loadSession();
		return session.getAttribute(name);
	}
	
	public void putAttributeInSession(String name, Object value) throws Exception{
		HttpSession session = loadSession();
		session.setAttribute(name, value);
	}
	
	public String loadLanguage() throws Exception{
		return environment.getProperty("language");
	}
	
	public String loadMessageByName(String name) throws Exception{
		return environment.getProperty(name);
	}
}