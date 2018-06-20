package com.subsidios.incisoProyecto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.subsidios.proyecto.Proyecto;

@Entity
public class IncisoProyecto {
	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PROYECTO", nullable = false)
	@JsonIgnore
	private Proyecto proyecto;
	
	public IncisoProyecto() {
		super();
	}

	public IncisoProyecto(Long id, String nombre, Proyecto proyecto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.proyecto = proyecto;
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
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
		
}
