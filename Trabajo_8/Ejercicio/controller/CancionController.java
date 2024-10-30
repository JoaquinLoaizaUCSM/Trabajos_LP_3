package Trabajo_8.Ejercicio.controller;

import Trabajo_8.Ejercicio.model.dao.CancionDAO;
import Trabajo_8.Ejercicio.view.CancionView;


public class CancionController {

    private CancionDAO cancionDAO;
    private CancionView cancionView;

    public CancionController(CancionDAO cancionDAO, CancionView cancionView) {
        this.cancionDAO = cancionDAO;
        this.cancionView = cancionView;
    }

    public void agregarCancion() {
        // Lógica para agregar una nueva canción
    }

    public void mostrarCanciones() {
        // Lógica para mostrar todas las canciones
    }

    public void actualizarCancion() {
        // Lógica para actualizar una canción existente
    }

    public void eliminarCancion() {
        // Lógica para eliminar una canción
    }
}
