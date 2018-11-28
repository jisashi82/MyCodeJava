package org.carpetati.spring.controller;

import org.carpetati.spring.model.Respaldos;
import org.carpetati.spring.model.Utlmeses;
import org.carpetati.spring.service.RespaldosServices;
import org.carpetati.spring.service.UtlmesesServices;
import org.carpetati.spring.utilerias.UtlmesesEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RespaldosController {

	@Autowired
	private RespaldosServices respaldosServices;
	@Autowired
	private UtlmesesServices utlmesesServices;
	@Autowired
	private UtlmesesEditor utlmesesEditor;

	@GetMapping("/respaldos")
	public ModelAndView IndexPage(ModelAndView m) {
		m = new ModelAndView("respaldos", "lista", respaldosServices.listAll());
		return m;
	}

	@GetMapping("/respaldos/add")
	public ModelAndView AddPage(ModelAndView m) {
		m = new ModelAndView("respaldosForm", "respaldosForm", new Respaldos());
		m.addObject("titulo", "Agregar nuevo Registro");
		m.addObject("listadeMeses", utlmesesServices.listAll());
		return m;
	}

	@GetMapping("/respaldos/save")
	public ModelAndView SavePage(@ModelAttribute("respaldosForm") @Validated Respaldos resp, BindingResult result,
			RedirectAttributes redirect) {
		ModelAndView m = new ModelAndView("respaldosForm", "respaldosForm", resp);
		m.addObject("titulo", "Agregar nuevo Registro");
		m.addObject("listadeMeses", utlmesesServices.listAll());

		if (result.hasErrors()) {
			System.out.println(result.toString());
			return m;
		} else {

		}

		return m;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Utlmeses.class, utlmesesEditor);
	}

}
