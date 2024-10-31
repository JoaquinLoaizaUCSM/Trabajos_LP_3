package Trabajo_8.Ejercicio.controller;

import Trabajo_8.Ejercicio.model.Artista;
import Trabajo_8.Ejercicio.model.dao.ArtistaDAO;
import Trabajo_8.Ejercicio.view.ArtistaView;

import java.util.List;
import java.util.Scanner;

public class ArtistaController {

    private ArtistaDAO artistaDAO;
    private ArtistaView artistaView;

    public ArtistaController(ArtistaDAO artistaDAO, ArtistaView artistaView) {
        this.artistaDAO = artistaDAO;
        this.artistaView = artistaView;
    }

    public void agregarArtista() {
        // Lógica para agregar un nuevo artista
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del artista: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el género del artista: ");
        String genero = scanner.nextLine();

        System.out.print("Ingrese el país de origen del artista: ");
        String paisOrigen = scanner.nextLine();

        artistaDAO.insertarArtista(new Artista(nombre, genero, paisOrigen));


    }

    public void mostrarArtistas() {
        // Lógica para mostrar todos los artistas
        List<Artista> artistas = artistaDAO.obtenerTodosLosArtistas();
        artistaView.mostrarArtistas(artistas);
    }

    public void actualizarArtista() {
        // Lógica para actualizar un artista existente
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del artista a actualizar: ");
        int artistaId = scanner.nextInt();

        System.out.print("Ingrese el nuevo nombre del artista: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el nuevo género del artista: ");
        String genero = scanner.nextLine();

        System.out.print("Ingrese el nuevo país de origen del artista: ");
        String paisOrigen = scanner.nextLine();

        artistaDAO.actualizarArtista(new Artista(artistaId, nombre, genero, paisOrigen));
    }

    public void eliminarArtista() {
        // Lógica para eliminar un artista

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del artista a eliminar: ");
        int artistaId = scanner.nextInt();

        artistaDAO.eliminarArtista(artistaId);
    }
}
