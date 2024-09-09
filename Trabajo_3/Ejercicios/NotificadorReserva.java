package Trabajo_3.Ejercicios;

public class NotificadorReserva {
    private CanalNotificacion canalNotificacion;

    public NotificadorReserva(CanalNotificacion canal) {
        this.canalNotificacion = canal;
    }

    public void notificarReservaConfirmada(Reserva reserva) {
        canalNotificacion.enviarNotificacion("Reserva confirmada para " + reserva.getCliente().getNombre());
    }

    public void notificarReservaCancelada(Reserva reserva) {
        canalNotificacion.enviarNotificacion("Reserva cancelada para " + reserva.getCliente().getNombre());
    }
}
