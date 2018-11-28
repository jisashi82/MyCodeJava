package org.carpetati.spring.service;

import java.util.List;
import java.util.Optional;

import org.carpetati.spring.dao.CedisDAO;
import org.carpetati.spring.model.Cedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CedisService {

	@Autowired private CedisDAO cedisDAO;
	
	@Transactional(readOnly=true)
	public List<Cedis> listAll(){
		return cedisDAO.findAll();
	}
	
	@Transactional
	public void save(Cedis c) {
		cedisDAO.save(c);
	}
	
	@Transactional
	public void delete(int id) {
		cedisDAO.deleteById(id);
	}
	
	@Transactional
	public Cedis findById(int id) {
		return cedisDAO.findById(id);
	}
	
	@Transactional
	public Optional<Cedis> findByNombre(String name) {
		return cedisDAO.findByNombreContains(name);
	}
	
}