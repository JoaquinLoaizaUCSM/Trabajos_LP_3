package Trabajo_8.Ejercicio.model;
import java.util.Date;

public class Album {
    private int albumId;
    private String nombre;
    private Date fechaLanzamiento;
    private String genero;

    public Album() {
    }

    public Album(int albumId, String nombre, Date fechaLanzamiento, String genero) {
        this.albumId = albumId;
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.genero = genero;
    }

    // Getters y Setters
    public int getAlbumId() {
        return albumId;
    }
    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }
    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
}
