import modelo.Jugador;
import modelo.Enemigo;
import modelo.Objeto;
import controlador.ControladorCombate;
import vista.VistaCombate;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear jugador
        System.out.print("Ingrese el nombre de su héroe: ");
        String nombreJugador = scanner.nextLine();
        Jugador jugador = new Jugador(nombreJugador);

        // Crear objetos
        Objeto espada = new Objeto("Espada de Fuego", 7, 3, Objeto.TipoEfecto.FUEGO);
        Objeto arco = new Objeto("Arco de Hielo", 6, 1, Objeto.TipoEfecto.HIELO);
        Objeto pocion = new Objeto("Poción de Salud", 0, 30, Objeto.TipoEfecto.CURACION);
        Objeto daga = new Objeto("Daga Venenosa", 4, 2, Objeto.TipoEfecto.VENENO);

        // Añadir objetos al inventario del jugador
        jugador.getInventario().add(espada);
        jugador.getInventario().add(arco);
        jugador.getInventario().add(pocion);
        jugador.getInventario().add(daga);

        // Equipar la espada inicialmente
        jugador.setObjetoEquipado(espada);

        // Crear enemigos
        Enemigo goblin = new Enemigo("Goblin", "Monstruo", 2);
        Enemigo orco = new Enemigo("Orco", "Monstruo", 3);
        Enemigo dragon = new Enemigo("Dragón", "Bestia", 5);

        // Crear vista y controlador
        VistaCombate vista = new VistaCombate();
        ControladorCombate controlador;

        // Mostrar inventario inicial
        vista.mostrarInventario(jugador);

        // Primer combate: Jugador vs Goblin
        System.out.println("\n--- Combate 1: " + jugador.getNombre() + " vs " + goblin.getNombre() + " ---");
        controlador = new ControladorCombate(jugador, goblin, vista);
        controlador.iniciarCombate();

        if (jugador.getSaludActual() > 0) {
            // Segundo combate: Jugador vs Orco
            System.out.println("\n--- Combate 2: " + jugador.getNombre() + " vs " + orco.getNombre() + " ---");
            controlador = new ControladorCombate(jugador, orco, vista);
            controlador.iniciarCombate();

            if (jugador.getSaludActual() > 0) {
                // Tercer combate: Jugador vs Dragón
                System.out.println("\n--- Combate Final: " + jugador.getNombre() + " vs " + dragon.getNombre() + " ---");
                controlador = new ControladorCombate(jugador, dragon, vista);
                controlador.iniciarCombate();

                if (jugador.getSaludActual() > 0) {
                    System.out.println("\n¡Felicidades! " + jugador.getNombre() + " ha derrotado a todos los enemigos.");
                }
            }
        }

        if (jugador.getSaludActual() <= 0) {
            System.out.println("\n" + jugador.getNombre() + " ha sido derrotado. Fin del juego.");
        }

        // Mostrar inventario final
        vista.mostrarInventario(jugador);

        scanner.close();
    }
}