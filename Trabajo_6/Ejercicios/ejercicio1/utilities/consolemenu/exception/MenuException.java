package Trabajo_6.Ejercicios.ejercicio1.utilities.consolemenu.exception;

/**
 * Custom exception for menu-related errors.
 */
public class MenuException extends Exception {
    public MenuException(String message) {
        super(message);
    }

    public MenuException(String message, Throwable cause) {
        super(message, cause);
    }
}
