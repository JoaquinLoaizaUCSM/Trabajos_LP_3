package Trabajo_8.Ejercicio.model.dao;

import Trabajo_8.Ejercicio.model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuarios (nombre, email, tipo_suscripcion, fecha_creacion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3, usuario.getTipoSuscripcion());
            pstmt.setDate(4, (Date) usuario.getFechaCreacion());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> getAllUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuarios";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setUsuarioId(rs.getInt("usuario_id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEmail(rs.getString("email"));
                usuario.setTipoSuscripcion(rs.getString("tipo_suscripcion"));
                //usuario.setFechaCreacion(rs.getDate("fecha_creacion"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public void updateUsuario(int usuarioId, String tipoSuscripcion) {
        String sql = "UPDATE Usuarios SET tipo_suscripcion = ? WHERE usuario_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, tipoSuscripcion);
            pstmt.setInt(2, usuarioId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUsuario(int usuarioId) {
        String sql = "DELETE FROM Usuarios WHERE usuario_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, usuarioId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}