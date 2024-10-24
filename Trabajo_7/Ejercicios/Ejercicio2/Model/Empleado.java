package Trabajo_7.Ejercicios.Ejercicio2.Model;
import java.io.Serializable;

public class Empleado implements Serializable {
    private int numero;
    private String nombre;
    private double sueldo;

    public Empleado(int numero, String nombre, double sueldo) {
        this.numero = numero;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public int getNumero() {return numero;}
    public void setNumero(int numero) {this.numero = numero;}
    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}
    public double getSueldo() {return sueldo;}
    public void setSueldo(double sueldo) {this.sueldo = sueldo;}

    @Override
    public String toString() {
        return "Empleado{" +
                "Numero=" + numero +
                ", Nombre='" + nombre + '\'' +
                ", Sueldo=" + sueldo +
                '}';
    }
    public String toCSV() {
        return numero + "," + nombre + "," + sueldo;
    }

    public static Empleado fromCSV(String lineaCSV) {
        String[] datos = lineaCSV.split(",");
        int numero = Integer.parseInt(datos[0]);
        String nombre = datos[1];
        double sueldo = Double.parseDouble(datos[2]);
        return new Empleado(numero, nombre, sueldo);
    }
}

