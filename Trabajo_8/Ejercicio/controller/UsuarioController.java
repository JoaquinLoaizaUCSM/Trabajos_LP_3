package Trabajo_8.Ejercicio.controller;


import Trabajo_8.Ejercicio.model.dao.UsuarioDAO;
import Trabajo_8.Ejercicio.view.UsuarioView;

import java.util.List;

public class UsuarioController {

    private UsuarioDAO usuarioDAO;
    private UsuarioView usuarioView;

    public UsuarioController(UsuarioDAO usuarioDAO, UsuarioView usuarioView) {
        this.usuarioDAO = usuarioDAO;
        this.usuarioView = usuarioView;
    }

    public void agregarUsuario() {
        // Lógica para agregar un nuevo usuario
    }

    public void mostrarUsuarios() {
        // Lógica para mostrar todos los usuarios
    }

    public void actualizarUsuario() {
        // Lógica para actualizar un usuario existente
    }

    public void eliminarUsuario() {
        // Lógica para eliminar un usuario
    }
}
