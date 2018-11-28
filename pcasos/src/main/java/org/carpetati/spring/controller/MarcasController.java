package org.carpetati.spring.controller;

import org.carpetati.spring.model.Marcas;
import org.carpetati.spring.service.MarcasService;
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
public class MarcasController {

	@Autowired
	private MarcasService marcasService;
	
	@RequestMapping(value="/marcas")
	public String marcasHome(Model model) {
		model.addAttribute("lista", marcasService.listAll());
		return "marcas";
	}
	
	@RequestMapping(value="/marcas/add")
	public String addMarca(Model model) {
		model.addAttribute("titulo", "Registro Nuevo de Marcas");
		model.addAttribute("marcaForm", new Marcas());		
		return "marcasForm";		
	}
	
	@RequestMapping(value="/marcas/delete/{id}")
	public String deleteMarca(@PathVariable int id, final RedirectAttributes redirect) {
		marcasService.delete(id);
		redirect.addFlashAttribute("css", "success");
		redirect.addFlashAttribute("msg", "El registro fue borrado exitosamente!");	
		return "redirect:/marcas";
	}
	
	@RequestMapping(value="/marcas/edit/{id}")
	public String editMarca(@PathVariable int id, Model model) {
		model.addAttribute("titulo", "Edicion de Registro Marcas");
		model.addAttribute("marcaForm", marcasService.findById(id));
		return "marcasForm";		
	}
	
	@RequestMapping(value="/marcas/save", method=RequestMethod.POST)
	public String saveMarca(@ModelAttribute("marcaForm") Marcas marca, BindingResult result, final RedirectAttributes redirect) {
		if(result.hasErrors()) {
			return "marcaForm";
		}else {
			redirect.addFlashAttribute("css", "success");
			if(marca.getId()==0) {
				redirect.addFlashAttribute("msg", "El registro fue guardado exitosamente!");
			}else {
				redirect.addFlashAttribute("msg", "El registro fue actualizado exitosamente!");
			}
			
			marcasService.save(marca);
		}
		return "redirect:/marcas";		
	}
	
}
