package org.carpetati.spring.controller;

import org.carpetati.spring.model.Status;
import org.carpetati.spring.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestScope
public class StatusController {

	@Autowired
	StatusService statusService;
	
	Status status= new Status();
	
	@GetMapping("/status")
	public String goStatus(Model model) {
		model.addAttribute("lista", statusService.listAll());
		 return "status";
	}
	
	@RequestMapping(value = "/status/delete/{id}", method = RequestMethod.GET)
	public String deleteStatus(@PathVariable int id, final RedirectAttributes redirect) {		
		
		statusService.delete(id);
		redirect.addFlashAttribute("css", "success");
		redirect.addFlashAttribute("msg", "El registro fue borrado exitosamente!");
		 
		 return "redirect:/status";
	}
	
	//Muestra el Formulario para dar de Alta
	@RequestMapping(value = "/statusadd", method = RequestMethod.GET)
	public String showStatusAddForm(Model model) {
		model.addAttribute("titulo", "Formulario de Alta de Status");
		model.addAttribute("statusForm", this.status);
		return "statusForm";
	}
	
	@RequestMapping(value="/statussave", method= RequestMethod.POST)
	public String saveStatus(@ModelAttribute("statusForm") Status status, BindingResult result, final RedirectAttributes redirect) {
		
		if(result.hasErrors()) {
			return "statusadd";
		}else {
			redirect.addFlashAttribute("css", "success");
			if(status.getId()==0) {
				redirect.addFlashAttribute("msg", "El registro fue guardado exitosamente!");
			}else {
				redirect.addFlashAttribute("msg", "El registro fue actualizado exitosamente!");
			}
			
			statusService.save(status);
		}
		return "redirect:/status";		
	}
	
	//Muestra el Formulario para Editar
	@RequestMapping(value="/status/edit/{id_status}", method = RequestMethod.GET)
	public String showStatusEditForm(@PathVariable int id_status, Model model) {
		//this.status=(Status) statusService.getStatusByID(id_status);
		model.addAttribute("statusForm",statusService.getStatusByID(id_status));
		model.addAttribute("titulo", "Formulario de Edición de Status");		
		return "statusForm";	
	}
	
}