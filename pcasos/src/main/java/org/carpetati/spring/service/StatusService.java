package org.carpetati.spring.service;

import java.util.List;
import org.carpetati.spring.dao.StatusDAO;
import org.carpetati.spring.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StatusService {

	@Autowired
	@Qualifier("statusDAO")
	private StatusDAO statusDAO;

	@Transactional
	public void save(Status status) {
		statusDAO.save(status);
	}	

	@Transactional(readOnly = true)
	public List<Status> listAll() {
		return statusDAO.findAll();
	}
	
	@Transactional(readOnly=false)
	public void delete(int id) {
		statusDAO.deleteById(id);
	}
	
	@Transactional(readOnly=false)
	public Status getStatusByID(int id) {
		return statusDAO.findById(id);
	}

}