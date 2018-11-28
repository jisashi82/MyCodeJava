package org.carpetati.spring.dao;

import java.util.List;

import org.carpetati.spring.model.Puestos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuestosDAO extends JpaRepository<Puestos, Integer> {
	Puestos findById(int id);

	// public List<Puestos> listPuestoByName(String name);

	public List<Puestos> findByNombreContains(String name);

}