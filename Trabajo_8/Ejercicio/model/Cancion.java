package Trabajo_8.Ejercicio.model;


public class Cancion {
    private int cancionId;
    private String titulo;
    private int duracion; // Duración en segundos
    private int albumId;  // Puede ser null si no pertenece a un álbum

    public Cancion() {
    }

    public Cancion(int cancionId, String titulo, int duracion, int albumId) {
        this.cancionId = cancionId;
        this.titulo = titulo;
        this.duracion = duracion;
        this.albumId = albumId;
    }

    // Getters y Setters
    public int getCancionId() {
        return cancionId;
    }

    public void setCancionId(int cancionId) {
        this.cancionId = cancionId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }
}
