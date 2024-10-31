package Trabajo_8.Ejercicio.view;

import Trabajo_8.Ejercicio.model.Album;
import java.util.List;


public class AlbumView {
    public void MenuAlbum() {
        System.out.println("Menú de Álbumes");
        System.out.println("1. Agregar Álbum");
        System.out.println("2. Mostrar Álbumes");
        System.out.println("3. Actualizar Álbum");
        System.out.println("4. Eliminar Álbum");
        System.out.println("5. Regresar al menú principal");
    }
     public void mostrarAlbumes(List<Album> albumes) {
        for (Album album : albumes) {
            System.out.println("ID: " + album.getAlbumId() + ", Nombre: " + album.getNombre() +
                    ", Fecha de Lanzamiento: " + album.getFechaLanzamiento() + ", Género: " + album.getGenero());
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }


}
