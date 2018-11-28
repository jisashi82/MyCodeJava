package org.carpetati.spring.controller;

import org.carpetati.spring.model.Empleados;
import org.carpetati.spring.model.Puestos;
import org.carpetati.spring.service.EmpleadosService;
import org.carpetati.spring.service.PuestosService;
import org.carpetati.spring.utilerias.PuestosEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmpleadosController {

	@Autowired private EmpleadosService empleadosService;
	@Autowired private PuestosService puestosServices;
	@Autowired PuestosEditor puestosEditor;
		
	@GetMapping("/empleados")
	public ModelAndView goHomeEmpleados() {
		return new ModelAndView("empleados", "lista", empleadosService.listAll());		
	}
	
	@GetMapping("/empleados/add")
	public ModelAndView addEmpleadosForm() {
		ModelAndView m= new ModelAndView("empleadosForm", "empleadosForm", new Empleados());
		m.addObject("listadePuestos", puestosServices.listAll());
		m.addObject("titulo", "Nuevo Registro de Empleado");
		return m;
	}
	
	@GetMapping("/empleados/edit/{id}")
	public ModelAndView editEmpleadoForm(@PathVariable int id, ModelAndView m) {
		m.setViewName("empleadosForm");
		m.addObject("titulo", "Edicion de Registro de Empleado");
		m.addObject("empleadosForm", empleadosService.findById(id));
		m.addObject("listadePuestos", puestosServices.listAll());
		return m;
	}
	
	@GetMapping("/empleados/delete/{id}")
	public String deleteEmpleado(@PathVariable int id, RedirectAttributes redirect) {
		empleadosService.delete(id);
		redirect.addFlashAttribute("css", "success");
		redirect.addFlashAttribute("msg", "El registro fue borrado exitosamente!");	
		return "redirect:/empleados";
	}
	
	@PostMapping("/empleados/save")
	public String saveEmpleado(@ModelAttribute("EmpleadosForm") @Validated Empleados emp, BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors()) {
			System.out.println(result.toString());
			return "modelosForm";
		}else {
			redirect.addFlashAttribute("css", "success");
			if(emp.getId()==0) {
				redirect.addFlashAttribute("msg", "El registro fue guardado exitosamente!");
			}else {
				redirect.addFlashAttribute("msg", "El registro fue actualizado exitosamente!");
			}
			
			empleadosService.save(emp);
		}
		return "redirect:/empleados";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Puestos.class, puestosEditor);
	}
	
}
