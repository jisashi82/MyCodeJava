package org.carpetati.spring.dao;

import java.util.Optional;

import org.carpetati.spring.model.Cedis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CedisDAO extends JpaRepository<Cedis, Integer> {
	public Cedis findById(int id);
	public Optional<Cedis> findByNombreContains(String nombre);
}