package Trabajo_3.Ejercicios;

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
        return 100;  // Penalización del 100%
    }
}

class PoliticaCancelacionFlexible implements PoliticaCancelacion {

    @Override
    public boolean puedeCancelar(Reserva reserva) {
        // Permite cancelar sin penalización hasta 24 horas antes
        // Implementación de la lógica de cancelación
        return true;
    }

    @Override
    public double calcularPenalizacion(Reserva reserva) {
        return 0;  // Sin penalización
    }
}


class PoliticaCancelacionModerada implements PoliticaCancelacion {

    @Override
    public boolean puedeCancelar(Reserva reserva) {
        // Permite cancelar con una penalización del 50% hasta 72 horas antes
        return true;
    }

    @Override
    public double calcularPenalizacion(Reserva reserva) {
        return 50;  // Penalización del 50%
    }
}
