package Trabajo_8.Ejercicio.model.dao;



import Trabajo_8.Ejercicio.model.Artista;
import Trabajo_8.Ejercicio.model.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistaDAO {

    private Connection connection;

    public ArtistaDAO() {
        connection = DatabaseConnection.getConnection();
    }

    public void insertarArtista(Artista artista) {
        // Implementar lógica para insertar un artista en la base de datos
    }

    public Artista obtenerArtistaPorId(int id) {
        // Implementar lógica para obtener un artista por su ID
        return null;
    }

    public List<Artista> obtenerTodosLosArtistas() {
        // Implementar lógica para obtener todos los artistas
        return new ArrayList<>();
    }

    public void actualizarArtista(Artista artista) {
        // Implementar lógica para actualizar un artista existente
    }

    public void eliminarArtista(int id) {
        // Implementar lógica para eliminar un artista por su ID
    }
}
