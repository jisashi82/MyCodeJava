package org.carpetati.spring.utilerias;

import java.beans.PropertyEditorSupport;
import org.carpetati.spring.model.Marcas;
import org.carpetati.spring.service.MarcasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MarcasEditor extends PropertyEditorSupport {

	 @Autowired
	private MarcasService marcasService;
	
	public void setAsText(String text) {
		Marcas m= this.marcasService.findById(Integer.parseInt(text));
		this.setValue(m);
	}
}