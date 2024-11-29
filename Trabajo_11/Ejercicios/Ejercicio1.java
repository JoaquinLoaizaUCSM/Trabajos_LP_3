package Trabajo_11.Ejercicios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


interface Observador {
    void actualizar(String mensaje);

    void establecerFiltroNotificacion(String filtro);

    String obtenerNombre();
}

class Usuario implements Observador {
    private final String nombre;
    private final int prioridad;
    private String filtro;

    public Usuario(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.filtro = "todos";  // Por defecto recibe todas las notificaciones
    }

    @Override
    public void actualizar(String mensaje) {
        if (mensaje.contains(filtro) || filtro.equals("todos")) {
            System.out.println(nombre + " (Prioridad " + prioridad + ") recibió: " + mensaje);
        }
    }

    @Override
    public void establecerFiltroNotificacion(String filtro) {
        this.filtro = filtro;
    }

    @Override
    public String obtenerNombre() {
        return nombre;
    }

    public int obtenerPrioridad() {
        return prioridad;
    }
}

class SistemaNotificaciones {
    private final List<Observador> observadores = new ArrayList<>();

    public void suscribir(Observador observador) {
        observadores.add(observador);
        observadores.sort(Comparator.comparingInt(o -> ((Usuario) o).obtenerPrioridad()));
    }

    public void desuscribir(Observador observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores(String mensaje) {
        for (Observador observador : observadores) {
            observador.actualizar(mensaje);
        }
    }
}

// Main
public class Ejercicio1 {
    public static void main(String[] args) {
        SistemaNotificaciones sistema = new SistemaNotificaciones();

        Usuario alicia = new Usuario("Joaquin", 1);
        Usuario bob = new Usuario("Sebas", 2);
        Usuario carlos = new Usuario("Luis", 3);

        sistema.suscribir(alicia);
        sistema.suscribir(bob);
        sistema.suscribir(carlos);

        carlos.establecerFiltroNotificacion("promoción");

        sistema.notificarObservadores("¡Nueva promoción disponible!");
        sistema.notificarObservadores("¡Actualización de producto!");
    }
}
