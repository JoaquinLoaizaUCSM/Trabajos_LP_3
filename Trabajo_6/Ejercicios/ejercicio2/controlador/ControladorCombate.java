package controlador;

import modelo.Jugador;
import modelo.Enemigo;
import modelo.Objeto;
import vista.VistaCombate;

import java.util.Random;
import java.util.Scanner;

public class ControladorCombate {
    private Jugador jugador;
    private Enemigo enemigo;
    private VistaCombate vista;
    private Random random;
    private Scanner scanner;

    public ControladorCombate(Jugador jugador, Enemigo enemigo, VistaCombate vista) {
        this.jugador = jugador;
        this.enemigo = enemigo;
        this.vista = vista;
        this.random = new Random();
        this.scanner = new Scanner(System.in);
    }

    public void iniciarCombate() {
        vista.mostrarMensaje("¡Comienza el combate entre " + jugador.getNombre() + " y " + enemigo.getNombre() + "!");
        while (jugador.getSaludActual() > 0 && enemigo.getSaludActual() > 0) {
            turnoJugador();
            if (enemigo.getSaludActual() > 0) {
                turnoEnemigo();
            }
            enemigo.actualizarEfectos();
            vista.actualizarEstado(jugador, enemigo);
        }
        finalizarCombate();
    }

    private void turnoJugador() {
        vista.mostrarMensaje("\nTurno de " + jugador.getNombre());
        vista.mostrarMensaje("1. Atacar");
        vista.mostrarMensaje("2. Usar objeto");
        vista.mostrarMensaje("3. Cambiar equipo");
        vista.mostrarMensaje("Elige una acción: ");

        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                int danio = jugador.atacar();
                enemigo.recibirDanio(danio);
                if (jugador.getObjetoEquipado() != null) {
                    jugador.getObjetoEquipado().aplicarEfecto(jugador, enemigo);
                }
                break;
            case 2:
                usarObjeto();
                break;
            case 3:
                cambiarEquipo();
                break;
            default:
                vista.mostrarMensaje("Opción no válida. Pierdes el turno.");
        }
    }

    private void usarObjeto() {
        vista.mostrarInventario(jugador);
        vista.mostrarMensaje("Elige un objeto para usar (0 para cancelar): ");
        int indice = scanner.nextInt();
        if (indice > 0 && indice <= jugador.getInventario().size()) {
            Objeto objeto = jugador.getInventario().get(indice - 1);
            jugador.usarObjeto(objeto, enemigo);
        } else if (indice != 0) {
            vista.mostrarMensaje("Objeto no válido. Pierdes el turno.");
        }
    }

    private void cambiarEquipo() {
        vista.mostrarInventario(jugador);
        vista.mostrarMensaje("Elige un objeto para equipar (0 para cancelar): ");
        int indice = scanner.nextInt();
        if (indice > 0 && indice <= jugador.getInventario().size()) {
            Objeto objeto = jugador.getInventario().get(indice - 1);
            jugador.setObjetoEquipado(objeto);
        } else if (indice != 0) {
            vista.mostrarMensaje("Objeto no válido. Pierdes el turno.");
        }
    }

    private void turnoEnemigo() {
        if (random.nextDouble() < 0.7) { // 70% de probabilidad de atacar
            int danio = enemigo.atacar();
            jugador.recibirDanio(danio);
        } else {
            vista.mostrarMensaje(enemigo.getNombre() + " no hace nada este turno.");
        }
    }

    private void finalizarCombate() {
        if (jugador.getSaludActual() > 0) {
            vista.mostrarMensaje("¡" + jugador.getNombre() + " ha ganado el combate!");
        } else {
            vista.mostrarMensaje("¡" + enemigo.getNombre() + " ha ganado el combate!");
        }
    }
}