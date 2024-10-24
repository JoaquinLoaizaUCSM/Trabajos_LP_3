package Trabajo_7.Ejercicios.Ejercicio2.View;

import java.util.Scanner;

import Trabajo_7.Ejercicios.Ejercicio2.Model.Empleado;
import utilities.consoleinput.validators.IntegerValidator;
import utilities.consoleinput.validators.StringValidator;
import utilities.consolemenu.command.*;
import utilities.consolemenu.model.*;
import utilities.consolemenu.renderer.*;
import utilities.consolemenu.input.*;
import utilities.consoleinput.InputReader;
import utilities.consoleinput.Messages;

public class EmpleadoView {
    private Scanner scanner = new Scanner(System.in);
    //MenuRenderer renderer = new DefaultMenuRenderer();
    //InputValidator inputValidator = new DefaultInputValidator();

    public int mostrarMenu() {
        //Menu menuPrincipal = new Menu("Menú de Empleados");
        //menuPrincipal.setInputValidator(inputValidator);
        //menuPrincipal.setRenderer(renderer);
        System.out.println("Menú de Empleados:");
        System.out.println("1. Listar todos los empleados");
        System.out.println("2. Agregar un nuevo empleado");
        System.out.println("3. Buscar un empleado por número");
        System.out.println("4. Eliminar un empleado por número");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public Empleado ingresarDatosEmpleado() {
        System.out.print("Ingrese el número del empleado: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el sueldo del empleado: ");
        double sueldo = scanner.nextDouble();

        return new Empleado(numero, nombre, sueldo);
    }

    public int solicitarNumeroEmpleado() {
        System.out.print("Ingrese el número del empleado: ");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarEmpleado(Empleado empleado) {
        if (empleado != null) {
            System.out.println(empleado);
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }
}
