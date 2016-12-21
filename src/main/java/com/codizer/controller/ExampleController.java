package com.codizer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.codizer.model.Person;

@Controller
@RequestMapping("/example")
public class ExampleController {
	
	public static final String EXAMPLE_VIEW = "example";
	
	// En la version SPRING 4.2
	// @RequestMapping(value="/exampleString", method=RequestMethod.GET)
	
	// Primera forma para insertar pocos datos
	@GetMapping("/exampleString")
	public String exampleString(Model model) {
		model.addAttribute("people", this.getPeople());
		return EXAMPLE_VIEW;
	}
	
	// Segunda forma para insertar muchos datos
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("people", this.getPeople());
		
		return mav;
	}
	
	private List<Person> getPeople() {
		
		List<Person> people = new ArrayList<>();
		people.add(new Person("Jhon", 23));
		people.add(new Person("Mikel", 30));
		people.add(new Person("Eva", 43));
		people.add(new Person("Peter", 18));
		
		return people;
	}
}
