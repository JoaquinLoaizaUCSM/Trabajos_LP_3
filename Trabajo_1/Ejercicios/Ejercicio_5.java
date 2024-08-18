package Trabajo_1.Ejercicios;

import utilities.userinput.InputHandler;

public class Ejercicio_5 {
    public static void main(String[] args) {

        int horas = InputHandler.getInteger("Ingrese el número de horas: ", true);

        double cargo = calcularCargo(horas);
        System.out.printf("El cargo es: S/%.2f%n", cargo);
    }

    public static double calcularCargo(double horas) {
        double cargo;
        if (horas <= 1) {
            cargo = 3.00;
        } else {
            cargo = 3.00 + (horas - 1) * 0.50;
        }
        return Math.min(cargo, 12.00);
    }
}