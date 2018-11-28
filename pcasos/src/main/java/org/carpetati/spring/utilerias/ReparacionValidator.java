package org.carpetati.spring.utilerias;

import org.carpetati.spring.model.Reparacion;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ReparacionValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Reparacion.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "serie", "reparacion.serie.empty");
	}

}
