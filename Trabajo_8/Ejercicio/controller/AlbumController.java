package Trabajo_8.Ejercicio.controller;

import Trabajo_8.Ejercicio.model.dao.AlbumDAO;
import Trabajo_8.Ejercicio.view.AlbumView;
import Trabajo_8.Ejercicio.model.Album;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class AlbumController {
    private AlbumDAO albumDAO;
    private AlbumView albumView;

    public AlbumController(AlbumDAO albumDAO, AlbumView albumView) {
        this.albumDAO = albumDAO;
        this.albumView = albumView;
    }

    public void agregarAlbum() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del álbum: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la fecha de lanzamiento (YYYY-MM-DD): ");
        String fechaLanzamientoStr = scanner.nextLine();

        System.out.print("Ingrese el género del álbum: ");
        String genero = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fechaLanzamiento = null;
        try {
            fechaLanzamiento = dateFormat.parse(fechaLanzamientoStr);

        } catch (ParseException e) {
            e.printStackTrace();
            return; // Exit the method if the date is invalid
        }

        Album album = new Album();
        album.setNombre(nombre);
        album.setFechaLanzamiento(new java.sql.Date(fechaLanzamiento.getTime()));
        album.setGenero(genero);

        albumDAO.insertarAlbum(album);
    }

    public void mostrarAlbumes() {
        List<Album> albums = albumDAO.obtenerTodosLosAlbumes();
        albumView.mostrarAlbumes(albums);
    }

    public void actualizarAlbum() {
        Scanner scanner = new Scanner(System.in);
        int albumId = scanner.nextInt();
        Album album = albumDAO.obtenerAlbumPorId(albumId);

        if (album == null) {
            albumView.mostrarMensaje("Álbum no encontrado.");
        }
    }
    public void eliminarAlbum() {
        Scanner scanner = new Scanner(System.in);
        int albumId = scanner.nextInt();

        albumDAO.eliminarAlbum(albumId);
        albumView.mostrarMensaje("Álbum eliminado exitosamente.");
    }
}
