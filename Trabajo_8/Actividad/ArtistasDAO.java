package Trabajo_8.Actividad;

import java.sql.*;

public class ArtistasDAO {
    private static final String URL = "jdbc:sqlite:Trabajo_8\\Actividad\\musica.db";

    public void createTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS Artistas (
                artista_id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre VARCHAR NOT NULL,
                genero VARCHAR,
                pais_origen VARCHAR
            )
        """;

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Error en crear la tabla: " + e.getMessage());
        }
    }

    public void insertarArtista(String nombre, String genero, String paisOrigen) {
        String sql = "INSERT INTO Artistas (nombre, genero, pais_origen) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);  // Inicio de transacción

            try {
                pstmt.setString(1, nombre);
                pstmt.setString(2, genero);
                pstmt.setString(3, paisOrigen);
                pstmt.executeUpdate();

                conn.commit();  // Confirmar transacción
                System.out.println("Artista insertado exitosamente");
            } catch (SQLException e) {
                conn.rollback();  // Revertir en caso de error
                throw e;
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar artista: " + e.getMessage());
        }
    }

    public void recuperarArtista(int artistaId) {
        String sql = "SELECT * FROM Artistas WHERE artista_id = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, artistaId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("artista_id"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Género: " + rs.getString("genero"));
                System.out.println("País: " + rs.getString("pais_origen"));
            } else {
                System.out.println("No se encontró el artista");
            }
        } catch (SQLException e) {
            System.err.println("Error al recuperar artista: " + e.getMessage());
        }
    }

    public void actualizarArtista(int artistaId, String nombre, String genero, String paisOrigen) {
        String sql = "UPDATE Artistas SET nombre = ?, genero = ?, pais_origen = ? WHERE artista_id = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);  // Inicio de transacción

            try {
                pstmt.setString(1, nombre);
                pstmt.setString(2, genero);
                pstmt.setString(3, paisOrigen);
                pstmt.setInt(4, artistaId);

                int affectedRows = pstmt.executeUpdate();
                if (affectedRows > 0) {
                    conn.commit();  // Confirmar transacción
                    System.out.println("Artista actualizado exitosamente");
                } else {
                    System.out.println("No se encontró el artista para actualizar");
                }
            } catch (SQLException e) {
                conn.rollback();  // Revertir en caso de error
                throw e;
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar artista: " + e.getMessage());
        }
    }

    public void borrarArtista(int artistaId) {
        String sql = "DELETE FROM Artistas WHERE artista_id = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);  // Inicio de transacción

            try {
                pstmt.setInt(1, artistaId);

                int affectedRows = pstmt.executeUpdate();
                if (affectedRows > 0) {
                    conn.commit();  // Confirmar transacción
                    System.out.println("Artista eliminado exitosamente");
                } else {
                    System.out.println("No se encontró el artista para eliminar");
                }
            } catch (SQLException e) {
                conn.rollback();  // Revertir en caso de error
                throw e;
            }
        } catch (SQLException e) {
            System.err.println("Error al borrar artista: " + e.getMessage());
        }
    }
}