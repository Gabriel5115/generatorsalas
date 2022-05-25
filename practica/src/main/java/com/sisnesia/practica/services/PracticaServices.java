package com.sisnesia.practica.services;

import java.util.List;

import com.sisnesia.practica.model.Practica;



public interface PracticaServices {
	
	Practica create(Practica practica);
	
	List<Practica> getAllPracticas();
	
	Practica read(int id);
	
	boolean delete(Integer id);
	
	
}
