package org.carpetati.spring.dao;

import org.carpetati.spring.model.Utlmeses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtlmesesDAO extends JpaRepository<Utlmeses, Integer> {
	Utlmeses findById(int id);
}
