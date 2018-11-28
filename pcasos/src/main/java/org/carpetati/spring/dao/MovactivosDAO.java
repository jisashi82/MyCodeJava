package org.carpetati.spring.dao;

import java.util.List;
import java.util.Optional;
import org.carpetati.spring.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovactivosDAO extends JpaRepository<MovActivos, Integer> {
	MovActivos findById(int id);

	public List<MovActivos> findBySerieContainsOrActivoContainsOrDestino(String serie, String activo, Optional<Cedis> destino);
}