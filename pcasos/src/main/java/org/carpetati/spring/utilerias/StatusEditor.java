package org.carpetati.spring.utilerias;

import java.beans.PropertyEditorSupport;
import org.carpetati.spring.model.Status;
import org.carpetati.spring.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatusEditor extends PropertyEditorSupport{
	
	@Autowired
	private StatusService statusService;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Status s= statusService.getStatusByID(Integer.parseInt(text));
		this.setValue(s);
	}

}
