package Trabajo_8.Ejercicio.controller;

import Trabajo_8.Ejercicio.model.dao.AlbumDAO;
import Trabajo_8.Ejercicio.view.AlbumView;
import Trabajo_8.Ejercicio.model.Album;
import java.util.List;

public class AlbumController {
    private AlbumDAO albumDAO;
    private AlbumView albumView;

    public AlbumController(AlbumDAO albumDAO, AlbumView albumView) {
        this.albumDAO = albumDAO;
        this.albumView = albumView;
    }

    public void agregarAlbum() {
        Album album = albumView.obtenerDatosAlbum();
        albumDAO.insertarAlbum(album);
        albumView.mostrarMensaje("Álbum agregado exitosamente.");
    }

    public void mostrarAlbumes() {
        List<Album> albums = albumDAO.obtenerTodosLosAlbumes();
        albumView.mostrarAlbumes(albums);
    }

    public void actualizarAlbum() {
        int albumId = albumView.obtenerIdAlbum();
        Album album = albumDAO.obtenerAlbumPorId(albumId);
        if (album != null) {
            Album updatedAlbum = albumView.obtenerDatosAlbum();
            albumDAO.actualizarAlbum(updatedAlbum);
            albumView.mostrarMensaje("Álbum actualizado exitosamente.");
        } else {
            albumView.mostrarMensaje("Álbum no encontrado.");
        }
    }
    public void eliminarAlbum() {
        int albumId = albumView.obtenerIdAlbum();
        albumDAO.eliminarAlbum(albumId);
        albumView.mostrarMensaje("Álbum eliminado exitosamente.");
    }
}
