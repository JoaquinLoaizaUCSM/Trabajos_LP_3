package Trabajo_8.Ejercicio.view;

import Trabajo_8.Ejercicio.model.Cancion;
import java.util.List;

public class CancionView {
    public void MenuCancion() {
        System.out.println("Menú de Canciones");
        System.out.println("1. Agregar Canción");
        System.out.println("2. Mostrar Canciones");
        System.out.println("3. Actualizar Canción");
        System.out.println("4. Eliminar Canción");
        System.out.println("5. Regresar al menú principal");
    }

    public void mostrarCanciones(List<Cancion> canciones) {
        // Mostrar lista de canciones
        for (Cancion cancion : canciones) {
            System.out.println("ID: " + cancion.getCancionId() + ", Titulo: " + cancion.getTitulo() +
                    ", Duración: " + cancion.getDuracion() + ", Álbum: " + cancion.getAlbumId());
        }
    }


    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
