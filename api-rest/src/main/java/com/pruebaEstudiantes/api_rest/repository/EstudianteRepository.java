package com.pruebaEstudiantes.api_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebaEstudiantes.api_rest.model.Estudiante;


public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
