package Trabajo_8.Ejercicio.model.dao;

import Trabajo_8.Ejercicio.model.ListaReproduccion;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ListaReproduccionDAO {
    private Connection connection;

    public ListaReproduccionDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertarListaReproduccion(ListaReproduccion lista) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Listas_Reproduccion(nombre,usuarioId,fechaCreacion) VALUES (?, ?, ?)");
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
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Listas_Reproduccion WHERE listaId = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new ListaReproduccion(
                        resultSet.getInt("lista_Id"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("usuario_id"),
                        resultSet.getDate("fecha_creacion")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ListaReproduccion> obtenerTodasLasListas() {
        List<ListaReproduccion> listas = new ArrayList<>();
        String query = "SELECT * FROM Listas_Reproduccion";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                ListaReproduccion lista = new ListaReproduccion();
                lista.setListaId(resultSet.getInt("lista_Id"));
                lista.setNombre(resultSet.getString("nombre"));
                lista.setUsuarioId(resultSet.getInt("usuario_id"));

                // Retrieve the date as a string and parse it
                String fechaCreacionStr = resultSet.getString("fecha_creacion");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date fechaCreacion = dateFormat.parse(fechaCreacionStr);
                lista.setFechaCreacion(new java.sql.Date(fechaCreacion.getTime()));

                listas.add(lista);
            }
        } catch (SQLException | java.text.ParseException e) {
            e.printStackTrace();
        }
        return listas;
    }

    public void actualizarListaReproduccion(ListaReproduccion lista) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE Listas_Reproduccion SET nombre = ?, usuarioId = ?, fechaCreacion = ? WHERE listaId = ?");
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
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Listas_Reproduccion WHERE listaId = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}