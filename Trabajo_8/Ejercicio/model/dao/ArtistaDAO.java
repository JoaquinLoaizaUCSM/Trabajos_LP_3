package Trabajo_8.Ejercicio.model.dao;

import Trabajo_8.Ejercicio.model.Artista;
import Trabajo_8.Ejercicio.model.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistaDAO {
    private Connection connection;
    public ArtistaDAO() {connection = DatabaseConnection.getConnection();}

    public void insertarArtista(Artista artista) {
        try {
            String query = "INSERT INTO artistas (nombre, genero, nacionalidad) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, artista.getNombre());
            preparedStatement.setString(2,artista.getGenero());
            preparedStatement.setString(3,artista.getPaisOrigen());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Artista obtenerArtistaPorId(int id) {
        try {
            String query = "SELECT * FROM artistas WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Artista(resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("genero"),
                        resultSet.getString("nacionalidad")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Artista> obtenerTodosLosArtistas() {
        List<Artista> artistas = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM artistas");
            while (resultSet.next()) {
                artistas.add(new Artista(resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("genero"),
                        resultSet.getString("nacionalidad")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artistas;
    }

    public void actualizarArtista(Artista artista) {
        try {
            String query = "UPDATE artistas SET nombre = ?, genero = ?, nacionalidad = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, artista.getNombre());
            preparedStatement.setString(2, artista.getGenero());
            preparedStatement.setString(3, artista.getPaisOrigen());
            preparedStatement.setInt(4, artista.getArtistaId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();}
    }

    public void eliminarArtista(int id) {
        try {
            String query = "DELETE FROM artistas WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
