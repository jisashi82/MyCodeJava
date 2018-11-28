package org.carpetati.spring.dao;

import java.util.List;
import java.util.Optional;
import org.carpetati.spring.model.Cedis;
import org.carpetati.spring.model.Modelos;
import org.carpetati.spring.model.Reparacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReparacionDAO extends JpaRepository<Reparacion, Integer> {
	Reparacion findById(int id);
	List<Reparacion> findBySerieContainsOrModeloOrCedis(String p, Optional<Modelos> m, Optional<Cedis> c);	
}