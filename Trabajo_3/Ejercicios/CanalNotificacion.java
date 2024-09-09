package Trabajo_3.Ejercicios;

public interface CanalNotificacion {
    void enviarNotificacion(String mensaje);
}

class EnviadorCorreo implements CanalNotificacion {
    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("Enviando correo: " + mensaje);
    }
}


class EnviadorSMS implements CanalNotificacion {
    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("Enviando SMS: " + mensaje);
    }
}

class NotificadorSlack implements CanalNotificacion {
    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("Enviando notificación Slack: " + mensaje);
    }
}
