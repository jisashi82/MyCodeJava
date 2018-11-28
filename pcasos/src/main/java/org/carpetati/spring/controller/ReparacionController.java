package org.carpetati.spring.controller;

import org.carpetati.spring.model.*;
import org.carpetati.spring.service.*;
import org.carpetati.spring.utilerias.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ReparacionController {

	@Autowired private ReparacionService reparacionService;
	@Autowired private EmpleadosService empleadosService;
	@Autowired private CedisService cedisService;
	@Autowired private ModelosService modelosService;
	@Autowired private StatusService statusService;
	@Autowired private ReparacionValidator reparacionValidator;

	@GetMapping("/reparacion")
	public ModelAndView homeReparacion() {
		ModelAndView m = new ModelAndView("reparacion", "lista", reparacionService.listAll());
		return m;
	}

	@GetMapping("/reparacion/delete/{id}")
	public String deleteReparacion(@PathVariable int id, RedirectAttributes redirect) {
		reparacionService.delete(id);
		redirect.addFlashAttribute("css", "success");
		redirect.addFlashAttribute("msg", "El registro fue Borrado exitosamente!");
		return "redirect:/reparacion";
	}

	@GetMapping("/reparacion/edit/{id}")
	public String editReparacion(@PathVariable int id, Model m) {
		m.addAttribute("reparacionForm", reparacionService.findById(id));
		m.addAttribute("titulo", "Editar Registro de Reparación");
		populate(m);
		return "reparacionForm";
	}

	@GetMapping("/reparacion/add")
	public String addReparacion(Model m) {
		m.addAttribute("reparacionForm", new Reparacion());
		m.addAttribute("titulo", "Registro nuevo de Reparación");
		populate(m);
		return "reparacionForm";
	}

	@PostMapping("/reparacion/save")
	public String saveReparacion(@ModelAttribute("reparacionForm") @Validated Reparacion r, BindingResult result,
			RedirectAttributes redirect, Model m) {

		// reparacionValidator.validate(r, result);

		if (result.hasErrors()) {
			populate(m);
			return "reparacionForm";
		} else {
			redirect.addFlashAttribute("css", "success");
			if (r.getId() == 0) {
				redirect.addFlashAttribute("msg", "El registro fue guardado exitosamente!");
			} else {
				redirect.addFlashAttribute("msg", "El registro fue actualizado exitosamente!");
			}
			reparacionService.save(r);
		}
		return "redirect:/reparacion";
	}
	
	//busqueda x activo x serie x cedis
	@GetMapping("/reparacion/search")
	public String search(Model m, @RequestParam String txtSearch) {
		if (txtSearch.equals(null) || txtSearch.equals("")) {
			m.addAttribute("lista", reparacionService.listAll());
		} else {
			m.addAttribute("lista", reparacionService.searchby(txtSearch));
		}
		return "reparacion";
	}

	public void populate(Model m) {
		m.addAttribute("listadeEmpleados", empleadosService.listAll());
		m.addAttribute("listadeCedis", cedisService.listAll());
		m.addAttribute("listadeModelos", modelosService.listAll());
		m.addAttribute("listadeStatus", statusService.listAll());
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Empleados.class, new EmpleadosEditor());
		binder.registerCustomEditor(Cedis.class, new CedisEditor());
		binder.registerCustomEditor(Modelos.class, new ModelosEditor());
		binder.registerCustomEditor(Status.class, new StatusEditor());
		binder.setValidator(reparacionValidator);
	}
}
