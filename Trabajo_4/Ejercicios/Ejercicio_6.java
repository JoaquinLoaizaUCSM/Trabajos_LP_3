package Trabajo_4.Ejercicios;

import utilities.consolemenu.*;
import utilities.userinput.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class Ejercicio_6 {
    public static void main(String[] args) {
        ConsoleMenu menu = new ConsoleMenu("Gestión Inmobiliaria",new MenuInputHandler(new InputValidator()));
        Scanner scanner = new Scanner(System.in);

        // Crear instancias iniciales de gestor de datos
        AtomicReference<Propiedad> propiedad = new AtomicReference<>();
        ContratoAlquiler contrato = new ContratoAlquiler();
        HistorialDePagos historial = new HistorialDePagos();

        // Opciones del menú
        menu.addOption(new MenuEstandar("Crear propiedad", () -> propiedad.set(crearPropiedad(scanner))));
        menu.addOption(new MenuEstandar("Realizar transacción", () -> realizarTransaccion(scanner, propiedad.get())));
        menu.addOption(new MenuEstandar("Establecer contrato de alquiler", () -> establecerContrato(scanner, contrato, propiedad.get())));
        menu.addOption(new MenuEstandar("Registrar pago", () -> registrarPago(scanner, historial)));
        menu.addOption(new MenuEstandar("Salir", Ejercicio_6::salirDelPrograma));

        // Mostrar el menú
        menu.show();
    }

    public static Propiedad crearPropiedad(Scanner scanner) {
        try {
            System.out.print("Ingrese la dirección: ");
            String direccion = scanner.nextLine();
            System.out.print("Ingrese el precio: ");
            double precio = scanner.nextDouble();
            System.out.print("Ingrese el tamaño: ");
            double tamaño = scanner.nextDouble();
            scanner.nextLine(); // Consumir el salto de línea

            Propiedad propiedad = new Propiedad(direccion, precio, tamaño);
            System.out.println("Propiedad creada exitosamente: " + propiedad.getDireccion());
            return propiedad;
        } catch (DatosInvalidosException e) {
            System.out.println("Error al crear la propiedad: " + e.getMessage());
        }
        return null;
    }

    public static void realizarTransaccion(Scanner scanner, Propiedad propiedad) {
        if (propiedad == null) {
            System.out.println("Debe crear una propiedad primero.");
            return;
        }

        try {
            System.out.print("Ingrese el ID de la transacción: ");
            int id = scanner.nextInt();
            System.out.print("Ingrese el precio de la transacción: ");
            double precioTransaccion = scanner.nextDouble();
            scanner.nextLine(); // Consumir el salto de línea

            TransaccionInmobiliaria transaccion = new TransaccionInmobiliaria(id, propiedad, precioTransaccion);
            System.out.println("Transacción realizada: ID " + transaccion.getId() + ", Precio: " + transaccion.getPrecioTransaccion());
        } catch (PrecioInferiorException e) {
            System.out.println("Error en la transacción: " + e.getMessage());
        }
    }

    public static void establecerContrato(Scanner scanner, ContratoAlquiler contrato, Propiedad propiedad) {
        if (propiedad == null) {
            System.out.println("Debe crear una propiedad primero.");
            return;
        }

        try {
            System.out.print("Ingrese la duración del contrato en meses: ");
            int meses = scanner.nextInt();
            System.out.print("Ingrese el monto del alquiler mensual: ");
            double monto = scanner.nextDouble();
            scanner.nextLine(); // Consumir el salto de línea

            contrato.establecerContrato(propiedad, meses, monto);
            System.out.println("Contrato de alquiler establecido por " + contrato.getDuracionMeses() + " meses, $" + contrato.getMontoAlquiler() + "/mes.");
        } catch (ContratoInvalidoException e) {
            System.out.println("Error al establecer el contrato: " + e.getMessage());
        }
    }

    public static void registrarPago(Scanner scanner, HistorialDePagos historial) {
        try {
            System.out.print("Ingrese el monto del pago: ");
            double monto = scanner.nextDouble();
            Date fecha = new Date(); // Registrar el pago en la fecha actual
            scanner.nextLine(); // Consumir el salto de línea

            historial.registrarPago(fecha, monto);
            System.out.println("Pago registrado exitosamente.");
        } catch (PagoInvalidoException e) {
            System.out.println("Error al registrar el pago: " + e.getMessage());
        }
    }

    public static void salirDelPrograma() {
        System.out.println("Gracias por usar el sistema de gestión inmobiliaria.");
        System.exit(0);
    }
}

// Clases de excepciones, propiedad, transacción, contrato y pagos (sin cambios)
class DatosInvalidosException extends Exception {
    public DatosInvalidosException(String mensaje) {
        super(mensaje);
    }
}

class PrecioInferiorException extends Exception {
    public PrecioInferiorException(String mensaje) {
        super(mensaje);
    }
}

class ContratoInvalidoException extends Exception {
    public ContratoInvalidoException(String mensaje) {
        super(mensaje);
    }
}

class PagoInvalidoException extends Exception {
    public PagoInvalidoException(String mensaje) {
        super(mensaje);
    }
}

class Propiedad {
    private final String direccion;
    private final double precio;
    private final double tamano;

    public Propiedad(String direccion, double precio, double tamano) throws DatosInvalidosException {
        if (precio <= 0 || tamano <= 0) {
            throw new DatosInvalidosException("El precio y el tamaño deben ser positivos");
        }
        this.direccion = direccion;
        this.precio = precio;
        this.tamano = tamano;
    }

    // Getters
    public String getDireccion() { return direccion; }
    public double getPrecio() { return precio; }
}

class TransaccionInmobiliaria {
    private final int id;
    private final Propiedad propiedad;
    private final double precioTransaccion;

    public TransaccionInmobiliaria(int id, Propiedad propiedad, double precioTransaccion) throws PrecioInferiorException {
        if (precioTransaccion < propiedad.getPrecio()) {
            throw new PrecioInferiorException("El precio de la transacción es inferior al precio de la propiedad");
        }
        this.id = id;
        this.propiedad = propiedad;
        this.precioTransaccion = precioTransaccion;
    }

    // Getters
    public int getId() { return id; }
    public double getPrecioTransaccion() { return precioTransaccion; }
}

class ContratoAlquiler {
    private Propiedad propiedad;
    private int duracionMeses;
    private double montoAlquiler;

    public void establecerContrato(Propiedad propiedad, int duracionMeses, double montoAlquiler) throws ContratoInvalidoException {
        if (duracionMeses <= 0 || montoAlquiler <= 0) {
            throw new ContratoInvalidoException("La duración y el monto del alquiler deben ser positivos");
        }
        this.propiedad = propiedad;
        this.duracionMeses = duracionMeses;
        this.montoAlquiler = montoAlquiler;
    }

    // Getters
    public int getDuracionMeses() { return duracionMeses; }
    public double getMontoAlquiler() { return montoAlquiler; }
}

class HistorialDePagos {
    private final List<Pago> pagos = new ArrayList<>();

    public void registrarPago(Date fecha, double monto) throws PagoInvalidoException {
        if (fecha.after(new Date()) || monto <= 0) {
            throw new PagoInvalidoException("La fecha no puede ser futura y el monto debe ser positivo");
        }
        pagos.add(new Pago(fecha, monto));
    }

    public List<Pago> getPagos() {
        return new ArrayList<>(pagos);
    }
}

class Pago {
    private final Date fecha;
    private final double monto;

    public Pago(Date fecha, double monto) {
        this.fecha = fecha;
        this.monto = monto;
    }

    // Getters
    public Date getFecha() { return fecha; }
}
