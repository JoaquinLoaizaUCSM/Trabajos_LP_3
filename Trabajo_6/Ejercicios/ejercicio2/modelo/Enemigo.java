package modelo;

import java.util.HashMap;
import java.util.Map;

public class Enemigo {
    private String nombre;
    private int saludMaxima;
    private int saludActual;
    private int nivel;
    private String tipo;
    private Map<String, int[]> efectosActivos; // [duracion, valor]

    public Enemigo(String nombre, String tipo, int nivel) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.saludMaxima = nivel * 20;
        this.saludActual = saludMaxima;
        this.efectosActivos = new HashMap<>();
    }

    public int atacar() {
        if (efectosActivos.containsKey("Congelado")) {
            System.out.println(nombre + " está congelado y no puede atacar.");
            return 0;
        }
        int danio = nivel * 2;
        System.out.println(nombre + " ataca causando " + danio + " de daño.");
        return danio;
    }

    public void recibirDanio(int danio) {
        saludActual -= danio;
        if (saludActual < 0) saludActual = 0;
        System.out.println(nombre + " recibe " + danio + " de daño. Salud actual: " + saludActual);
    }

    public void aplicarEfecto(String efecto, int valor, int duracion) {
        efectosActivos.put(efecto, new int[]{duracion, valor});
        System.out.println(nombre + " sufre el efecto de " + efecto + ".");
    }

    public void actualizarEfectos() {
        for (Map.Entry<String, int[]> entry : new HashMap<>(efectosActivos).entrySet()) {
            String efecto = entry.getKey();
            int[] datos = entry.getValue();
            if (efecto.equals("Envenenado") || efecto.equals("Quemado")) {
                recibirDanio(datos[1]);
                System.out.println(nombre + " sufre " + datos[1] + " de daño por estar " + efecto + ".");
            }
            datos[0]--;
            if (datos[0] <= 0) {
                efectosActivos.remove(efecto);
                System.out.println("El efecto de " + efecto + " en " + nombre + " ha terminado.");
            } else {
                efectosActivos.put(efecto, datos);
            }
        }
    }

    public String getNombre() { return nombre; }
    public int getSaludActual() { return saludActual; }
    public int getNivel() { return nivel; }
    public String getTipo() { return tipo; }
}