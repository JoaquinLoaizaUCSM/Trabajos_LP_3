package modelo;

import modelo.Objeto;
import modelo.Enemigo;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private int saludMaxima;
    private int saludActual;
    private int nivel;
    private List<Objeto> inventario;
    private Objeto objetoEquipado;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.saludMaxima = 100;
        this.saludActual = 100;
        this.nivel = 1;
        this.inventario = new ArrayList<>();
    }

    public int atacar() {
        if (objetoEquipado != null) {
            int danio = objetoEquipado.calcularDanio() + nivel;
            System.out.println(nombre + " ataca con " + objetoEquipado.getNombre() + " causando " + danio + " de daño.");
            return danio;
        }
        int danio = nivel;
        System.out.println(nombre + " ataca con sus puños causando " + danio + " de daño.");
        return danio;
    }

    public void usarObjeto(Objeto objeto, Enemigo enemigo) {
        if (inventario.contains(objeto)) {
            objeto.aplicarEfecto(this, enemigo);
            System.out.println(nombre + " usa " + objeto.getNombre() + ".");
            if (objeto.getTipoEfecto() == Objeto.TipoEfecto.CURACION) {
                inventario.remove(objeto);
            }
        }
    }

    public void recibirDanio(int danio) {
        saludActual -= danio;
        if (saludActual < 0) saludActual = 0;
        System.out.println(nombre + " recibe " + danio + " de daño. Salud actual: " + saludActual);
    }

    public void curar(int cantidad) {
        saludActual += cantidad;
        if (saludActual > saludMaxima) saludActual = saludMaxima;
        System.out.println(nombre + " se cura " + cantidad + " puntos de salud. Salud actual: " + saludActual);
    }


    public String getNombre() { return nombre; }
    public int getSaludActual() { return saludActual; }
    public int getNivel() { return nivel; }
    public List<Objeto> getInventario() { return inventario; }
    public Objeto getObjetoEquipado() { return objetoEquipado; }
    public void setObjetoEquipado(Objeto objeto) {
        this.objetoEquipado = objeto;
        System.out.println(nombre + " equipa " + objeto.getNombre() + ".");
    }
}