package Trabajo_8.Ejercicio.controller;


import Trabajo_8.Ejercicio.model.dao.ListaReproduccionDAO;
import Trabajo_8.Ejercicio.view.ListaReproduccionView;

public class ListaReproduccionController {

    private ListaReproduccionDAO listaDAO;
    private ListaReproduccionView listaView;

    public ListaReproduccionController(ListaReproduccionDAO listaDAO, ListaReproduccionView listaView) {
        this.listaDAO = listaDAO;
        this.listaView = listaView;
    }

    public void agregarLista() {
        // Lógica para agregar una nueva lista de reproducción
    }

    public void mostrarListas() {
        // Lógica para mostrar todas las listas de reproducción
    }

    public void actualizarLista() {
        // Lógica para actualizar una lista de reproducción existente
    }

    public void eliminarLista() {
        // Lógica para eliminar una lista de reproducción
    }
}
