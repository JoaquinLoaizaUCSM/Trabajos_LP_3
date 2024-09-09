package Trabajo_3.Ejercicios;

import java.util.Date;

public class Reserva {
    private Habitacion habitacion;
    private Cliente cliente;
    private Date fechaInicio;
    private Date fechaFin;
    private PoliticaCancelacion politicaCancelacion;
    private Promocion promocion;

    public Reserva(Habitacion habitacion, Cliente cliente, Date fechaInicio, Date fechaFin, PoliticaCancelacion politicaCancelacion, Promocion promocion) {
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.politicaCancelacion = politicaCancelacion;
        this.promocion = promocion;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public boolean cancelar() {
        return politicaCancelacion.puedeCancelar(this);
    }
}
