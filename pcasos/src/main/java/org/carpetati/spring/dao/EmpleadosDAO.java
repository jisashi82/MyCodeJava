package org.carpetati.spring.dao;

import org.carpetati.spring.model.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadosDAO extends JpaRepository<Empleados, Integer> {
	Empleados findById(int id);
}