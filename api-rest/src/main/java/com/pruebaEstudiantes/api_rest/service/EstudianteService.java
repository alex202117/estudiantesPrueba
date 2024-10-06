package com.pruebaEstudiantes.api_rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaEstudiantes.api_rest.model.Estudiante;
import com.pruebaEstudiantes.api_rest.repository.EstudianteRepository;


import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {
    private static EstudianteService instance;

    @Autowired
    private EstudianteRepository estudianteRepository;

    private EstudianteService() {
        // Constructor privado para evitar instanciación
    }

    public static synchronized EstudianteService getInstance() {
        if (instance == null) {
            instance = new EstudianteService();
        }
        return instance;
    }

    public List<Estudiante> listarTodos() {
        try {
            return estudianteRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al listar los estudiantes");
        }
    }

    public Optional<Estudiante> obtenerPorId(Long id) {
        try {
            return estudianteRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener el estudiante con ID: " + id);
        }
    }

    public Estudiante guardar(Estudiante estudiante) {
        try {
            return estudianteRepository.save(estudiante);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al guardar el estudiante");
        }
    }

    public void eliminar(Long id) {
        try {
            estudianteRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar el estudiante con ID: " + id);
        }
    }
}