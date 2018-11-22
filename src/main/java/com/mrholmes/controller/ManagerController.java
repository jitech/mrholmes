package com.mrholmes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagerController extends GenericController{

	@RequestMapping("/")
	private ModelAndView index(Model model) throws Exception {	
		model.addAttribute("page", "chat");
		model.addAttribute("showChat", true);
		return new ModelAndView("/page");
	}
	
	@RequestMapping(value = "/{page}", method = RequestMethod.GET)
	private ModelAndView loadPage(@PathVariable("page") String page, Model model) throws Exception {
		model.addAttribute("page", page);
		
		if(page.equals("chat")) {
			model.addAttribute("showChat", true);		
		}else {
			model.addAttribute("showChat", false);
		}
		
		return new ModelAndView("/page");
	}
}