package Trabajo_7.Ejercicios.Ejercicio1.model;

import java.io.Serializable;

public class Personaje implements Serializable {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int alcance;
    private int nivel;
    private static final long serialVersionUID = 1L;

    public Personaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        setNombre(nombre);
        setVida(vida);
        setAtaque(ataque);
        setDefensa(defensa);
        setAlcance(alcance);
        this.nivel = 1;
    }

    private int verificarValor(int valor){
        if(valor < 0){
            return 0;
        }
        return valor;
    }

    private void validarValorPositivo(int valor, String campo) {
        if (valor <= 0) {
            throw new IllegalArgumentException("El " + campo + " debe ser positivo");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = verificarValor(vida);
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        validarValorPositivo(ataque, "valor de ataque");
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = verificarValor(defensa);
    }

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        validarValorPositivo(alcance, "valor de alcance");
        this.alcance = alcance;
    }

    public int getNivel() {
        return nivel;
    }

    public void subirNivel() {
        this.nivel++;
        this.vida += 5;
        this.ataque += 2;
        this.defensa += 2;
    }

    @Override
    public String toString() {
        return String.format("Personaje[nombre='%s', nivel=%d, vida=%d, ataque=%d, defensa=%d, alcance=%d]",
                nombre, nivel, vida, ataque, defensa, alcance);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Personaje personaje = (Personaje) obj;
        return nombre.equals(personaje.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}