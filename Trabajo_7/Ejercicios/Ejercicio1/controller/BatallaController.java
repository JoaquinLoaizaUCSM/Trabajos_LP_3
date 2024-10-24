package Trabajo_7.Ejercicios.Ejercicio1.controller;


import Trabajo_7.Ejercicios.Ejercicio1.model.Batalla;
import Trabajo_7.Ejercicios.Ejercicio1.model.Personaje;
import Trabajo_7.Ejercicios.Ejercicio1.view.BatallaView;

public class BatallaController {
    private Batalla batalla;
    private final BatallaView view;

    public BatallaController(BatallaView view) {
        this.view = view;
    }

    public void iniciarBatalla(Personaje personaje1, Personaje personaje2) {
        batalla = new Batalla(personaje1, personaje2);
        view.mostrarInicioBatalla(personaje1, personaje2);
    }

    public void ejecutarTurno() {
        if (batalla == null) {
            view.mostrarError("No hay una batalla en curso");
            return;
        }

        String resultado = batalla.ejecutarTurno();
        view.mostrarTurno(resultado);
        view.actualizarEstadoBatalla(batalla.getPersonaje1(), batalla.getPersonaje2());

        if (batalla.isFinalizada()) {
            view.mostrarFinBatalla(batalla.getGanador());
        }
    }

    public void simularBatallaCompleta() {
        if (batalla == null) {
            view.mostrarError("No hay una batalla en curso");
            return;
        }

        while (!batalla.isFinalizada()) {
            ejecutarTurno();
            try {
                Thread.sleep(1000); // Pausa para mejor visualización
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public boolean hayBatallaEnCurso() {
        return batalla != null && !batalla.isFinalizada();
    }
}