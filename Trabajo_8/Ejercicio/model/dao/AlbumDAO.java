package Trabajo_8.Ejercicio.model.dao;



import Trabajo_8.Ejercicio.model.Album;
import Trabajo_8.Ejercicio.model.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAO {

    private Connection connection;

    public AlbumDAO() {
        connection = DatabaseConnection.getConnection();
    }

    public void insertarAlbum(Album album) {
        // Implementar lógica para insertar un álbum en la base de datos
    }

    public Album obtenerAlbumPorId(int id) {
        // Implementar lógica para obtener un álbum por su ID
        return null;
    }

    public List<Album> obtenerTodosLosAlbumes() {
        // Implementar lógica para obtener todos los álbumes
        return new ArrayList<>();
    }

    public void actualizarAlbum(Album album) {
        // Implementar lógica para actualizar un álbum existente
    }

    public void eliminarAlbum(int id) {
        // Implementar lógica para eliminar un álbum por su ID
    }
}
