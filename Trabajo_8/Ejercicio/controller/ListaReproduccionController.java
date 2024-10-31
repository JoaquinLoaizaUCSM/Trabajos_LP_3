package Trabajo_8.Ejercicio.controller;

import Trabajo_8.Ejercicio.model.ListaReproduccion;
import Trabajo_8.Ejercicio.model.dao.ListaReproduccionDAO;
import Trabajo_8.Ejercicio.view.ListaReproduccionView;
import java.util.List;

public class ListaReproduccionController {
    private ListaReproduccionDAO listaReproduccionDAO;
    private ListaReproduccionView listaReproduccionView;

    public ListaReproduccionController(ListaReproduccionDAO listaReproduccionDAO, ListaReproduccionView listaReproduccionView) {
        this.listaReproduccionDAO = listaReproduccionDAO;
        this.listaReproduccionView = listaReproduccionView;
    }

    public void mostrarListasReproduccion() {
        List<ListaReproduccion> listas = listaReproduccionDAO.obtenerTodasLasListas();
        listaReproduccionView.mostrarListas(listas);
    }

    public void agregarListaReproduccion(ListaReproduccion lista) {
        listaReproduccionDAO.insertarListaReproduccion(lista);
    }
}

