package com.codizer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.codizer.component.ExampleComponent;
import com.codizer.service.Ejercicio5Service;

@Controller
@RequestMapping("/ejercicio")
public class Ejercicio5Controller {
	
	@Autowired
	@Qualifier("ejercicio5Service")
	private Ejercicio5Service ejercicio5Service;
	
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;

	private static final String VIEW_PATH2 = "vewpath2";
	
	@GetMapping
	public RedirectView getPath1() {
		return new RedirectView("/ejercicio/path2");
	}
	
	@GetMapping("/path2")
	public ModelAndView getPath2() {
		ejercicio5Service.showLogMessage();
		exampleComponent.sayHello();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(VIEW_PATH2);
		mav.addObject("mensaje", "Este es el mensaje de retorno");
		
		return mav;
	}
}
