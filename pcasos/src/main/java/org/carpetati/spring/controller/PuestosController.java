package org.carpetati.spring.controller;

import java.util.List;

import org.carpetati.spring.model.Puestos;
import org.carpetati.spring.service.PuestosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestScope
public class PuestosController {

	@Autowired
	PuestosService puestosService;

	@RequestMapping(value = "/puestos")
	public String gopuestos(Model model) {
		model.addAttribute("lista", puestosService.listAll());
		return "puestos";
	}

	@RequestMapping(value = "/puestos/add", method = RequestMethod.GET)
	public String showPuestosAddForm(Model model) {
		model.addAttribute("puestosForm", new Puestos());
		model.addAttribute("titulo", "Formulario de alta de Puesto");
		return "puestosForm";
	}

	@RequestMapping(value = "/puestos/edit/{id}")
	public String showPuestosEditForm(@PathVariable int id, Model model) {
		model.addAttribute("puestosForm", puestosService.findById(id));
		model.addAttribute("titulo", "Formulario de Edición de Puesto");
		return "puestosForm";
	}

	@RequestMapping(value = "/puestos/save", method = RequestMethod.POST)
	public String saveStatus(@ModelAttribute("puestosForm") Puestos puesto, BindingResult result,
			final RedirectAttributes redirect) {

		if (result.hasErrors()) {
			return "puestosForm";
		} else {
			redirect.addFlashAttribute("css", "success");
			if (puesto.getId() == 0) {
				redirect.addFlashAttribute("msg", "El registro fue guardado exitosamente!");
			} else {
				redirect.addFlashAttribute("msg", "El registro fue actualizado exitosamente!");
			}

			puestosService.save(puesto);
		}
		return "redirect:/puestos";
	}

	@RequestMapping(value = "/puestos/delete/{id}")
	public String deletePuesto(@PathVariable int id, final RedirectAttributes redirect) {
		puestosService.delete(id);
		redirect.addFlashAttribute("css", "success");
		redirect.addFlashAttribute("msg", "El registro fue borrado exitosamente!");
		return "redirect:/puestos";
	}

	@RequestMapping(value = "/puestos/search")
	public String search(Model model, @Param(value = "txtSearch") String txtSearch) {
		if (txtSearch.equals(null) || txtSearch.equals("")) {
			model.addAttribute("lista", puestosService.listAll());
		} else {
			List<Puestos> lista = puestosService.listByName(txtSearch);
			model.addAttribute("lista", lista);
		}

		return "puestos";
	}

}
