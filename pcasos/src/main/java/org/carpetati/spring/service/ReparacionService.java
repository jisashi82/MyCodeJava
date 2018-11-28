package org.carpetati.spring.service;

import java.util.List;
import java.util.Optional;

import org.carpetati.spring.dao.CedisDAO;
import org.carpetati.spring.dao.ModelosDAO;
import org.carpetati.spring.dao.ReparacionDAO;
import org.carpetati.spring.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReparacionService {

	@Autowired private ReparacionDAO reparacionDAO;
	@Autowired private CedisDAO cedisDAO;
	@Autowired private ModelosDAO modelosDAO;
	
	@Transactional
	public List<Reparacion> listAll(){
		return reparacionDAO.findAll();
	}
	
	@Transactional
	public Reparacion findById(int id) {
		return reparacionDAO.findById(id);
	}
	
	@Transactional
	public void save(Reparacion r) {
		reparacionDAO.save(r);
	}
	
	@Transactional
	public void delete(int id) {
		reparacionDAO.deleteById(id);
	}
	
	@Transactional
	public List<Reparacion> searchby(String p) {
		Optional<Modelos> m= modelosDAO.findByNombre(p);
		Optional<Cedis> c= cedisDAO.findByNombreContains(p);
		return reparacionDAO.findBySerieContainsOrModeloOrCedis(p, m, c);
	}
	
}