package Trabajo_3.Ejercicios;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Inicialización de las clases necesarias
        GestorHabitacion gestorDisponibilidad = new GestorHabitacion();
        NotificadorReserva notificador = new NotificadorReserva(new EnviadorCorreo());
        GeneradorInformes generadorInformes = new GeneradorInformes();

        // Crear clientes
        Cliente cliente1 = new Cliente("Joaquin", "Joaquin.loaiza@ucsm.edu.pe", "900659285");
        Cliente cliente2 = new Cliente("sebas", "maria@example.com", "987654321");

        // Crear promociones
        Date promocionInicio = new Date(2024, 5, 1);
        Date promocionFin = new Date(2024, 5, 30);
        Promocion promocion = new Promocion(10, promocionInicio, promocionFin);

        // Crear habitaciones
        HabitacionEstandar habitacionEstandar = new HabitacionEstandar(101, "Estandar", 100.0, gestorDisponibilidad);
        HabitacionSuite habitacionSuite = new HabitacionSuite(201, "Suite", 200.0, gestorDisponibilidad);

        // Agregar promociones a las habitaciones
        gestorDisponibilidad.marcarComoDisponible(new Date(2024, 5, 1), new Date(2024, 5, 15));

        // Crear políticas de cancelación
        PoliticaCancelacion flexible = new PoliticaCancelacionFlexible();
        PoliticaCancelacion moderada = new PoliticaCancelacionModerada();
        PoliticaCancelacion estricta = new PoliticaCancelacionEstricta();

        // Crear reservas
        ControladorReservas controladorReservas = new ControladorReservas(gestorDisponibilidad, notificador, generadorInformes);

        Date fechaInicioReserva = new Date(2024, 5, 5);
        Date fechaFinReserva = new Date(2024, 5, 10);

        System.out.println("Probando reserva con habitacion estándar...");
        Reserva reserva1 = controladorReservas.crearReserva(cliente1, habitacionEstandar, fechaInicioReserva, fechaFinReserva, flexible);
        if (reserva1 != null) {
            System.out.println("Reserva realizada exitosamente para habitación estándar.");
        }

        System.out.println("Probando reserva con habitación suite...");
        Reserva reserva2 = controladorReservas.crearReserva(cliente2, habitacionSuite, fechaInicioReserva, fechaFinReserva, moderada);
        if (reserva2 != null) {
            System.out.println("Reserva realizada exitosamente para habitación suite.");
        }

        // Cancelar una reserva
        System.out.println("Intentando cancelar reserva con política moderada...");
        if (controladorReservas.cancelarReserva(reserva2)) {
            System.out.println("Reserva cancelada correctamente.");
        } else {
            System.out.println("No se pudo cancelar la reserva.");
        }

        // Servicios de la habitación
        System.out.println("\nSolicitando servicios para habitaciones...");

        System.out.println("Solicitando limpieza para habitación estándar:");
        habitacionEstandar.solicitarLimpieza();

        System.out.println("Solicitando servicios adicionales para habitación suite:");
        habitacionSuite.solicitarLimpieza();
        habitacionSuite.pedirComida("Ensalada César");
        habitacionSuite.solicitarLavanderia();

        // Generar informes
        System.out.println("\nGenerando informes...");
        System.out.println(generadorInformes.generarInformeOcupacion(fechaInicioReserva, fechaFinReserva));
        System.out.println(generadorInformes.generarInformeIngresos(fechaInicioReserva, fechaFinReserva));
    }
}
