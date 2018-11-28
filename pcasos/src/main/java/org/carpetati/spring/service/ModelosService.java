package org.carpetati.spring.service;

import java.util.List;

import org.carpetati.spring.dao.ModelosDAO;
import org.carpetati.spring.model.Modelos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ModelosService {

	@Autowired
	private ModelosDAO modelosDAO;
		
	@Transactional(readOnly=true)
	public List<Modelos> listAll(){
		return modelosDAO.findAll();
	}
	
	@Transactional
	public void save(Modelos modelo) {
		modelosDAO.save(modelo);
	}
	
	@Transactional
	public void delete(int id) {
		modelosDAO.deleteById(id);
	}
	
	@Transactional
	public Modelos findById(int id) {
		return modelosDAO.findById(id);
	}
	
}