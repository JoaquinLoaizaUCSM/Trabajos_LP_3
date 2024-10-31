package Trabajo_8.Ejercicio;

import Trabajo_8.Ejercicio.controller.*;
import Trabajo_8.Ejercicio.model.dao.*;
import Trabajo_8.Ejercicio.model.util.DatabaseConnection;
import Trabajo_8.Ejercicio.view.*;

public class Main {

    public static void main(String[] args) {
        MainView mainView = new MainView();
        int opcion;
        int opcionAlbum;

        do {
            mainView.mostrarMenuPrincipal();
            opcion = mainView.leerOpcion();

            switch (opcion) {
                case 1:
                    // Gestión de Usuarios
                    UsuarioDAO usuarioDAO = new UsuarioDAO();
                    UsuarioView usuarioView = new UsuarioView();
                    UsuarioController usuarioController = new UsuarioController(usuarioDAO, usuarioView);
                    // Llamar a métodos del controlador de usuarios
                    break;
                case 2:
                    // Gestión de Artistas
                    ArtistaDAO artistaDAO = new ArtistaDAO();
                    ArtistaView artistaView = new ArtistaView();
                    ArtistaController artistaController = new ArtistaController(artistaDAO, artistaView);
                    // Llamar a métodos del controlador de artistas

                    break;
                case 3:
                    AlbumDAO albumDAO = new AlbumDAO();
                    AlbumView albumView = new AlbumView();
                    AlbumController albumController = new AlbumController(albumDAO, albumView);
                    albumView.MenuAlbum();
                    opcionAlbum = mainView.leerOpcion();
                    switch (opcionAlbum) {
                        case 1:
                            albumController.agregarAlbum();
                            break;
                        case 2:
                            albumController.mostrarAlbumes();
                            break;
                        case 3:
                            albumController.actualizarAlbum();
                            break;
                        case 4:
                            albumController.eliminarAlbum();
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Opción no válida. Intente de nuevo.");
                    }
                    break;
                case 4:
                    // Gestión de Canciones
                    CancionDAO cancionDAO = new CancionDAO();
                    CancionView cancionView = new CancionView();
                    CancionController cancionController = new CancionController(cancionDAO, cancionView);
                    // Llamar a métodos del controlador de canciones
                    break;
                case 5:
                    ListaReproduccionDAO listaDAO = new ListaReproduccionDAO();
                    ListaReproduccionView listaView = new ListaReproduccionView();
                    ListaReproduccionController listaController = new ListaReproduccionController(listaDAO, listaView);
                    // Llamar a métodos del controlador de listas de reproducción
                    break;
                case 6:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);

        // Cerrar la conexión a la base de datos al salir
        DatabaseConnection.closeConnection();
    }
}
