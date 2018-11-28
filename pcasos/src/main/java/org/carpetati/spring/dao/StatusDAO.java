package org.carpetati.spring.dao;

import org.carpetati.spring.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusDAO extends JpaRepository<Status, Integer> {
	Status findById(int id);
}