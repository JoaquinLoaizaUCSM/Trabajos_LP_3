package Trabajo_8.Ejercicio.controller;

import Trabajo_8.Ejercicio.model.Usuario;
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
    public void mostrarUsuarios() {
        List<Usuario> usuarios = usuarioDAO.getAllUsuarios();
        usuarioView.displayUsuarios(usuarios);
    }
    public void agregarUsuario(Usuario usuario) {
        usuarioDAO.insertUsuario(usuario);
    }
    public void actualizarUsuario(int usuarioId, String tipoSuscripcion) {
        usuarioDAO.updateUsuario(usuarioId, tipoSuscripcion);
    }
    public void eliminarUsuario(int usuarioId) {
        usuarioDAO.deleteUsuario(usuarioId);
    }
}

