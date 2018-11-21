package com.mrholmes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagerController extends GenericController{

	@RequestMapping("/")
	private ModelAndView index(Model model) throws Exception {		
		return new ModelAndView("/index");
	}
	
	@RequestMapping("/how-i-work")
	private ModelAndView howIWork(Model model) throws Exception {		
		return new ModelAndView("/how-i-work");
	}
}