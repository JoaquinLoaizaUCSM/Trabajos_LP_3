package Trabajo_7.Ejercicios.Ejercicio1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Batalla {
    private final Personaje personaje1;
    private final Personaje personaje2;
    private final List<String> historialTurnos;
    private boolean finalizada;
    private Personaje ganador;
    
    public Batalla(Personaje personaje1, Personaje personaje2) {
        this.personaje1 = new Personaje(personaje1.getNombre(), personaje1.getVida(), 
                                      personaje1.getAtaque(), personaje1.getDefensa(), 
                                      personaje1.getAlcance());
        this.personaje2 = new Personaje(personaje2.getNombre(), personaje2.getVida(), 
                                      personaje2.getAtaque(), personaje2.getDefensa(), 
                                      personaje2.getAlcance());
        this.historialTurnos = new ArrayList<>();
        this.finalizada = false;
    }

    public String ejecutarTurno() {
        if (finalizada) {
            return "La batalla ha terminado. Ganador: " + ganador.getNombre();
        }

        Random rand = new Random();
        Personaje atacante = rand.nextBoolean() ? personaje1 : personaje2;
        Personaje defensor = (atacante == personaje1) ? personaje2 : personaje1;

        int danioBase = atacante.getAtaque();
        int modificadorDefensa = defensor.getDefensa();
        int danioFinal = Math.max(1, danioBase - modificadorDefensa);

        defensor.setVida(defensor.getVida() - danioFinal);
        
        String resultado = String.format("%s ataca a %s causando %d de daño (Vida restante: %d)",
            atacante.getNombre(), defensor.getNombre(), danioFinal, defensor.getVida());
        
        historialTurnos.add(resultado);

        if (defensor.getVida() <= 0) {
            finalizada = true;
            ganador = atacante;
            resultado += "\n¡Batalla terminada! Ganador: " + ganador.getNombre();
        }

        return resultado;
    }

    public List<String> getHistorialTurnos() {
        return new ArrayList<>(historialTurnos);
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public Personaje getGanador() {
        return ganador;
    }

    public Personaje getPersonaje1() {
        return personaje1;
    }

    public Personaje getPersonaje2() {
        return personaje2;
    }
}