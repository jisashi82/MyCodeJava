package org.carpetati.spring.service;

import java.util.List;
import org.carpetati.spring.dao.PuestosDAO;
import org.carpetati.spring.model.Puestos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PuestosService {

	@Autowired
	PuestosDAO puestoDAO;

	@Transactional(readOnly = true)
	public List<Puestos> listAll() {
		return puestoDAO.findAll();
	}

	@Transactional
	public Puestos findById(int id) {
		return puestoDAO.findById(id);
	}

	@Transactional
	public void save(Puestos puesto) {
		puestoDAO.save(puesto);
	}

	@Transactional
	public void delete(int id) {
		puestoDAO.deleteById(id);
	}

	@Transactional
	public List<Puestos> listByName(String name) {
		return puestoDAO.findByNombreContains(name);
	}
}