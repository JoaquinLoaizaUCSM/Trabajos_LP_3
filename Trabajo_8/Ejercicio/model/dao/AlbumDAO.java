package Trabajo_8.Ejercicio.model.dao;

import Trabajo_8.Ejercicio.model.Album;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAO {

    private Connection connection;

    public AlbumDAO(Connection connection) {
        this.connection = connection;
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
            e.printStackTrace();
        }
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
                album.setFechaLanzamiento(resultSet.getDate("fecha_lanzamiento"));
                album.setGenero(resultSet.getString("genero"));

                // Format the date
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String formattedDate = dateFormat.format(album.getFechaLanzamiento());
                System.out.println("Fecha de Lanzamiento: " + formattedDate);

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
                album.setAlbumId(resultSet.getInt("album_id"));
                album.setNombre(resultSet.getString("nombre"));

                // Retrieve the date as a string and parse it
                String fechaLanzamientoStr = resultSet.getString("fecha_lanzamiento");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date fechaLanzamiento = dateFormat.parse(fechaLanzamientoStr);
                album.setFechaLanzamiento(new java.sql.Date(fechaLanzamiento.getTime()));

                album.setGenero(resultSet.getString("genero"));
                albums.add(album);
            }
        } catch (SQLException | java.text.ParseException e) {
            e.printStackTrace();
        }
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