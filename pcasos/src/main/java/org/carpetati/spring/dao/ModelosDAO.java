package org.carpetati.spring.dao;

import java.util.Optional;

import org.carpetati.spring.model.Modelos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("modelosDAO")
public interface ModelosDAO extends JpaRepository<Modelos, Integer> {
	public Modelos findById(int id);	
	public Optional<Modelos> findByNombreContains(String nombre);
	public Optional<Modelos> findByNombre(String nombre);
}