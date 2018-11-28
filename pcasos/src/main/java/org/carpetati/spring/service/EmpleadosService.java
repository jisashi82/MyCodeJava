package org.carpetati.spring.service;

import java.util.List;

import org.carpetati.spring.dao.EmpleadosDAO;
import org.carpetati.spring.model.Empleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmpleadosService {

	@Autowired
	private EmpleadosDAO empleadosDAO;
	
	@Transactional(readOnly=true)
	public List<Empleados> listAll(){
		return empleadosDAO.findAll();
	}
	
	@Transactional
	public void save(Empleados e) {
		empleadosDAO.save(e);
	}
	
	@Transactional
	public void delete(int id) {
		empleadosDAO.deleteById(id);
	}
	
	@Transactional
	public Empleados findById(int id) {
		return empleadosDAO.findById(id);
	}
	
}