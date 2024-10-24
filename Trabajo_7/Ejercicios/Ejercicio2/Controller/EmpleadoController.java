package Trabajo_7.Ejercicios.Ejercicio2.Controller;


import Trabajo_7.Ejercicios.Ejercicio2.Model.Empleado;

import java.io.*;
import java.util.ArrayList;

public class EmpleadoController {
    private static final String ARCHIVO_EMPLEADOS = "empleados.txt";
    private ArrayList<Empleado> empleados = new ArrayList<>();
    public EmpleadoController() {leerEmpleados();}

    public void leerEmpleados() {
        empleados.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_EMPLEADOS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Empleado empleado = Empleado.fromCSV(linea);
                empleados.add(empleado);
            }
            System.out.println("Empleados cargados correctamente.");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, se creará uno nuevo.");
        } catch (IOException e) {
            System.out.println("Error al leer los empleados: " + e.getMessage());
        }
    }
    public void listarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            empleados.forEach(System.out::println);
        }
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        guardarEmpleados();
        System.out.println("Empleado agregado con éxito.");
    }

    public Empleado buscarEmpleado(int numero) {
        for (Empleado emp : empleados) {
            if (emp.getNumero() == numero) {
                return emp;
            }
        }
        return null;
    }

    public void eliminarEmpleado(int numero) {
        Empleado empleado = buscarEmpleado(numero);
        if (empleado != null) {
            empleados.remove(empleado);
            guardarEmpleados();
            System.out.println("Empleado eliminado con éxito.");
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private void guardarEmpleados() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_EMPLEADOS))) {
            for (Empleado emp : empleados) {
                bw.write(emp.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los empleados: " + e.getMessage());
        }
    }
}

