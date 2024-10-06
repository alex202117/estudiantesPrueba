package com.pruebaEstudiantes.api_rest.service;

import org.springframework.stereotype.Service;

@Service
public class GeometriaService {

    public double calcularAreaTriangulo(double base, double altura) {
        try {
            return (base * altura) / 2;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("error al calcular el área del triangulo.");
        }
    }

    public double calcularAreaCirculo(double radio) {
        try {
            return Math.PI * radio * radio;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("error al calcular el área del circulo.");
        }
    }
}