package Trabajo_8.Ejercicio.view;

import Trabajo_8.Ejercicio.model.ListaReproduccion;
import java.util.List;


public class ListaReproduccionView {

    public void MenuListaReproduccion() {
        System.out.println("Menú de Listas de Reproducción");
        System.out.println("1. Mostrar Listas de Reproducción");
        System.out.println("2. Regresar al menú principal");
    }


    public void mostrarListas(List<ListaReproduccion> listas) {
        // Mostrar lista de listas de reproducción
        for (ListaReproduccion lista : listas) {
            System.out.println("ID: " + lista.getListaId() + ", Nombre: " + lista.getNombre() +
                    ", Fecha: " + lista.getFechaCreacion());
        }
    }


    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
