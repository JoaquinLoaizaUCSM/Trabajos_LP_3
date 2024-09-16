package Trabajo_1.Ejercicios;

import utilities.userinput.InputHandler;

public class Ejercicio_5 {
    public static void main(String[] args) {

        int horas = InputHandler.getInteger("Ingrese el número de horas: ", true);

        double cargo = calcularCargo(horas);
        System.out.printf("El cargo en soles es: S/%.2f%n", cargo);
    }

    public static double calcularCargo(double horas) {
        double cargo;


        if (horas == 1) {
            cargo = 3.00;
        }

        else if (horas > 24) {
            double residuo = horas % 24;
            int day = (int) (horas/24);

            if (residuo - 1 < 0){residuo = 1;}

            cargo = (3.00 + (residuo - 1) * 0.50) + day * 12;

        } else {

            if (horas == 0) {
                return 0;
            }
            cargo = Math.min(3.00 + (horas - 1) * 0.50, 12.00);
        }

        return cargo;
    }
}