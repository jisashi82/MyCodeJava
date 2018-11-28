package org.carpetati.spring.controller;
import org.carpetati.spring.dao.MarcasDAO;
import org.carpetati.spring.model.Marcas;
import org.carpetati.spring.model.Modelos;
import org.carpetati.spring.service.ModelosService;
import org.carpetati.spring.utilerias.MarcasEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestScope
public class ModelosController{

	private @Autowired ModelosService modelosService;	
	private @Autowired MarcasEditor marcasEditor;
	private @Autowired MarcasDAO marcasDAO;
	
	@RequestMapping(value="/modelos")
	public String modelosHome(Model model) {
		model.addAttribute("lista", modelosService.listAll());
		return "modelos";
	}
	
	@RequestMapping(value="/modelos/add")
	public String addModelo(Model model) {
		model.addAttribute("modelosForm", new Modelos());
		model.addAttribute("listadeMarcas", marcasDAO.findAll());
		model.addAttribute("titulo", "Registro de Nuevo Modelo");
		return "modelosForm";
	}
	
	@RequestMapping(value="/modelos/edit/{id}")
	public String editModelo(@PathVariable int id, Model model) {
		model.addAttribute("titulo", "Edicion de Registro Modelo");
		model.addAttribute("modelosForm", modelosService.findById(id));
		model.addAttribute("listadeMarcas", marcasDAO.findAll());
		return "modelosForm";
	}
	
	@RequestMapping(value="/modelos/delete/{id}")
	public String modelosHome(@PathVariable int id, RedirectAttributes redirect) {
		modelosService.delete(id);
		redirect.addFlashAttribute("css", "success");
		redirect.addFlashAttribute("msg", "El registro fue Borrado exitosamente!");
		return "redirect:/modelos";
	}
	
	@PostMapping("/modelos/save")
	public String saveModelo(@ModelAttribute("modelosForm") Modelos modelo, BindingResult result, RedirectAttributes redirect) {
		
		if(result.hasErrors()) {
			System.out.println(result.toString());
			return "modelosForm";
		}else {
			redirect.addFlashAttribute("css", "success");
			if(modelo.getId()==0) {
				redirect.addFlashAttribute("msg", "El registro fue guardado exitosamente!");
			}else {
				redirect.addFlashAttribute("msg", "El registro fue actualizado exitosamente!");
			}
			
			modelosService.save(modelo);
		}
		return "redirect:/modelos";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Marcas.class, marcasEditor);
	}
	
}
