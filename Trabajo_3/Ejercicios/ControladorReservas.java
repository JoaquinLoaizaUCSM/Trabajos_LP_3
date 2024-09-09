package Trabajo_3.Ejercicios;

import java.util.Date;
import java.util.List;

public class ControladorReservas {
    private GestorDisponibilidadHabitacion gestorDisponibilidad;
    private NotificadorReserva notificadorReserva;
    private GeneradorInformes generadorInformes;

    public ControladorReservas(GestorDisponibilidadHabitacion gestorDisponibilidad, NotificadorReserva notificadorReserva, GeneradorInformes generadorInformes) {
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
        boolean puedeCancelar = reserva.cancelar();
        if (puedeCancelar) {
            gestorDisponibilidad.marcarComoDisponible(reserva.getFechaInicio(), reserva.getFechaFin());
            notificadorReserva.notificarReservaCancelada(reserva);
        }
        return puedeCancelar;
    }

    public List<Habitacion> consultarDisponibilidad(Date fechaInicio, Date fechaFin) {
        // Devuelve la lista de habitaciones disponibles
        return null;
    }
}
