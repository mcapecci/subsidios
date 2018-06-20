package com.subsidios.incisoProyecto;

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
public class IncisoProyectoResource {

	@Autowired
	private IncisoProyectoRepository incisoProyectoRepository;

	@GetMapping("/proyectos/{idProyecto}/incisos")
	public List<IncisoProyecto> retrieveAllIncisosProyecto(@PathVariable (value = "idProyecto") long idProyecto) {
		return incisoProyectoRepository.findByProyectoId(idProyecto);
	}

	/*
	@GetMapping("/proyectos/{id}")
	public IncisoProyecto retrieveProyecto(@PathVariable long id) {
		Optional<IncisoProyecto> incisoProyecto = incisoProyectoRepository.findById(id);

		if (!incisoProyecto.isPresent())
			throw new IncisoProyectoNotFoundException("id-" + id);

		return incisoProyecto.get();
	}

	@DeleteMapping("/proyectos/{id}")
	public void deleteProyecto(@PathVariable long id) {
		incisoProyectoRepository.deleteById(id);
	}

	@PostMapping("/proyectos")
	public ResponseEntity<Object> createProyecto(@RequestBody IncisoProyecto incisoProyecto) {
		IncisoProyecto savedProyecto = incisoProyectoRepository.save(incisoProyecto);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedProyecto.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/proyectos/{id}")
	public ResponseEntity<Object> updateProyecto(@RequestBody IncisoProyecto incisoProyecto, @PathVariable long id) {

		Optional<IncisoProyecto> incisoProyectoOptional = incisoProyectoRepository.findById(id);

		if (!incisoProyectoOptional.isPresent())
			return ResponseEntity.notFound().build();

		incisoProyecto.setId(id);
		
		incisoProyectoRepository.save(incisoProyecto);

		return ResponseEntity.noContent().build();
	}
	*/
}
