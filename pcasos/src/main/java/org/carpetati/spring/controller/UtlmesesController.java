package org.carpetati.spring.controller;

import org.carpetati.spring.service.UtlmesesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UtlmesesController {

	@Autowired
	private UtlmesesServices utlmesesServices;

	@GetMapping("/utlmeses")
	public ModelAndView indexPage(ModelAndView m) {
		m = new ModelAndView("utlmeses", "lista", utlmesesServices.listAll());
		return m;
	}
}
