package Trabajo_8.Ejercicio.controller;

import Trabajo_8.Ejercicio.model.dao.ArtistaDAO;
import Trabajo_8.Ejercicio.view.ArtistaView;

import java.util.List;

public class ArtistaController {

    private ArtistaDAO artistaDAO;
    private ArtistaView artistaView;

    public ArtistaController(ArtistaDAO artistaDAO, ArtistaView artistaView) {
        this.artistaDAO = artistaDAO;
        this.artistaView = artistaView;
    }

    public void agregarArtista() {
        // Lógica para agregar un nuevo artista
    }

    public void mostrarArtistas() {
        // Lógica para mostrar todos los artistas
    }

    public void actualizarArtista() {
        // Lógica para actualizar un artista existente
    }

    public void eliminarArtista() {
        // Lógica para eliminar un artista
    }
}
