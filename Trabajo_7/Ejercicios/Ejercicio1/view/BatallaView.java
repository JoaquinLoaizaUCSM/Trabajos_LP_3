package Trabajo_7.Ejercicios.Ejercicio1.view;

import Trabajo_7.Ejercicios.Ejercicio1.model.Personaje;

public class BatallaView {
    public void mostrarInicioBatalla(Personaje p1, Personaje p2) {
        System.out.println("\n=== INICIO DE BATALLA ===");
        System.out.println("⚔️ " + p1.getNombre() + " VS " + p2.getNombre() + " ⚔️");
        mostrarEstadisticasPersonaje(p1);
        mostrarEstadisticasPersonaje(p2);
        System.out.println("=======================\n");
    }

    public void mostrarTurno(String resultado) {
        System.out.println("➤ " + resultado);
    }

    public void actualizarEstadoBatalla(Personaje p1, Personaje p2) {
        System.out.println("\nEstado actual:");
        System.out.println(p1.getNombre() + ": ❤️ " + p1.getVida());
        System.out.println(p2.getNombre() + ": ❤️ " + p2.getVida());
        System.out.println();
    }

    public void mostrarFinBatalla(Personaje ganador) {
        System.out.println("\n🏆 ¡BATALLA TERMINADA! 🏆");
        System.out.println("Ganador: " + ganador.getNombre());
        mostrarEstadisticasPersonaje(ganador);
        System.out.println("=======================\n");
    }

    private void mostrarEstadisticasPersonaje(Personaje p) {
        System.out.printf("%s: ❤️ %d 🗡️ %d 🛡️ %d%n",
            p.getNombre(), p.getVida(), p.getAtaque(), p.getDefensa());
    }

    public void mostrarError(String mensaje) {
        System.err.println("❌ Error: " + mensaje);
    }
}