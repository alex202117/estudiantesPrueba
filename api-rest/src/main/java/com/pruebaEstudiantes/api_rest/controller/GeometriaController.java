package com.pruebaEstudiantes.api_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pruebaEstudiantes.api_rest.service.GeometriaService;

@RestController
@RequestMapping("/geometria")
public class GeometriaController {

    @Autowired
    private GeometriaService geometriaService;

    @GetMapping("/triangulo")
    public ResponseEntity<Object> calcularAreaTriangulo(@RequestParam String base, @RequestParam String altura) {
        try {
            double baseValue = Double.parseDouble(base);
            double alturaValue = Double.parseDouble(altura);
            double area = geometriaService.calcularAreaTriangulo(baseValue, alturaValue);
            return ResponseEntity.ok(area);
        } catch (NumberFormatException e) {
            String mensaje = "Error: los parámetros base y altura deben ser numeros.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje);
        } catch (Exception e) {
            String mensaje = "Error al calcular el área del triángulo.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensaje);
        }
    }

    @GetMapping("/circulo")
    public ResponseEntity<Object> calcularAreaCirculo(@RequestParam String radio) {
        try {
            double radioValue = Double.parseDouble(radio);
            double area = geometriaService.calcularAreaCirculo(radioValue);
            return ResponseEntity.ok(area);
        } catch (NumberFormatException e) {
            String mensaje = "Error, el parametro radio debe ser un numero.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje);
        } catch (Exception e) {
            String mensaje = "Error al calcular el rea del circulo.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensaje);
        }
    }
}