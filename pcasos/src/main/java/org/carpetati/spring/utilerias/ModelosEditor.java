package org.carpetati.spring.utilerias;

import java.beans.PropertyEditorSupport;
import org.carpetati.spring.model.Modelos;
import org.carpetati.spring.service.ModelosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelosEditor extends PropertyEditorSupport {

	@Autowired
	private ModelosService modelosServices;
	
	@Override
	public void setAsText(String text) {
		Modelos m=this.modelosServices.findById(Integer.parseInt(text));
		this.setValue(m);
	}
}