package com.sisnesia.practica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisnesia.practica.model.Practica;


public interface PracticaRepository extends JpaRepository<Practica, Integer>{
	
	
}
