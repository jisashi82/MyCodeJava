package org.carpetati.spring.dao;

import org.carpetati.spring.model.Marcas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("marcasDAO")
public interface MarcasDAO extends JpaRepository<Marcas, Integer> {
	//Optional<Marcas> findById(int id);
	Marcas findById(int id);
}