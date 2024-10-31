package Trabajo_8.Ejercicio.view;

import Trabajo_8.Ejercicio.model.Artista;
import java.util.List;
import java.util.Scanner;

public class ArtistaView {

    public void MenuArtista() {
        System.out.println("Menú de Artistas");
        System.out.println("1. Agregar Artista");
        System.out.println("2. Mostrar Artistas");
        System.out.println("3. Actualizar Artista");
        System.out.println("4. Eliminar Artista");
        System.out.println("5. Regresar al menú principal");
    }


    public void mostrarArtistas(List<Artista> artistas) {
        // Mostrar lista de artistas
        for (Artista artista : artistas) {
            System.out.println("ID: " + artista.getArtistaId() + ", Nombre: " + artista.getNombre() +
                    ", Nacionalidad: " + artista.getPaisOrigen());
        }
    }


    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
