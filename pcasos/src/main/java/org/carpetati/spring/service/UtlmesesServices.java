package org.carpetati.spring.service;

import java.util.List;

import org.carpetati.spring.dao.UtlmesesDAO;
import org.carpetati.spring.model.Utlmeses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UtlmesesServices {

	@Autowired
	private UtlmesesDAO utlmesesDAO;

	@Transactional
	public void save(Utlmeses utlmeses) {
		utlmesesDAO.save(utlmeses);
	}

	@Transactional(readOnly = true)
	public List<Utlmeses> listAll() {
		return utlmesesDAO.findAll();
	}

	@Transactional(readOnly = false)
	public void delete(int id) {
		utlmesesDAO.deleteById(id);
	}

	@Transactional(readOnly = false)
	public Utlmeses findById(int id) {
		return utlmesesDAO.findById(id);
	}
}
