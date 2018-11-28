package org.carpetati.spring.service;

import java.util.List;
import java.util.Optional;

import org.carpetati.spring.dao.CedisDAO;
import org.carpetati.spring.dao.MovactivosDAO;
import org.carpetati.spring.model.Cedis;
import org.carpetati.spring.model.MovActivos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MovactivosService {

	@Autowired private MovactivosDAO movactivosDAO;
	@Autowired private CedisDAO cedisDAO;

	@Transactional(readOnly = true)
	public List<MovActivos> listAll() {
		return movactivosDAO.findAll();
	}

	@Transactional
	public void save(MovActivos m) {
		movactivosDAO.save(m);
	}

	@Transactional
	public void delete(int id) {
		movactivosDAO.deleteById(id);
	}

	@Transactional
	public MovActivos findById(int id) {
		return movactivosDAO.findById(id);
	}

	@Transactional
	public List<MovActivos> searchby(String p) {
		Optional<Cedis> destino=cedisDAO.findByNombreContains(p);
		
		return movactivosDAO.findBySerieContainsOrActivoContainsOrDestino(p, p, destino);
	}
}