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
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO lista_reproduccion(nombre,usuarioId,fechaCreacion) VALUES (?, ?, ?)");
            preparedStatement.setString(1, lista.getNombre());
            preparedStatement.setInt(2, lista.getUsuarioId());
            preparedStatement.setDate(3, new Date(lista.getFechaCreacion().getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ListaReproduccion obtenerListaPorId(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM lista_reproduccion WHERE listaId = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new ListaReproduccion(
                        resultSet.getInt("listaId"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("usuarioId"),
                        resultSet.getDate("fechaCreacion")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ListaReproduccion> obtenerTodasLasListas() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM lista_reproduccion");
            List<ListaReproduccion> listas = new ArrayList<>();
            while (resultSet.next()) {
                listas.add(new ListaReproduccion(
                        resultSet.getInt("listaId"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("usuarioId"),
                        resultSet.getDate("fechaCreacion")
                ));
            }
            return listas;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void actualizarListaReproduccion(ListaReproduccion lista) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE lista_reproduccion SET nombre = ?, usuarioId = ?, fechaCreacion = ? WHERE listaId = ?");
            preparedStatement.setString(1, lista.getNombre());
            preparedStatement.setInt(2, lista.getUsuarioId());
            preparedStatement.setDate(3, new Date(lista.getFechaCreacion().getTime()));
            preparedStatement.setInt(4, lista.getListaId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarListaReproduccion(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM lista_reproduccion WHERE listaId = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();}
    }
}
