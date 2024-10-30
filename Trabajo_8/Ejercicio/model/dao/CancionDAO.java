package Trabajo_8.Ejercicio.model.dao;



import Trabajo_8.Ejercicio.model.Cancion;
import Trabajo_8.Ejercicio.model.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CancionDAO {

    private Connection connection;

    public CancionDAO() {
        connection = DatabaseConnection.getConnection();
    }

    public void insertarCancion(Cancion cancion) {
        // Implementar lógica para insertar una canción en la base de datos
    }

    public Cancion obtenerCancionPorId(int id) {
        // Implementar lógica para obtener una canción por su ID
        return null;
    }

    public List<Cancion> obtenerTodasLasCanciones() {
        // Implementar lógica para obtener todas las canciones
        return new ArrayList<>();
    }

    public void actualizarCancion(Cancion cancion) {
        // Implementar lógica para actualizar una canción existente
    }

    public void eliminarCancion(int id) {
        // Implementar lógica para eliminar una canción por su ID
    }
}
