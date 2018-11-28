package org.carpetati.spring.controller;

import org.carpetati.spring.model.Cedis;
import org.carpetati.spring.service.CedisService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CedisController {

	@Autowired
	private CedisService cedisService;
	
	@RequestMapping(value="/cedis")
	public String cedisHome(Model model) {
		model.addAttribute("lista", cedisService.listAll());
		return "cedis";
	}
	
	@RequestMapping(value="/cedis/add")
	public String addMarca(Model model) {
		model.addAttribute("titulo", "Registro Nuevo de Cedis");
		model.addAttribute("cedisForm", new Cedis());		
		return "cedisForm";		
	}
	
	@RequestMapping(value="/cedis/delete/{id}")
	public String deleteMarca(@PathVariable int id, final RedirectAttributes redirect) {
		cedisService.delete(id);
		redirect.addFlashAttribute("css", "success");
		redirect.addFlashAttribute("msg", "El registro fue borrado exitosamente!");	
		return "redirect:/cedis";
	}
	
	@RequestMapping(value="/cedis/edit/{id}")
	public String editMarca(@PathVariable int id, Model model) {
		model.addAttribute("titulo", "Edicion de Registro Cedis");
		model.addAttribute("cedisForm", cedisService.findById(id));
		return "cedisForm";		
	}
	
	@RequestMapping(value="/cedis/save", method=RequestMethod.POST)
	public String saveMarca(@ModelAttribute("cedisForm") Cedis marca, BindingResult result, final RedirectAttributes redirect) {
		if(result.hasErrors()) {
			return "marcaForm";
		}else {
			redirect.addFlashAttribute("css", "success");
			if(marca.getId()==0) {
				redirect.addFlashAttribute("msg", "El registro fue guardado exitosamente!");
			}else {
				redirect.addFlashAttribute("msg", "El registro fue actualizado exitosamente!");
			}
			
			cedisService.save(marca);
		}
		return "redirect:/cedis";		
	}
	
}
