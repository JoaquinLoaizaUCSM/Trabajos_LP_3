/*
package Trabajo_1.Ejercicios;

import java.util.ArrayList;
import utilities.userinput.InputHandler;

public class Ejercicio_2 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = getNumArray();
        System.out.println("Arreglo final: " + numeros);
    }

    public static ArrayList<Integer> getNumArray() {
        ArrayList<Integer> arreglo = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            while (true) {

            int num = InputHandler.getInteger("Ingrese el número " + (i + 1) + " (debe ser mayor que el anterior): ");
            if (i == 0 || num > arreglo.get(arreglo.size() - 1)) {
                arreglo.add(num);
                break;
            } else {System.out.println("El número debe ser mayor que el anterior.");}

            }
        }
        return arreglo;
    }
}*/
