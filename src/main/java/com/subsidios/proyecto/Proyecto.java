package com.subsidios.proyecto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Proyecto {
	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private int anioInicio;
	private int anioFin;
	
	public Proyecto() {
		super();
	}

	public Proyecto(Long id, String nombre, int anioInicio, int anioFin) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.anioInicio = anioInicio;
		this.anioFin = anioFin;
	}
	
	public Proyecto(String nombre, int anioInicio, int anioFin) {
		super();
		this.nombre = nombre;
		this.anioInicio = anioInicio;
		this.anioFin = anioFin;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String name) {
		this.nombre = name;
	}

	public int getAnioInicio() {
		return anioInicio;
	}

	public void setAnioInicio(int anioInicio) {
		this.anioInicio = anioInicio;
	}

	public int getAnioFin() {
		return anioFin;
	}

	public void setAnioFin(int anioFin) {
		this.anioFin = anioFin;
	}		
	
	@Override
	public String toString() {
		return String.format("Proyecto [nombre=%s, anioInicio=%s, anioFin=%s]", nombre, anioInicio, anioFin);
	}

}
