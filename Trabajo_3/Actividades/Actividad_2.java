package Trabajo_3.Actividades;

public class Actividad_2 {
    public static void main(String[] args) {
        Notification correo = new NotificationEmail();
        Notification SMS = new NotificationSMS();

        correo.sendMenssager("Hola");
        SMS.sendMenssager("Hola");
    }
}

interface Notification{
    public void sendMenssager(String message);
}

class NotificationEmail implements Notification{

    @Override
    public void sendMenssager(String message) {
        System.out.println("Enviado correo: " + message);

    }
}

class NotificationSMS implements Notification{

    @Override
    public void sendMenssager(String message) {
        System.out.println("Enviado SMS: " + message);

    }
}