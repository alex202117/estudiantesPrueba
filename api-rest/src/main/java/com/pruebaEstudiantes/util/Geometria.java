package com.pruebaEstudiantes.util;

public class Geometria {
    public static double calcularAreaTriangulo(double base, double altura) {
        return (base * altura) / 2;
    }

    public static double calcularAreaCirculo(double radio) {
        return Math.PI * radio * radio;
    }

    public static void main(String[] args) {
        double base = 5.0;
        double altura = 10.0;
        double areaTriangulo = calcularAreaTriangulo(base, altura);
        System.out.println("el area del triangulo es: " + areaTriangulo);

        double radio = 7.0;
        double areaCirculo = calcularAreaCirculo(radio);
        System.out.println("el area del circulo es: " + areaCirculo);
    }
}