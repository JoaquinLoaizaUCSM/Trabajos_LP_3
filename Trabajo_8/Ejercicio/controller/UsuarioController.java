package Trabajo_8.Ejercicio.controller;

import Trabajo_8.Ejercicio.model.Usuario;
import Trabajo_8.Ejercicio.model.dao.UsuarioDAO;
import Trabajo_8.Ejercicio.view.UsuarioView;
import java.util.List;
import java.util.Scanner;

public class UsuarioController {
    private UsuarioDAO usuarioDAO;
    private UsuarioView usuarioView;

    public UsuarioController(UsuarioDAO usuarioDAO, UsuarioView usuarioView) {
        this.usuarioDAO = usuarioDAO;
        this.usuarioView = usuarioView;
    }
    public void mostrarUsuarios() {
        List<Usuario> usuarios = usuarioDAO.getAllUsuarios();
        usuarioView.mostrarUsuarios(usuarios);
    }
    public void agregarUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el tipo de suscripción (Gratis, Premium): ");

        String tipoSuscripcion = scanner.nextLine();

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setTipoSuscripcion(tipoSuscripcion);


        usuarioDAO.insertUsuario(usuario);
    }
    public void actualizarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del usuario: ");
        int usuarioId = scanner.nextInt();
        System.out.print("Ingrese el nuevo tipo de suscripción (Gratis, Premium): ");
        String tipoSuscripcion = scanner.next();
        usuarioDAO.updateUsuario(usuarioId, tipoSuscripcion);
    }
    public void eliminarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del usuario: ");
        int usuarioId = scanner.nextInt();
        usuarioDAO.deleteUsuario(usuarioId);
    }
}

