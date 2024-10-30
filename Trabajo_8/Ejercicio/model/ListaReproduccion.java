package Trabajo_8.Ejercicio.model;

import java.util.Date;

public class ListaReproduccion {
    private int listaId;
    private String nombre;
    private int usuarioId;
    private Date fechaCreacion;

    public ListaReproduccion() {
    }

    public ListaReproduccion(int listaId, String nombre, int usuarioId, Date fechaCreacion) {
        this.listaId = listaId;
        this.nombre = nombre;
        this.usuarioId = usuarioId;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters y Setters
    public int getListaId() {
        return listaId;
    }

    public void setListaId(int listaId) {
        this.listaId = listaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
