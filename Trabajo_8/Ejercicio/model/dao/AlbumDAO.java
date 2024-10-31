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
        String query = "INSERT INTO albumes (nombre, fecha_Lanzamiento, genero) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, album.getNombre());
            preparedStatement.setDate(2, new Date(album.getFechaLanzamiento().getTime()));
            preparedStatement.setString(3, album.getGenero());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();}
    }

    public Album obtenerAlbumPorId(int id) {
        String query = "SELECT * FROM albumes WHERE albumId = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Album album = new Album();
                album.setAlbumId(resultSet.getInt("albumId"));
                album.setNombre(resultSet.getString("nombre"));
                album.setFechaLanzamiento(resultSet.getDate("fechaLanzamiento"));
                album.setGenero(resultSet.getString("genero"));
                return album;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Album> obtenerTodosLosAlbumes() {
        List<Album> albums = new ArrayList<>();
        String query = "SELECT * FROM albumes";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Album album = new Album();
                album.setAlbumId(resultSet.getInt("albumId"));
                album.setNombre(resultSet.getString("nombre"));
                album.setFechaLanzamiento(resultSet.getDate("fechaLanzamiento"));
                album.setGenero(resultSet.getString("genero"));
                albums.add(album);
            }
        } catch (SQLException e) {
            e.printStackTrace();}
        return albums;
    }

    public void actualizarAlbum(Album album) {
        String query = "UPDATE albumes SET nombre = ?, fechaLanzamiento = ?, genero = ? WHERE albumId = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, album.getNombre());
            preparedStatement.setDate(2, new Date(album.getFechaLanzamiento().getTime()));
            preparedStatement.setString(3, album.getGenero());
            preparedStatement.setInt(4, album.getAlbumId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarAlbum(int id) {
        String query = "DELETE FROM albumes WHERE albumId = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
