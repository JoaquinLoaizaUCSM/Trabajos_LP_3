package Trabajo_8.Ejercicio.controller;


import Trabajo_8.Ejercicio.model.dao.AlbumDAO;
import Trabajo_8.Ejercicio.view.AlbumView;

import java.util.List;

public class AlbumController {

    private AlbumDAO albumDAO;
    private AlbumView albumView;

    public AlbumController(AlbumDAO albumDAO, AlbumView albumView) {
        this.albumDAO = albumDAO;
        this.albumView = albumView;
    }

    public void agregarAlbum() {
        // Lógica para agregar un nuevo álbum
    }

    public void mostrarAlbumes() {
        // Lógica para mostrar todos los álbumes
    }

    public void actualizarAlbum() {
        // Lógica para actualizar un álbum existente
    }

    public void eliminarAlbum() {
        // Lógica para eliminar un álbum
    }
}
