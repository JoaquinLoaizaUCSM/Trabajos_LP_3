package Trabajo_8.Ejercicio.controller;

import Trabajo_8.Ejercicio.model.Cancion;
import Trabajo_8.Ejercicio.model.dao.CancionDAO;
import Trabajo_8.Ejercicio.view.CancionView;

import java.util.Scanner;


public class CancionController {

    private CancionDAO cancionDAO;
    private CancionView cancionView;

    public CancionController(CancionDAO cancionDAO, CancionView cancionView) {
        this.cancionDAO = cancionDAO;
        this.cancionView = cancionView;
    }

    public void agregarCancion() {
        // Lógica para agregar una nueva canción
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el título de la canción:");
        String titulo = scanner.nextLine();
        System.out.println("Ingrese la duración de la canción (en segundos):");
        int duracion = scanner.nextInt();
        System.out.println("Ingrese el ID del álbum al que pertenece la canción (deje en blanco si no pertenece a un álbum):");
        int albumId = scanner.nextInt();

        cancionDAO.insertarCancion(new Cancion(titulo, duracion, albumId));

    }

    public void mostrarCanciones() {
        // Lógica para mostrar todas las canciones
        cancionView.mostrarCanciones(cancionDAO.obtenerTodasLasCanciones());
    }

    public void actualizarCancion() {
        // Lógica para actualizar una canción existente

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID de la canción a actualizar: ");
        int cancionId = scanner.nextInt();

        System.out.print("Ingrese el nuevo título de la canción: ");
        String titulo = scanner.nextLine();

        System.out.print("Ingrese la nueva duración de la canción (en segundos): ");
        int duracion = scanner.nextInt();

        System.out.print("Ingrese el nuevo ID del álbum al que pertenece la canción: ");
        int albumId = scanner.nextInt();

        cancionDAO.actualizarCancion(new Cancion(cancionId, titulo, duracion, albumId));
    }

    public void eliminarCancion() {
        // Lógica para eliminar una canción
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del la cancion a eliminar: ");
        int cancionId = scanner.nextInt();
        cancionDAO.eliminarCancion(cancionId);
    }
}
