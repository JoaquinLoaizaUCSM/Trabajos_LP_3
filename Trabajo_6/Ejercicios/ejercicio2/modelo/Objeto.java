package modelo;

import modelo.Jugador;
import modelo.Enemigo;

import java.util.Random;

public class Objeto {
    private String nombre;
    private int danioBase;
    private int efecto;
    private TipoEfecto tipoEfecto;

    public enum TipoEfecto {
        NINGUNO, CURACION, VENENO, FUEGO, HIELO
    }

    public Objeto(String nombre, int danioBase, int efecto, TipoEfecto tipoEfecto) {
        this.nombre = nombre;
        this.danioBase = danioBase;
        this.efecto = efecto;
        this.tipoEfecto = tipoEfecto;
    }

    public int calcularDanio() {
        Random rand = new Random();
        int variacion = rand.nextInt(3) - 1; // -1, 0, o 1
        return danioBase + variacion;
    }

    public void aplicarEfecto(Jugador jugador, Enemigo enemigo) {
        switch (tipoEfecto) {
            case CURACION:
                jugador.curar(efecto);
                break;
            case VENENO:
                enemigo.aplicarEfecto("Envenenado", efecto, 3);
                break;
            case FUEGO:
                enemigo.aplicarEfecto("Quemado", efecto, 2);
                break;
            case HIELO:
                enemigo.aplicarEfecto("Congelado", 0, 1);
                break;
            default:
                break;
        }
    }

    public String getNombre() { return nombre; }
    public int getDanioBase() { return danioBase; }
    public int getEfecto() { return efecto; }
    public TipoEfecto getTipoEfecto() { return tipoEfecto; }
}