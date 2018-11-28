package org.carpetati.spring.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;

@Controller
@RequestScope
public class MovactivosController {

	@Autowired private MovactivosService movactivosService;
	@Autowired private CedisService cedisService;
	@Autowired private EmpleadosService empleadosService;
	@Autowired private ModelosService modelosService;
	@Autowired private Connection connection;
	@Autowired private CedisEditor cedisEditor;
	@Autowired private EmpleadosEditor empleadosEditor;
	@Autowired private ModelosEditor modelosEditor;
	//@Autowired private ComboPooledDataSource ds1;
	// private JasperReport jasperReport;
	// @Autowired ServletContext context;
	// @Autowired private Connection connection;

	// Listar la pagina Principal de movimientos de activos
	@GetMapping("/movactivos")
	public String homeMovactivos(Model m) {
		m.addAttribute("lista", movactivosService.listAll());
		m.addAttribute("URI", "/movactivos");
		return "movactivos";
	}

	// Muestra el formulario para agregar nuevo registro
	@GetMapping("/movactivos/add")
	public String addMovactivo(Model m) {
		m.addAttribute("movactivosForm", new MovActivos());
		m.addAttribute("titulo", "Nuevo Registro de Mov. de Activos");
		populate(m);
		return "movactivosForm";
	}

	// Muestra el formulario de edicion de uno de los registros seleccionado
	@GetMapping("/movactivos/edit/{id}")
	public String editMovactivos(@PathVariable int id, Model m) {
		m.addAttribute("titulo", "Edicion de Registro de Mov. de Activos");
		populate(m);
		m.addAttribute("movactivosForm", movactivosService.findById(id));
		return "movactivosForm";
	}

	// Muestra la evidencia o archivo pdf del registro, este archivo esta guardado en la bd
	@RequestMapping(value = "/movactivos/evidencia/{id}", produces = "application/pdf")
	public void evidenciaMovactivos(@PathVariable int id, HttpServletResponse response) throws Exception {
		MovActivos mov = movactivosService.findById(id);
		// byte[] b = mov.getEvidencia().getBytes(1, (int) mov.getEvidencia().length());
		byte[] b = mov.getEvidencia();
		response.getOutputStream().write(b);
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}

	// Muestra el formato de JasperReport para imprimir
	@RequestMapping("/movactivos/formato/{id}")
	public void formatoMovactivos(@PathVariable Integer id, HttpServletResponse response) throws Exception {
		String path = this.getClass().getResource("/reportes/BitaMov.jrxml").getFile();
		System.out.println("el path::::::" + path.toString());
		JasperReport jasperReport = JasperCompileManager.compileReport(path.toString());
		Map<String, Object> params = new HashMap<>();
		params.put("Folio", id);
		byte[] reporte = null;

		try {
			reporte = JasperRunManager.runReportToPdf(jasperReport, params, connection);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		/*
		 * response.setContentType("application/pdf");
		 * response.setHeader("Content-disposition",
		 * "inline; filename=informeDemo.pdf"); response.setHeader("Cache-Control",
		 * "max-age=30"); response.setHeader("Pragma", "No-cache");
		 * response.setDateHeader("Expires", 0);
		 * response.setContentLength(reporte.length);
		 */
		response.getOutputStream().write(reporte, 0, reporte.length);
		response.getOutputStream().flush();
		response.getOutputStream().close();

	}

	@PostMapping("/movactivos/save")
	public String saveMovactivos(@ModelAttribute("movactivosForm") MovActivos movactivosForm, BindingResult result,
			RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "movactivosForm";
		} else {
			redirect.addFlashAttribute("css", "success");
			if (movactivosForm.getId() == 0) {
				redirect.addFlashAttribute("msg", "El registro fue guardado exitosamente!");
			} else {
				redirect.addFlashAttribute("msg", "El registro fue Actualizado exitosamente!");
			}

			movactivosService.save(movactivosForm);
		}
		return "redirect:/movactivos";
	}

	// Muestra la pagina para subir archivos(upload)
	@GetMapping("/movactivos/upload/{id}")
	public ModelAndView frmAddPDF(@PathVariable int id) {
		FileUpload file = new FileUpload();
		ModelAndView modelandview = new ModelAndView("movactivosFormUpload", "command", file);
		modelandview.addObject("titulo", "Adjuntar Evidencia de Mov. de Activos");
		modelandview.addObject("id", id);
		return modelandview;
	}

	// Guarda el archivo en el registro de la BD
	@PostMapping("/movactivos/save/upload")
	public String uploadFile(@Validated FileUpload file, int id, BindingResult result, RedirectAttributes redirect)
			throws IOException, SerialException, SQLException {
		if (result.hasErrors()) {
			System.out.println("validation error");
			return "movactivosFormUpload";
		} else {
			System.out.println("Fetching File");
			redirect.addFlashAttribute("msg", "El Archivo se ha guardado exitosamente!");
			MovActivos m1 = movactivosService.findById(id);
			m1.setEvidencia(file.getFile().getBytes());
			movactivosService.save(m1);
			return "redirect:/movactivos";
		}
	}

	// borrado de registro
	@GetMapping("/movactivos/delete/{id}")
	public String deleteMovactivos(@PathVariable int id, RedirectAttributes redirect) {
		movactivosService.delete(id);
		redirect.addFlashAttribute("css", "success");
		redirect.addFlashAttribute("msg", "Se ha eliminado el registro " + id);
		return "redirect:/movactivos";
	}
	
	//busqueda x activo x serie x cedis
	@GetMapping("/movactivos/search")
	public String search(Model m, @RequestParam String txtSearch) {
		if (txtSearch.equals(null) || txtSearch.equals("")) {
			m.addAttribute("lista", movactivosService.listAll());
		} else {
			m.addAttribute("lista", movactivosService.searchby(txtSearch));
		}
		return "movactivos";
	}

	private void populate(Model m) {
		m.addAttribute("listadeCedis", cedisService.listAll());
		m.addAttribute("listadeEmpleados", empleadosService.listAll());
		m.addAttribute("listadeModelos", modelosService.listAll());
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Empleados.class, empleadosEditor);
		binder.registerCustomEditor(Cedis.class, cedisEditor);
		binder.registerCustomEditor(Modelos.class, modelosEditor);
	}

}