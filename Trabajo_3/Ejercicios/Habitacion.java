package Trabajo_3.Ejercicios;

import java.util.Date;

public class Habitacion {
    private int numero;
    private String tipo;
    private double precioBase;
    private GestorDisponibilidadHabitacion gestorDisponibilidad;

    public Habitacion(int numero, String tipo, double precioBase, GestorDisponibilidadHabitacion gestorDisponibilidad) {
        this.numero = numero;
        this.tipo = tipo;
        this.precioBase = precioBase;
        this.gestorDisponibilidad = gestorDisponibilidad;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precio) {
        this.precioBase = precio;
    }

    public double getPrecioFinal(Date fechaInicio, Date fechaFin) {
        return gestorDisponibilidad.calcularPrecio(this, fechaInicio, fechaFin);
    }
}
