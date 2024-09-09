package Trabajo_3.Ejercicios;

import java.util.Date;

public class Promocion {
    private double descuento;
    private Date fechaInicio;
    private Date fechaFin;

    public Promocion(double descuento, Date fechaInicio, Date fechaFin) {
        this.descuento = descuento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public double getDescuento() {
        return descuento;
    }

    public boolean esValida(Date fecha) {
        return !fecha.before(fechaInicio) && !fecha.after(fechaFin);
    }
}
