package Trabajo_8.Ejercicio.model;

import java.util.Date;

public class Usuario {
    private int usuarioId;
    private String nombre;
    private String email;
    private String tipoSuscripcion;
    private Date fechaCreacion;

    public Usuario() {}
    public Usuario(int usuarioId, String nombre, String email, String tipoSuscripcion, Date fechaCreacion) {
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.email = email;
        this.tipoSuscripcion = tipoSuscripcion;
        this.fechaCreacion = fechaCreacion;
    }
    // Getters y Setters
    public int getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
    }

    public String getTipoSuscripcion() {
        return tipoSuscripcion;
    }
    public void setTipoSuscripcion(String tipoSuscripcion) {
        this.tipoSuscripcion = tipoSuscripcion;
    }
    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "Usuario" + '\n' +
                "usuarioId: " + usuarioId+ '\n' +
                "nombre: " + nombre + '\n' +
                "email: " + email + '\n' +
                "tipoSuscripcion: " + tipoSuscripcion + '\n' +
                "fechaCreacion: " + fechaCreacion
        ;
    }
}
