package Trabajo_4.Actividades;

import java.io.*;
import java.util.*;



class HistorialVacioException extends Exception {
    public HistorialVacioException(String mensaje) {
        super(mensaje);
    }
}


class ReporteTransacciones {
    public void generarReporte(CuentaBancaria cuenta, String nombreArchivo) throws IOException, HistorialVacioException {
        if (cuenta.getHistorial().isEmpty()) {
            throw new HistorialVacioException("La cuenta no tiene transacciones para generar un reporte");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write("Reporte de Transacciones\n");
            writer.write("Número de Cuenta: " + cuenta.getNumeroCuenta() + "\n");
            writer.write("Titular: " + cuenta.getTitular() + "\n");
            writer.write("Saldo Actual: " + cuenta.getSaldo() + "\n\n");
            writer.write("Historial de Transacciones:\n");

            for (String transaccion : cuenta.getHistorial()) {
                writer.write(transaccion + "\n");
            }
        }
    }

    public List<String> leerReporte(String nombreArchivo) throws IOException {
        List<String> lineas = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(nombreArchivo))) {
            while (scanner.hasNextLine()) {
                lineas.add(scanner.nextLine());
            }
        }
        return lineas;
    }
}

public class Actividad_4 {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("123456", "Juan Pérez", 1000);
        ReporteTransacciones reporteTransacciones = new ReporteTransacciones();

        try {
            cuenta.depositar(500);
            cuenta.retirar(200);

            // Generar reporte
            reporteTransacciones.generarReporte(cuenta, "reporte_transacciones.txt");
            System.out.println("Reporte generado exitosamente.");

            // Leer y mostrar el reporte
            List<String> contenidoReporte = reporteTransacciones.leerReporte("reporte_transacciones.txt");
            System.out.println("\nContenido del reporte:");
            for (String linea : contenidoReporte) {
                System.out.println(linea);
            }

        } catch (SaldoInsuficienteException | HistorialVacioException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        } catch (LimiteCreditoExcedidoException e) {
            throw new RuntimeException(e);
        }


        try {
            CuentaBancaria cuentaVacia = new CuentaBancaria("789012", "Ana López", 0);
            reporteTransacciones.generarReporte(cuentaVacia, "reporte_vacio.txt");
        } catch (HistorialVacioException e) {
            System.out.println("Error esperado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S inesperado: " + e.getMessage());
        }
    }
}
