package Trabajo_11.Ejercicios;

import java.util.Scanner;


interface EstrategiaDescuento {
    double aplicarDescuento(double precio, int cantidad, String temporada);
}

class SinDescuento implements EstrategiaDescuento {
    @Override
    public double aplicarDescuento(double precio, int cantidad, String temporada) {
        return precio;
    }
}

class DescuentoFijo implements EstrategiaDescuento {
    @Override
    public double aplicarDescuento(double precio, int cantidad, String temporada) {
        return precio * 0.9; // 10% de descuento
    }
}

class DescuentoPorcentaje implements EstrategiaDescuento {
    @Override
    public double aplicarDescuento(double precio, int cantidad, String temporada) {
        if (cantidad >= 2) {
            return precio * 0.7; // 30% de descuento por 2 o más ítems
        }
        return precio;
    }
}

class DescuentoEstacional implements EstrategiaDescuento {
    @Override
    public double aplicarDescuento(double precio, int cantidad, String temporada) {
        double descuento = 0.0;
        if (temporada.equals("verano")) {
            descuento = 0.1;  // 10% de descuento en verano
        } else if (temporada.equals("invierno")) {
            descuento = 0.15; // 15% de descuento en invierno
        }
        return precio * (1 - descuento);
    }
}

class Producto {
    private final String nombre;
    private final double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public double obtenerPrecio() {
        return precio;
    }

    public String obtenerNombre() {
        return nombre;
    }
}

class CalculadorPrecio {
    private EstrategiaDescuento estrategiaDescuento;

    public void establecerEstrategiaDescuento(EstrategiaDescuento estrategiaDescuento) {
        this.estrategiaDescuento = estrategiaDescuento;
    }

    public double calcularPrecio(Producto producto, int cantidad, String temporada) {
        return estrategiaDescuento.aplicarDescuento(producto.obtenerPrecio(), cantidad, temporada);
    }
}

public class Ejercicio2 {
    public static void main(String[] args) {
        Producto producto = new Producto("Laptop", 1000.0);
        CalculadorPrecio calculador = new CalculadorPrecio();

        Scanner lector = new Scanner(System.in);

        System.out.println("Ingrese la temporada (verano, invierno): ");
        String temporada = lector.nextLine();

        System.out.println("Ingrese la cantidad: ");
        int cantidad = lector.nextInt();

        calculador.establecerEstrategiaDescuento(new DescuentoEstacional());
        double precioFinal = calculador.calcularPrecio(producto, cantidad, temporada);

        System.out.println("Precio final después del descuento: " + precioFinal);
    }
}