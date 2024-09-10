// src/Trabajo_3/Ejercicios/ControladorReservas.java
package Trabajo_3.Ejercicios;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class ControladorReservas {
    private GestorHabitacion gestorDisponibilidad;
    private NotificadorReserva notificadorReserva;
    private GeneradorInformes generadorInformes;

    public ControladorReservas(GestorHabitacion gestorDisponibilidad, NotificadorReserva notificadorReserva,
                               GeneradorInformes generadorInformes) {
        this.gestorDisponibilidad = gestorDisponibilidad;
        this.notificadorReserva = notificadorReserva;
        this.generadorInformes = generadorInformes;
    }

    public Reserva crearReserva(Cliente cliente, Habitacion habitacion, Date fechaInicio, Date fechaFin, PoliticaCancelacion politica) {
        if (gestorDisponibilidad.verificarDisponibilidad(fechaInicio, fechaFin)) {
            Reserva reserva = new Reserva(habitacion, cliente, fechaInicio, fechaFin, politica, null);
            gestorDisponibilidad.marcarComoReservada(fechaInicio, fechaFin);
            notificadorReserva.notificarReservaConfirmada(reserva);
            return reserva;
        } else {
            System.out.println("La habitación no está disponible en las fechas solicitadas.");
            return null;
        }
    }

    public boolean cancelarReserva(Reserva reserva) {
        if (reserva == null) {
            System.out.println("La reserva no puede ser nula.");
            return false;
        }
        boolean puedeCancelar = reserva.cancelar();
        if (puedeCancelar) {
            gestorDisponibilidad.marcarComoDisponible(reserva.getFechaInicio(), reserva.getFechaFin());
            notificadorReserva.notificarReservaCancelada(reserva);
        }
        return puedeCancelar;
    }

    public List<Habitacion> consultarDisponibilidad(Date fechaInicio, Date fechaFin) {
        List<Habitacion> habitacionesDisponibles = new ArrayList<>();
        for (Habitacion habitacion : gestorDisponibilidad.getHabitaciones()) {
            if (gestorDisponibilidad.verificarDisponibilidad(fechaInicio, fechaFin)) {
                habitacionesDisponibles.add(habitacion);
            }
        }
        return habitacionesDisponibles;
    }
}