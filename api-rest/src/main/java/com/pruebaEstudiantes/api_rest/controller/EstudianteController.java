package com.pruebaEstudiantes.api_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pruebaEstudiantes.api_rest.model.Estudiante;
import com.pruebaEstudiantes.api_rest.service.EstudianteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
	@Autowired
	private EstudianteService estudianteService;

	@GetMapping
	public ResponseEntity<List<Estudiante>> listarTodos() {
		try {
			List<Estudiante> estudiantes = estudianteService.listarTodos();
			return new ResponseEntity<>(estudiantes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> obtenerPorId(@PathVariable Long id) {
		try {
			Optional<Estudiante> estudiante = estudianteService.obtenerPorId(id);
			if (estudiante.isPresent()) {
				return new ResponseEntity<>(estudiante.get(), HttpStatus.OK);
			} else {
				String mensaje = "el id  " + id + " no existe.";
				return new ResponseEntity<>(mensaje, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping
	public ResponseEntity<Estudiante> guardar(@RequestBody Estudiante estudiante) {
		try {
			Estudiante nuevoEstudiante = estudianteService.guardar(estudiante);
			return new ResponseEntity<>(nuevoEstudiante, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminar(@PathVariable Long id) {
		try {
			if (estudianteService.obtenerPorId(id).isPresent()) {
				estudianteService.eliminar(id);
				return new ResponseEntity<>("Registro eliminado ", HttpStatus.NO_CONTENT);
			} else {
				String mensaje = "el registro " + id + " no existe.";
				return new ResponseEntity<>(mensaje, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
