package Trabajo_8.Ejercicio.model;

public class Artista {
    private int artistaId;
    private String nombre;
    private String genero;
    private String paisOrigen;

    public Artista() {
    }

    public Artista(int artistaId, String nombre, String genero, String paisOrigen) {
        this.artistaId = artistaId;
        this.nombre = nombre;
        this.genero = genero;
        this.paisOrigen = paisOrigen;
    }

    // Getters y Setters
    public int getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(int artistaId) {
        this.artistaId = artistaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
}
