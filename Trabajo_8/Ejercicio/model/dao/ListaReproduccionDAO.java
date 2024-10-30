package Trabajo_8.Ejercicio.model.dao;


import Trabajo_8.Ejercicio.model.ListaReproduccion;
import Trabajo_8.Ejercicio.model.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListaReproduccionDAO {

    private Connection connection;

    public ListaReproduccionDAO() {
        connection = DatabaseConnection.getConnection();
    }

    public void insertarListaReproduccion(ListaReproduccion lista) {
        // Implementar lógica para insertar una lista de reproducción en la base de datos
    }

    public ListaReproduccion obtenerListaPorId(int id) {
        // Implementar lógica para obtener una lista de reproducción por su ID
        return null;
    }

    public List<ListaReproduccion> obtenerTodasLasListas() {
        // Implementar lógica para obtener todas las listas de reproducción
        return new ArrayList<>();
    }

    public void actualizarListaReproduccion(ListaReproduccion lista) {
        // Implementar lógica para actualizar una lista de reproducción existente
    }

    public void eliminarListaReproduccion(int id) {
        // Implementar lógica para eliminar una lista de reproducción por su ID
    }
}
