package org.carpetati.spring.utilerias;

import java.beans.PropertyEditorSupport;
import org.carpetati.spring.model.Empleados;
import org.carpetati.spring.service.EmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmpleadosEditor extends PropertyEditorSupport {

	@Autowired
	private EmpleadosService empleadosService;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Empleados e= empleadosService.findById(Integer.parseInt(text));
		this.setValue(e);
	}
}
