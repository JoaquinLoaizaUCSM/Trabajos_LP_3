package Trabajo_8.Ejercicio.model.dao;



import Trabajo_8.Ejercicio.model.Usuario;
import Trabajo_8.Ejercicio.model.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Connection connection;

    public UsuarioDAO() {
        connection = DatabaseConnection.getConnection();
    }

    public void insertarUsuario(Usuario usuario) {
        // Implementar lógica para insertar un usuario en la base de datos
    }

    public Usuario obtenerUsuarioPorId(int id) {
        // Implementar lógica para obtener un usuario por su ID
        return null;
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        // Implementar lógica para obtener todos los usuarios
        return new ArrayList<>();
    }

    public void actualizarUsuario(Usuario usuario) {
        // Implementar lógica para actualizar un usuario existente
    }

    public void eliminarUsuario(int id) {
        // Implementar lógica para eliminar un usuario por su ID
    }
}
