package org.carpetati.spring.service;

import java.util.List;

import org.carpetati.spring.dao.MarcasDAO;
import org.carpetati.spring.model.Marcas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MarcasService {

	@Autowired
	private MarcasDAO marcasDAO;

	@Transactional(readOnly=true)
	public List<Marcas> listAll(){
		return marcasDAO.findAll();
	}
	
	@Transactional
	public void save(Marcas marca) {
		marcasDAO.save(marca);
	}
	
	@Transactional
	public void delete(int id) {
		marcasDAO.deleteById(id);
	}
	
	@Transactional
	public Marcas findById(int id) {
		return marcasDAO.findById(id);
	}
}