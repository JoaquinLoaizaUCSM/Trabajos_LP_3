/*
package Trabajo_4.Ejercicios;

import utilities.consolemenu.*;
import utilities.userinput.InputValidator;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ejercicio_4 {

    public static void main(String[] args) {
        ConsoleMenu menu = new ConsoleMenu("Registro de Estudiantes",new MenuInputHandler(new InputValidator()));
        RegistroEstudiantes registro = new RegistroEstudiantes();

        // Add menu options
        menu.addOption(new MenuEstandar("Agregar Estudiante", () -> agregarEstudiante(registro)));
        menu.addOption(new MenuEstandar("Buscar Estudiante", () -> buscarEstudiante(registro)));
        menu.addOption(new MenuEstandar("Salir", Ejercicio_4::salirDelPrograma));

        // Show the menu
        menu.show();
    }

    public static void agregarEstudiante(RegistroEstudiantes registro) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();

        try {
            registro.agregarEstudiante(nombre);
            System.out.println("Estudiante agregado exitosamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al agregar estudiante: " + e.getMessage());
        }
    }

    public static void buscarEstudiante(RegistroEstudiantes registro) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del estudiante a buscar: ");
        String nombre = scanner.nextLine();

        try {
            String estudiante = registro.buscarEstudiante(nombre);
            System.out.println("Estudiante encontrado: " + estudiante);
        } catch (NoSuchElementException e) {
            System.out.println("Error al buscar estudiante: " + e.getMessage());
        }
    }

    public static void salirDelPrograma() {
        System.out.println("Gracias por usar el programa de registro.");
        System.exit(0);
    }
}

// Implementación de la clase RegistroEstudiantes
class RegistroEstudiantes {
    private ArrayList<String> estudiantes;

    public RegistroEstudiantes() {
        estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(String nombre) throws IllegalArgumentException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        estudiantes.add(nombre);
    }

    public String buscarEstudiante(String nombre) throws NoSuchElementException {
        for (String estudiante : estudiantes) {
            if (estudiante.equalsIgnoreCase(nombre)) {
                return estudiante;
            }
        }
        throw new NoSuchElementException("Estudiante no encontrado: " + nombre);
    }
}
*/
