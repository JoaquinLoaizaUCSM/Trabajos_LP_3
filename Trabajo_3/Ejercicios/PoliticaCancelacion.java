package Trabajo_3.Ejercicios;

import java.util.Date;

public interface PoliticaCancelacion {
    boolean puedeCancelar(Reserva reserva);
    double calcularPenalizacion(Reserva reserva);
}

class PoliticaCancelacionEstricta implements PoliticaCancelacion {

    @Override
    public boolean puedeCancelar(Reserva reserva) {
        // No permite cancelar después de realizar la reserva
        return false;
    }

    @Override
    public double calcularPenalizacion(Reserva reserva) {
        return 100;
    }
}

class PoliticaCancelacionFlexible implements PoliticaCancelacion {

    @Override
    public boolean puedeCancelar(Reserva reserva) {
        Date ahora = new Date();
        long diferencia = reserva.getFechaInicio().getTime() - ahora.getTime();
        long horas = diferencia / (1000 * 60 * 60);
        return horas >= 24;
    }

    @Override
    public double calcularPenalizacion(Reserva reserva) {
        return 0;
    }
}

class PoliticaCancelacionModerada implements PoliticaCancelacion {

    @Override
    public boolean puedeCancelar(Reserva reserva) {
        // Permite cancelar con una penalización del 50% hasta 72 horas antes
        Date ahora = new Date();
        long diferencia = reserva.getFechaInicio().getTime() - ahora.getTime();
        long horas = diferencia / (1000 * 60 * 60);
        return horas >= 72;
    }

    @Override
    public double calcularPenalizacion(Reserva reserva) {
        Date ahora = new Date();
        long diferencia = reserva.getFechaInicio().getTime() - ahora.getTime();
        long horas = diferencia / (1000 * 60 * 60);
        return horas >= 72 ? 0 : 50;  // Penalización del 50% si cancela dentro de las 72 horas
    }
}