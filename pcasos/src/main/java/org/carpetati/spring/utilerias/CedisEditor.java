package org.carpetati.spring.utilerias;

import java.beans.PropertyEditorSupport;

import org.carpetati.spring.model.Cedis;
import org.carpetati.spring.service.CedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CedisEditor extends PropertyEditorSupport{

	@Autowired
	private CedisService cedisService;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Cedis c= cedisService.findById(Integer.parseInt(text));
		this.setValue(c);
	}
}
