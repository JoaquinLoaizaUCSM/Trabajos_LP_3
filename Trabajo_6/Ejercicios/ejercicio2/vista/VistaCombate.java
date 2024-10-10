package vista;

import modelo.Jugador;
import modelo.Enemigo;
import modelo.Objeto;

public class VistaCombate {
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void actualizarEstado(Jugador jugador, Enemigo enemigo) {
        System.out.println("\n------ Estado del Combate ------");
        System.out.println(jugador.getNombre() + " - Salud: " + jugador.getSaludActual());
        System.out.println(enemigo.getNombre() + " - Salud: " + enemigo.getSaludActual());
        System.out.println("--------------------------------");
    }

    public void mostrarInventario(Jugador jugador) {
        System.out.println("\nInventario de " + jugador.getNombre() + ":");
        for (int i = 0; i < jugador.getInventario().size(); i++) {
            Objeto objeto = jugador.getInventario().get(i);
            System.out.println((i + 1) + ". " + objeto.getNombre() +
                    " (Daño: " + objeto.getDanioBase() +
                    ", Efecto: " + objeto.getTipoEfecto() + ")");
        }
        System.out.println("Objeto equipado: " +
                (jugador.getObjetoEquipado() != null ?
                        jugador.getObjetoEquipado().getNombre() : "Ninguno"));
    }
}