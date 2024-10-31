package Trabajo_8.Ejercicio.view;

import Trabajo_8.Ejercicio.model.Album;
import java.util.List;
import Trabajo_8.Ejercicio.model.dao.AlbumDAO;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AlbumView {
    public void MenuAlbum() {
        System.out.println("Menú de Álbumes");
        System.out.println("1. Agregar Álbum");
        System.out.println("2. Mostrar Álbumes");
        System.out.println("3. Actualizar Álbum");
        System.out.println("4. Eliminar Álbum");
        System.out.println("5. Regresar al menú principal");
    }
     public void mostrarAlbumes(List<Album> albumes) {
        for (Album album : albumes) {
            System.out.println("ID: " + album.getAlbumId() + ", Nombre: " + album.getNombre() +
                    ", Fecha de Lanzamiento: " + album.getFechaLanzamiento() + ", Género: " + album.getGenero());
        }
    }
    public Album ingresarDatosAlbum() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del álbum: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la fecha de lanzamiento (YYYY-MM-DD): ");
        String fechaLanzamientoStr = scanner.nextLine();
        System.out.print("Ingrese el género del álbum: ");
        String genero = scanner.nextLine();

        Album album = new Album();
        album.setNombre(nombre);
        try {
            Date fechaLanzamiento = new SimpleDateFormat("yyyy-MM-dd").parse(fechaLanzamientoStr);
            album.setFechaLanzamiento(fechaLanzamiento);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Fecha de lanzamiento inválida.");
        }
        album.setGenero(genero);
        return album;
    }
    public int solicitarIdAlbum() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del álbum: ");
        return scanner.nextInt();
    }
    public Album capturarDatosActualizadosAlbum(Album album) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nuevo nombre del álbum (actual: " + album.getNombre() + "): ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la nueva fecha de lanzamiento (actual: " + album.getFechaLanzamiento() + "): ");
        String fechaLanzamientoStr = scanner.nextLine();
        System.out.print("Ingrese el nuevo género del álbum (actual: " + album.getGenero() + "): ");
        String genero = scanner.nextLine();

        album.setNombre(nombre);
        try {
            Date fechaLanzamiento = new SimpleDateFormat("yyyy-MM-dd").parse(fechaLanzamientoStr);
            album.setFechaLanzamiento(fechaLanzamiento);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Fecha de lanzamiento inválida.");
        }
        album.setGenero(genero);
        return album;
    }
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    public void mostrarAlbum(Album album) {
        System.out.println("ID: " + album.getAlbumId() + ", Nombre: " + album.getNombre() +
                ", Fecha de Lanzamiento: " + album.getFechaLanzamiento() + ", Género: " + album.getGenero());
    }

    public Album obtenerDatosAlbumPorId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del álbum: ");
        int albumId = scanner.nextInt();
        AlbumDAO albumDAO = new AlbumDAO();
        Album album = albumDAO.obtenerAlbumPorId(albumId);
        return album;
    }
    public Album obtenerDatosAlbum() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del álbum: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la fecha de lanzamiento (YYYY-MM-DD): ");
        String fechaLanzamiento = scanner.nextLine();
        System.out.print("Ingrese el género del álbum: ");
        String genero = scanner.nextLine();

        Album album = new Album();
        album.setNombre(nombre);
        //album.setFechaLanzamiento(new Date);
        album.setGenero(genero);

        return album;
    }

    public int obtenerIdAlbum() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del álbum: ");
        return scanner.nextInt();
    }

    public void eliminarAlbum() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del álbum: ");
        int albumId = scanner.nextInt();
        AlbumDAO albumDAO = new AlbumDAO();
        albumDAO.eliminarAlbum(albumId);
        System.out.println("Álbum eliminado exitosamente.");
    }
}
