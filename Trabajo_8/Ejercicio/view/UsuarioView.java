package Trabajo_8.Ejercicio.view;

import Trabajo_8.Ejercicio.model.Usuario;
import java.util.List;


public class UsuarioView {

    public void MenuUsuario() {
        System.out.println("Menú de Usuarios");
        System.out.println("1. Agregar Usuario");
        System.out.println("2. Mostrar Usuarios");
        System.out.println("3. Actualizar Usuario");
        System.out.println("4. Eliminar Usuario");
        System.out.println("5. Regresar al menú principal");
    }


    public void mostrarUsuarios(List<Usuario> usuarios) {
        // Mostrar lista de usuarios
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
