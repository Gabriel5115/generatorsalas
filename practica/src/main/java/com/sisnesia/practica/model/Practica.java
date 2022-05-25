package com.sisnesia.practica.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PRACTICAS")
public class Practica implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@TableGenerator(name = "GENERADOR",
							table="SECUENCIAS",
							pkColumnName = "NOMBRE",
							pkColumnValue = "PRACTICA_SEQ",
							valueColumnName = "VALOR",
							allocationSize = 1)
	
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "GENERADOR")
	private Integer id;
	
	private String nombre;
	private String observaciones;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHora;
	private int miembros;
	private int tSala;
	
	
	@OneToMany
	@JoinColumn(name = "ID_PRACTICA")
	private List<Sala> salas;
	
	public Practica() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public int getMiembros() {
		return miembros;
	}

	public void setMiembros(int miembros) {
		this.miembros = miembros;
	}

	public int gettSala() {
		return tSala;
	}

	public void settSala(int tSala) {
		this.tSala = tSala;
	}

	public List<Sala> getSalas() {
		return salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
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
		Practica other = (Practica) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Practica [id=" + id + ", nombre=" + nombre + ", observaciones=" + observaciones + ", fechaHora="
				+ fechaHora + ", miembros=" + miembros + ", tSala=" + tSala + ", salas=" + salas + "]";
	}
	
	
	
}
