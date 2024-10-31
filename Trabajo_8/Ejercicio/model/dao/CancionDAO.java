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
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO cancion(titulo, duracion, albumId) VALUES (?, ?, ?)");
            preparedStatement.setString(1, cancion.getTitulo());
            preparedStatement.setInt(2, cancion.getDuracion());
            preparedStatement.setInt(3, cancion.getAlbumId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cancion obtenerCancionPorId(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cancion WHERE cancionId = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Cancion(
                        resultSet.getInt("cancionId"),
                        resultSet.getString("titulo"),
                        resultSet.getInt("duracion"),
                        resultSet.getInt("albumId")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Cancion> obtenerTodasLasCanciones() {
        List<Cancion> canciones = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cancion");
            while (resultSet.next()) {
                canciones.add(new Cancion(
                        resultSet.getInt("cancionId"),
                        resultSet.getString("titulo"),
                        resultSet.getInt("duracion"),
                        resultSet.getInt("albumId")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return canciones;
    }
    public void actualizarCancion(Cancion cancion) {
        try {
            String query = "UPDATE cancion SET titulo = ?, duracion = ?, albumId = ? WHERE cancionId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cancion.getTitulo());
            preparedStatement.setInt(2, cancion.getDuracion());
            preparedStatement.setInt(3, cancion.getAlbumId());
            preparedStatement.setInt(4, cancion.getCancionId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();}
    }

    public void eliminarCancion(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM cancion WHERE cancionId = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();}
    }
}