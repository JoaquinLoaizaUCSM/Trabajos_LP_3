package Trabajo_8.Ejercicio;

import Trabajo_8.Ejercicio.controller.*;
import Trabajo_8.Ejercicio.model.dao.*;
import Trabajo_8.Ejercicio.model.util.DatabaseConnection;
import Trabajo_8.Ejercicio.view.*;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            System.out.println("Failed to connect to the database.");
            return;
        }

        MainView mainView = new MainView();
        int opcion;
        int opcionAlbum;

        do {
            mainView.mostrarMenuPrincipal();
            opcion = mainView.leerOpcion();

            switch (opcion) {
                case 1:
                    // Gestión de Usuarios
                    UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
                    UsuarioView usuarioView = new UsuarioView();
                    UsuarioController usuarioController = new UsuarioController(usuarioDAO, usuarioView);
                    usuarioView.MenuUsuario();
                    int opcionUsuario = mainView.leerOpcion();
                    switch (opcionUsuario) {
                        case 1:
                            usuarioController.agregarUsuario();
                            break;
                        case 2:
                            usuarioController.mostrarUsuarios();
                            break;
                        case 3:
                            usuarioController.actualizarUsuario();
                            break;
                        case 4:
                            usuarioController.eliminarUsuario();
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Opción no válida. Intente de nuevo.");
                    }
                    break;
                case 2:
                    // Gestión de Artistas
                    ArtistaDAO artistaDAO = new ArtistaDAO(connection);
                    ArtistaView artistaView = new ArtistaView();
                    ArtistaController artistaController = new ArtistaController(artistaDAO, artistaView);
                    // Llamar a métodos del controlador de artistas
                    artistaView.MenuArtista();
                    int opcionArtista = mainView.leerOpcion();
                    switch (opcionArtista) {
                        case 1:
                            artistaController.agregarArtista();
                            break;
                        case 2:
                            artistaController.mostrarArtistas();
                            break;
                        case 3:
                            artistaController.actualizarArtista();
                            break;
                        case 4:
                            artistaController.eliminarArtista();
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Opción no válida. Intente de nuevo.");
                    }
                    break;
                case 3:
                    AlbumDAO albumDAO = new AlbumDAO(connection);
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
                    CancionDAO cancionDAO = new CancionDAO(connection);
                    CancionView cancionView = new CancionView();
                    CancionController cancionController = new CancionController(cancionDAO, cancionView);
                    // Llamar a métodos del controlador de canciones

                    cancionView.MenuCancion();
                    int opcionCancion = mainView.leerOpcion();
                    switch (opcionCancion) {
                        case 1:
                            cancionController.agregarCancion();
                            break;
                        case 2:
                            cancionController.mostrarCanciones();
                            break;
                        case 3:
                            cancionController.actualizarCancion();
                            break;
                        case 4:
                            cancionController.eliminarCancion();
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Opción no válida. Intente de nuevo.");
                    }


                    break;
                case 5:
                    ListaReproduccionDAO listaDAO = new ListaReproduccionDAO(connection);
                    ListaReproduccionView listaView = new ListaReproduccionView();
                    ListaReproduccionController listaController = new ListaReproduccionController(listaDAO, listaView);
                    // Llamar a métodos del controlador de listas de reproducción
                    listaView.MenuListaReproduccion();

                    int opcionLista = mainView.leerOpcion();

                    switch (opcionLista) {
                        case 1:
                            listaController.mostrarListasReproduccion();
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("Opción no válida. Intente de nuevo.");
                    }

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