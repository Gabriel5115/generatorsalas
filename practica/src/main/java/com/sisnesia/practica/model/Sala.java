package com.sisnesia.practica.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "SALAS")
public class Sala implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@TableGenerator(name = "GENERADOR",
									table="SECUENCIAS",
									pkColumnName = "NOMBRE",
									pkColumnValue = "SALA_SEQ",
									valueColumnName = "VALOR",
									allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "GENERADOR")
	private Integer id;
	
	private String nombre;
	
	@ElementCollection
	@JoinTable(name = "MIEMBROS",
						joinColumns = @JoinColumn(name = "ID_SALA"))
	private List<Integer> miembros;

	public Sala() {
	
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Integer> getMiembros() {
		return miembros;
	}

	public void setMiembros(List<Integer> miembros) {
		this.miembros = miembros;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Sala [nombre=" + nombre + ", miembros=" + miembros + "]";
	}

	
	
	

	
	
	
	
	
}
