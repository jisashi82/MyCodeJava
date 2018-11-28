package org.carpetati.spring.service;

import java.util.List;
import org.carpetati.spring.dao.RespaldosDAO;
import org.carpetati.spring.model.Respaldos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RespaldosServices {

	@Autowired
	private RespaldosDAO respaldosDAO;

	@Transactional
	public void save(Respaldos respaldo) {
		respaldosDAO.save(respaldo);
	}

	@Transactional(readOnly = true)
	public List<Respaldos> listAll() {
		return respaldosDAO.findAll();
	}

	@Transactional(readOnly = false)
	public void delete(int id) {
		respaldosDAO.deleteById(id);
	}

	@Transactional(readOnly = false)
	public Respaldos findById(int id) {
		return respaldosDAO.findById(id);
	}
}
