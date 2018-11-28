package org.carpetati.spring.controller;

import java.util.List;
import org.carpetati.spring.model.Puestos;
import org.carpetati.spring.service.PuestosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;

@Controller
@RequestScope
@RequestMapping("/puestos2")
public class PuestosController2 {

	@Autowired
	PuestosService puestosService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String gopuestos(Model model) {
		model.addAttribute("lista", puestosService.listAll());
		return "puestos2";
	}

	@RequestMapping(value = "/searchnormal")
	public String gopuestosSearch(Model m, @RequestParam String separam) {
		List<Puestos> lista = puestosService.listByName(separam);
		m.addAttribute("lista", lista);
		return "puestos2";
	}

	@RequestMapping(value = "/search")
	public String search(Model model, @Param(value = "txtSearch") String txtSearch) {
		if (txtSearch.equals(null) || txtSearch.equals("")) {
			model.addAttribute("lista", puestosService.listAll());
		} else {
			List<Puestos> lista = puestosService.listByName(txtSearch);
			model.addAttribute("lista", lista);
		}

		return "puestos2";
	}

	@RequestMapping(value = "/searchajax", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Puestos> searchajax(@RequestParam(value = "CHARS") String separam) {
		List<Puestos> lista = puestosService.listByName(separam);
		return lista;
	}

}
