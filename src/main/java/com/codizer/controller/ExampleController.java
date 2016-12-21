package com.codizer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.codizer.component.ExampleComponent;
import com.codizer.service.ExampleService;

@Controller
@RequestMapping("/example")
public class ExampleController {
	
	public static final String EXAMPLE_VIEW = "example";
	
	// Inyectar servicio Bean
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService; // Se llama a la interface
	
	// Indica a Spring que vamos a inyectar un componente que se encuatra en su memoria
	@Autowired
	@Qualifier("exampleComponent") // Le indica a Spring el nombre del Bean que está en memoria
	private ExampleComponent exampleComponent;
	
	// En la version SPRING 4.2
	// @RequestMapping(value="/exampleString", method=RequestMethod.GET)
	
	// Primera forma para insertar pocos datos
	@GetMapping("/exampleString")
	public String exampleString(Model model) {
		exampleComponent.sayHello();
		model.addAttribute("people", exampleService.getListPeople());
		return EXAMPLE_VIEW;
	}
	
	// Segunda forma para insertar muchos datos
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("people", exampleService.getListPeople());
		
		return mav;
	}
	
}
