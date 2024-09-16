package Trabajo_4.Ejercicios;

import utilities.consolemenu.*;
import utilities.userinput.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio_5 {
    public static void main(String[] args) {
        GestorContactos gestor = new GestorContactos();
        ConsoleMenu menu = new ConsoleMenu("Gestor de Contactos", new MenuInputHandler(new InputValidator()));

        // Opciones del menú
        menu.addOption(new MenuEstandar("Agregar contacto", () -> agregarContacto(gestor)));
        menu.addOption(new MenuEstandar("Modificar contacto", () -> modificarContacto(gestor)));
        menu.addOption(new MenuEstandar("Eliminar contacto", () -> eliminarContacto(gestor)));
        menu.addOption(new MenuEstandar("Buscar contacto", () -> buscarContacto(gestor)));
        menu.addOption(new MenuEstandar("Mostrar todos los contactos", gestor::mostrarContactos));
        menu.addOption(new MenuEstandar("Salir", Ejercicio_5::salirDelPrograma));

        // Mostrar el menú
        menu.show();
    }

    // Métodos para las opciones del menú
    public static void agregarContacto(GestorContactos gestor) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Ingrese el email: ");
        String email = scanner.nextLine();

        try {
            gestor.agregarContacto(new Contacto(nombre, telefono, email));
            System.out.println("Contacto agregado exitosamente.");
        } catch (ContactoInvalidoException e) {
            System.out.println("Error al agregar el contacto: " + e.getMessage());
        }
    }

    public static void modificarContacto(GestorContactos gestor) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del contacto a modificar: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();
        System.out.print("Ingrese el nuevo teléfono: ");
        String nuevoTelefono = scanner.nextLine();
        System.out.print("Ingrese el nuevo email: ");
        String nuevoEmail = scanner.nextLine();

        try {
            gestor.modificarContacto(nombre, new Contacto(nuevoNombre, nuevoTelefono, nuevoEmail));
            System.out.println("Contacto modificado exitosamente.");
        } catch (ContactoInvalidoException | ContactoNoEncontradoException e) {
            System.out.println("Error al modificar el contacto: " + e.getMessage());
        }
    }

    public static void eliminarContacto(GestorContactos gestor) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del contacto a eliminar: ");
        String nombre = scanner.nextLine();

        try {
            gestor.eliminarContacto(nombre);
            System.out.println("Contacto eliminado exitosamente.");
        } catch (ContactoNoEncontradoException e) {
            System.out.println("Error al eliminar el contacto: " + e.getMessage());
        }
    }

    public static void buscarContacto(GestorContactos gestor) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del contacto a buscar: ");
        String nombre = scanner.nextLine();

        try {
            Contacto contacto = gestor.buscarContacto(nombre);
            System.out.println("Contacto encontrado: " + contacto);
        } catch (ContactoNoEncontradoException e) {
            System.out.println("Error al buscar el contacto: " + e.getMessage());
        }
    }

    public static void salirDelPrograma() {
        System.out.println("Gracias por usar el gestor de contactos.");
        System.exit(0);
    }
}



// Clases ya existentes de Contacto, GestorContactos, y excepciones (sin cambios)
class ContactoInvalidoException extends Exception {
    public ContactoInvalidoException(String mensaje) {
        super(mensaje);
    }
}

class ContactoNoEncontradoException extends Exception {
    public ContactoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}

class Contacto {
    private String nombre;
    private String telefono;
    private String email;

    public Contacto(String nombre, String telefono, String email) throws ContactoInvalidoException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ContactoInvalidoException("El nombre no puede estar vacío");
        }
        if (telefono == null || !telefono.matches("\\d{9}")) {
            throw new ContactoInvalidoException("El teléfono debe tener 9 dígitos");
        }
        if (email == null || !email.contains("@")) {
            throw new ContactoInvalidoException("El email debe contener @");
        }
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Contacto{nombre='" + nombre + "', telefono='" + telefono + "', email='" + email + "'}";
    }
}

class GestorContactos {
    private List<Contacto> contactos;

    public GestorContactos() {
        this.contactos = new ArrayList<>();
    }

    public void agregarContacto(Contacto contacto) throws ContactoInvalidoException {
        if (contacto == null) {
            throw new ContactoInvalidoException("El contacto no puede ser nulo");
        }
        contactos.add(contacto);
    }

    public void modificarContacto(String nombre, Contacto nuevoContacto) throws ContactoNoEncontradoException, ContactoInvalidoException {
        if (nuevoContacto == null) {
            throw new ContactoInvalidoException("El nuevo contacto no puede ser nulo");
        }
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().equals(nombre)) {
                contactos.set(i, nuevoContacto);
                return;
            }
        }
        throw new ContactoNoEncontradoException("No se encontró el contacto: " + nombre);
    }

    public void eliminarContacto(String nombre) throws ContactoNoEncontradoException {
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().equals(nombre)) {
                contactos.remove(i);
                return;
            }
        }
        throw new ContactoNoEncontradoException("No se encontró el contacto: " + nombre);
    }

    public Contacto buscarContacto(String nombre) throws ContactoNoEncontradoException {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(nombre)) {
                return contacto;
            }
        }
        throw new ContactoNoEncontradoException("No se encontró el contacto: " + nombre);
    }

    public void mostrarContactos() {
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }
}
