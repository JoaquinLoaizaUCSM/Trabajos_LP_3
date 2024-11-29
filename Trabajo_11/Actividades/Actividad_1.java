package Trabajo_11.Actividades;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class Usuario implements Observer {
    private final String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void update(String mensaje) {
        System.out.println(nombre + " recibió: " + mensaje);
    }
}

class SistemaNotificaciones {
    private final List<Observer> listaObservadores = new ArrayList<>();

    public void suscribir(Observer observador) {
        listaObservadores.add(observador);
    }

    public void desuscribir(Observer observador) {
        listaObservadores.remove(observador);
    }

    public void notificarObservadores(String mensaje) {
        for (Observer observador : listaObservadores) {
            observador.update(mensaje);
        }
    }
}

public class Actividad_1 {
    public static void main(String[] args) {
        SistemaNotificaciones sistemaNotificaciones = new SistemaNotificaciones();
        Usuario persona1 = new Usuario("Joaquín");
        Usuario persona2 = new Usuario("Sebastián");

        sistemaNotificaciones.suscribir(persona1);
        sistemaNotificaciones.suscribir(persona2);

        sistemaNotificaciones.notificarObservadores("Nueva promoción");
    }
}