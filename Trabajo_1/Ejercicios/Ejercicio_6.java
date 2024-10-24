/*
package Trabajo_1.Ejercicios;

import utilities.userinput.InputHandler;
import utilities.userinput.ValidatorFactory;
import java.util.function.Predicate;


public class Ejercicio_6 {
    public static void main(String[] args) {

        Predicate<Integer> rangoValidador = ValidatorFactory.betweenInclusive(0, 59);


        int horas = InputHandler.getInteger("Ingrese el número de horas: ",true);

        int minutos = InputHandler.getInteger("Ingrese el número de minutos: ",rangoValidador, true);

        int segundos = InputHandler.getInteger("Ingrese el número de segundos: ", rangoValidador,true);

        int totalSegundos = convertirASegundos(horas, minutos, segundos);
        System.out.println("El equivalente en segundos es: " + totalSegundos);
    }

    public static int convertirASegundos(int horas, int minutos, int segundos) {
        return horas * 3600 + minutos * 60 + segundos;
    }
}*/
