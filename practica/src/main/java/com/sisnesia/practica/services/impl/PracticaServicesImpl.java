package com.sisnesia.practica.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisnesia.practica.model.Practica;
import com.sisnesia.practica.model.Sala;
import com.sisnesia.practica.repositories.PracticaRepository;
import com.sisnesia.practica.repositories.SalaRepository;
import com.sisnesia.practica.services.PracticaServices;


@Service
public class PracticaServicesImpl implements PracticaServices{
	
	@Autowired
	PracticaRepository practicaRepository;
	
	@Autowired
	SalaRepository salaRepository;
	
	@Override
	@Transactional
	public Practica create(Practica practica) {
		// TODO Auto-generated method stub
		
				// pASO 1. settear a practica el timestamp
				// paso 2. crear la lista de salas en funcionde l numero de miembros y el tamaño de la sala
				// Paso 3. persistir las salas
				// Paso 4. settear las salas a la practica
				// Paso 5. Persistir la practica
				//
		
		List<Sala> salasCreada = crearTodasSalas(practica.gettSala(), practica.getMiembros());		
		
		salaRepository.saveAll(salasCreada);
		
		practica.setSalas(salasCreada);
		practica.setFechaHora(new Date());
		
		Practica practicaCreada = practicaRepository.save(practica);		
		

		
		return practicaCreada;
		
	}

	@Override
	public List<Practica> getAllPracticas() {

		return practicaRepository.findAll();
	}

	@Override
	public Practica read(int id) {
		
		Optional <Practica> optional = practicaRepository.findById(id);
		
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	@Transactional
	public boolean delete(Integer id) {
		
		boolean existe = practicaRepository.existsById(id);
		
		if (existe!= false) {
			practicaRepository.deleteById(id);
			return true;
		}	
		
		return false;
		
	}
	
	private List<Sala> crearTodasSalas(int tsala, int miembrosTotal){
		
		int numeroSalas = miembrosTotal / tsala;
		
		List<Integer> listaMiembros = new ArrayList<>(miembrosTotal);
		
		for (int i = 1; i <= miembrosTotal; i++) {
			listaMiembros.add(i);
		}
		
		Collections.shuffle(listaMiembros);
		
		List<Sala> salas = new ArrayList<>();
		
		for (int i = 0; i < numeroSalas; i++) {
			Sala sala = new Sala();
			String nombreSala = ("0" + i);
			nombreSala = nombreSala.substring(nombreSala.length() -2);
			sala.setNombre("Sala_" + nombreSala);
			int desde = i * tsala;
			int hasta = desde + tsala;
			List<Integer> salaMiembros = new ArrayList<>(listaMiembros.subList(desde, hasta));
			sala.setMiembros(salaMiembros);
			salas.add(sala);
		}
		
		int j = 0;
		
		for (int i = (numeroSalas * tsala); i < listaMiembros.size(); i++) {
			salas.get(j).getMiembros().add(listaMiembros.get(i));
			j++;
		}
		
		return salas;
		
	}

}
