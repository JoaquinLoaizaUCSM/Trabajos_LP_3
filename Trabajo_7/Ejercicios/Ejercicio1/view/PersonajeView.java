package Trabajo_7.Ejercicios.Ejercicio1.view;


import Trabajo_7.Ejercicios.Ejercicio1.model.Personaje;

import java.util.Map;

public class PersonajeView {
    public void mostrarPersonaje(Personaje personaje) {
        System.out.println(personaje);
    }

    public void mostrarEstadisticas(Map<String, Double> stats) {
        System.out.println("\nEstadísticas grupales:");
        stats.forEach((k, v) -> System.out.printf("%s: %.2f%n", k, v));
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarError(String error) {
        System.err.println("Error: " + error);
    }
}