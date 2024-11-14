package Trabajo_7.Ejercicios.Ejercicio1;

import Trabajo_7.Ejercicios.Ejercicio1.controller.*;
import Trabajo_7.Ejercicios.Ejercicio1.model.*;
import Trabajo_7.Ejercicios.Ejercicio1.view.*;

public class Main {
    public static void main(String[] args) {
        // Inicializar vistas y controladores
        PersonajeView personajeView = new PersonajeView();
        BatallaView batallaView = new BatallaView();
        PersonajeController personajeController = new PersonajeController(personajeView);
        BatallaController batallaController = new BatallaController(batallaView);

        try {

            Personaje guerrero = new Personaje("Guerrero", 100, 20, 15, 30);
            Personaje mago = new Personaje("Mago", 80, 30, 10, 50);
            Personaje arquero = new Personaje("Arquero", 90, 25, 20, 25);


            batallaController.iniciarBatalla(guerrero, mago);
            batallaController.simularBatallaCompleta();

        } catch (Exception e) {
            personajeView.mostrarError("Error durante la ejecución: " + e.getMessage());
        }
    }
}