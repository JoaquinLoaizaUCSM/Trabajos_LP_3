package Trabajo_4.Ejercicios;

import utilities.consolemenu.*;
import utilities.userinput.*;


public class Ejercicio_2 {

    public static void main(String[] args) {
        ConsoleMenu menu = new ConsoleMenu("Calculadora", new MenuInputHandler(new InputValidator()));

        // Add options for each arithmetic operation
        menu.addOption(new MenuEstandar("Sumar", () -> realizarOperacion("sumar")));
        menu.addOption(new MenuEstandar("Restar", () -> realizarOperacion("restar")));
        menu.addOption(new MenuEstandar("Multiplicar", () -> realizarOperacion("multiplicar")));
        menu.addOption(new MenuEstandar("Dividir", () -> realizarOperacion("dividir")));
        menu.addOption(new MenuEstandar("Salir", Ejercicio_2::salirDelPrograma));

        // Start menu
        menu.show();
    }

    public static void realizarOperacion(String operacion) {
        Calculadora calc = new Calculadora();

        // Get inputs from the user
        double a = InputHandler.getDouble("Ingrese el primer número: ");
        double b = InputHandler.getDouble("Ingrese el segundo número: ");

        try {
            switch (operacion) {
                case "sumar":
                    System.out.println("Resultado de la suma: " + calc.sumar(a, b));
                    break;
                case "restar":
                    System.out.println("Resultado de la resta: " + calc.restar(a, b));
                    break;
                case "multiplicar":
                    System.out.println("Resultado de la multiplicación: " + calc.multiplicar(a, b));
                    break;
                case "dividir":
                    System.out.println("Resultado de la división: " + calc.dividir(a, b));
                    break;
            }
        } catch (DivisionPorCeroException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void salirDelPrograma() {
        System.out.println("Gracias por usar la calculadora.");
        System.exit(0);
    }
}

// Excepciones personalizadas
class DivisionPorCeroException extends Exception {
    public DivisionPorCeroException(String mensaje) {
        super(mensaje);
    }
}

// Clase calculadora que implementa las operaciones
class Calculadora {
    public double sumar(double a, double b) {
        return a + b;
    }

    public double restar(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) throws DivisionPorCeroException {
        if (b == 0) {
            throw new DivisionPorCeroException("No se puede dividir por cero");
        }
        return a / b;
    }
}
