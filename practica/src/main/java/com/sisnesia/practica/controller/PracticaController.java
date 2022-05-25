package com.sisnesia.practica.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sisnesia.practica.model.Practica;
import com.sisnesia.practica.repositories.SalaRepository;
import com.sisnesia.practica.services.PracticaServices;

@RestController
public class PracticaController {
	
	@Autowired
	private PracticaServices practicaServices;
	
	@Autowired
	SalaRepository salaRepository;
	
	@GetMapping("/practica")
	public List<Practica> getAll(){
		
		return practicaServices.getAllPracticas();
		
	}
	
	@GetMapping("/practica/{id}")
	public Practica getById(@PathVariable int id){
		
		return practicaServices.read(id);
		
	}
	@Transactional
	@DeleteMapping("/practica/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		
		practicaServices.delete(id);
	}
	
	@Transactional
	@PostMapping("/practicas/create")
	public Practica crearPractica(@RequestBody Practica practica) {
		
		return practicaServices.create(practica);
	}
}
