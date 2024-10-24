package Trabajo_7.Ejercicios.Ejercicio2;


import Trabajo_7.Ejercicios.Ejercicio2.Controller.EmpleadoController;
import Trabajo_7.Ejercicios.Ejercicio2.Model.Empleado;
import Trabajo_7.Ejercicios.Ejercicio2.View.EmpleadoView;

public class Principal {
    public static void main(String[] args) {
        EmpleadoView vista = new EmpleadoView();
        EmpleadoController controlador = new EmpleadoController();

        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    controlador.listarEmpleados();
                    break;
                case 2:
                    Empleado nuevoEmpleado = vista.ingresarDatosEmpleado();
                    controlador.agregarEmpleado(nuevoEmpleado);
                    break;
                case 3:
                    int numeroBuscar = vista.solicitarNumeroEmpleado();
                    Empleado empleado = controlador.buscarEmpleado(numeroBuscar);
                    vista.mostrarEmpleado(empleado);
                    break;
                case 4:
                    int numeroEliminar = vista.solicitarNumeroEmpleado();
                    controlador.eliminarEmpleado(numeroEliminar);
                    break;
                case 5:
                    vista.mostrarMensaje("Saliendo del programa...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
                    break;
            }
        } while (opcion != 5);
    }
}
