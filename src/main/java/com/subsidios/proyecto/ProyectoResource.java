package com.subsidios.proyecto;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ProyectoResource {

	@Autowired
	private ProyectoRepository proyectoRepository;

	@GetMapping("/proyectos")
	public List<Proyecto> retrieveAllProyectos() {
		return proyectoRepository.findAll();
	}
	
	@GetMapping("/proyectos/{id}")
	public Proyecto retrieveProyecto(@PathVariable long id) {
		Optional<Proyecto> proyecto = proyectoRepository.findById(id);

		if (!proyecto.isPresent())
			throw new ProyectoNotFoundException("id-" + id);

		return proyecto.get();
	}

	@DeleteMapping("/proyectos/{id}")
	public void deleteProyecto(@PathVariable long id) {
		proyectoRepository.deleteById(id);
	}

	@PostMapping("/proyectos")
	public ResponseEntity<Object> createProyecto(@RequestBody Proyecto proyecto) {
		Proyecto savedProyecto = proyectoRepository.save(proyecto);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedProyecto.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/proyectos/{id}")
	public ResponseEntity<Object> updateProyecto(@RequestBody Proyecto proyecto, @PathVariable long id) {

		Optional<Proyecto> proyectoOptional = proyectoRepository.findById(id);

		if (!proyectoOptional.isPresent())
			return ResponseEntity.notFound().build();

		proyecto.setId(id);
		
		proyectoRepository.save(proyecto);

		return ResponseEntity.noContent().build();
	}
}
