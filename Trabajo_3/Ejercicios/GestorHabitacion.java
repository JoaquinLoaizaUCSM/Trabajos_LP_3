package Trabajo_3.Ejercicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorHabitacion {
    private List<Reserva> reservas = new ArrayList<>();
    private List<Promocion> promociones = new ArrayList<>();
    private List<Habitacion> habitaciones = new ArrayList<>(); // Agregar lista de habitaciones

    public boolean verificarDisponibilidad(Date fechaInicio, Date fechaFin) {
        for (Reserva reserva : reservas) {
            if ((fechaInicio.before(reserva.getFechaFin()) && fechaFin.after(reserva.getFechaInicio()))) {
                return false;
            }
        }
        return true;
    }

    public void marcarComoReservada(Date fechaInicio, Date fechaFin) {
        Reserva nuevaReserva = new Reserva(null, null, fechaInicio, fechaFin, null, null);
        reservas.add(nuevaReserva);
    }

    public void marcarComoDisponible(Date fechaInicio, Date fechaFin) {
        reservas.removeIf(reserva -> reserva.getFechaInicio().equals(fechaInicio) && reserva.getFechaFin().equals(fechaFin));
    }

    public double calcularPrecio(Habitacion habitacion, Date fechaInicio, Date fechaFin) {
        double precio = habitacion.getPrecioBase();
        for (Promocion promocion : promociones) {
            if (promocion.esValida(fechaInicio)) {
                precio -= promocion.getDescuento();
            }
        }
        return precio;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }
}