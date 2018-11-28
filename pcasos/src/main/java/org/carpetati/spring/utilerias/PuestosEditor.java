package org.carpetati.spring.utilerias;

import java.beans.PropertyEditorSupport;
import org.carpetati.spring.model.Puestos;
import org.carpetati.spring.service.PuestosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PuestosEditor extends PropertyEditorSupport {

	 @Autowired
	private PuestosService puestosService;
	
	public void setAsText(String text) {
		Puestos m= this.puestosService.findById(Integer.parseInt(text));
		this.setValue(m);
	}
}