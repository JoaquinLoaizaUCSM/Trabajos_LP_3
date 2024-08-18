package Trabajo_1.Ejercicios;

import java.util.Random;

public class Ejercicio_3 {
    public static void main(String[] args) {
        int[] resultados = lanzarDado();
        for (int i = 0; i < resultados.length; i++) {
            System.out.println("Cara " + (i + 1) + ": " + resultados[i] + " veces");
        }
    }

    public static int[] lanzarDado() {
        int[] frecuencia = new int[6];
        Random random = new Random();
        for (int i = 0; i < 20000; i++) {
            int resultado = random.nextInt(6) + 1;
            frecuencia[resultado - 1]++;
        }
        return frecuencia;
    }
}