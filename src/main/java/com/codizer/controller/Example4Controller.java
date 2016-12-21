package com.codizer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example4")
public class Example4Controller {
	
	public static final String VIEW_404 = "404";
	public static final String VIEW_500 = "500";
	
	@GetMapping("/404")
	public ModelAndView example4() {
		return new ModelAndView(VIEW_404);
	}
	
	@GetMapping("/500")
	public String example4Error() {
		return VIEW_500;
	}

}
