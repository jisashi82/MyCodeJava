package org.carpetati.spring.utilerias;

import java.beans.PropertyEditorSupport;

import org.carpetati.spring.service.UtlmesesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UtlmesesEditor extends PropertyEditorSupport {

	@Autowired
	private UtlmesesServices utlmesesServices;

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		super.setValue(this.utlmesesServices.findById(Integer.parseInt(text)));
	}
}