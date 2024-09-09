package Trabajo_3.Ejercicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorDisponibilidadHabitacion {
    private List<Reserva> reservas = new ArrayList<>();
    private List<Promocion> promociones = new ArrayList<>();

    public boolean verificarDisponibilidad(Date fechaInicio, Date fechaFin) {
        // Verifica si la habitación está disponible en el rango de fechas
        for (Reserva reserva : reservas) {
            if ((fechaInicio.before(reserva.getFechaFin()) && fechaFin.after(reserva.getFechaInicio()))) {
                return false;
            }
        }
        return true;
    }

    public void marcarComoReservada(Date fechaInicio, Date fechaFin) {
        // Agrega la reserva
        // Lógica para marcar como reservada
    }

    public void marcarComoDisponible(Date fechaInicio, Date fechaFin) {
        // Lógica para marcar como disponible
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
}
