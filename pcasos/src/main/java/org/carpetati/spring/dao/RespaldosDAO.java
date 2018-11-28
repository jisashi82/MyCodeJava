package org.carpetati.spring.dao;

import org.carpetati.spring.model.Respaldos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespaldosDAO extends JpaRepository<Respaldos, Integer> {
	public Respaldos findById(int id);
}
