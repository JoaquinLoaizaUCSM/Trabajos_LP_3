package Trabajo_8.Ejercicio.view;

import java.util.Scanner;

public class MainView {

    public void mostrarMenuPrincipal() {
        System.out.println("===== Aplicación de Streaming de Música =====");
        System.out.println("1. Gestión de Usuarios");
        System.out.println("2. Gestión de Artistas");
        System.out.println("3. Gestión de Álbumes");
        System.out.println("4. Gestión de Canciones");
        System.out.println("5. Gestión de Listas de Reproducción");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public int leerOpcion() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
