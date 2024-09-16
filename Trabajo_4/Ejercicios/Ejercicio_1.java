package Trabajo_4.Ejercicios;

public class Ejercicio_1{
    public static void main(String[] args) {
        ProcesadorCaracteres procesador = new ProcesadorCaracteres();

        while (true) {
            try {
                procesador.procesar();
            } catch (ExcepcionVocal | ExcepcionNumero | ExcepcionBlanco e) {
                System.out.println(e.getMessage());
            } catch (ExcepcionSalida e) {
                System.out.println(e.getMessage());
                System.out.println("Programa terminado.");
                break;
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
    }
}

// Excepciones personalizadas
class ExcepcionVocal extends Exception {
    public ExcepcionVocal(String mensaje) {
        super(mensaje);
    }
}

class ExcepcionNumero extends Exception {
    public ExcepcionNumero(String mensaje) {
        super(mensaje);
    }
}

class ExcepcionBlanco extends Exception {
    public ExcepcionBlanco(String mensaje) {
        super(mensaje);
    }
}

class ExcepcionSalida extends Exception {
    public ExcepcionSalida(String mensaje) {
        super(mensaje);
    }
}

// Clase LeerEntrada proporcionada en el ejercicio
class LeerEntrada {
    public char getChar() throws java.io.IOException {
        return (char) System.in.read();
    }
}

// Clase principal que procesa los caracteres
class ProcesadorCaracteres {
    private final LeerEntrada lector;

    public ProcesadorCaracteres() {
        this.lector = new LeerEntrada();
    }

    public void procesar() throws Exception {
        System.out.print("Ingrese el texto: ");
        char c = lector.getChar();
        if ("aeiouAEIOU".indexOf(c) != -1) {
            throw new ExcepcionVocal("Se encontró una vocal: " + c);
        } else if (Character.isDigit(c)) {
            throw new ExcepcionNumero("Se encontró un número: " + c);
        } else if (Character.isWhitespace(c)) {
            throw new ExcepcionBlanco("Se encontró un espacio en blanco");
        } else if (c == 'x' || c == 'X') {
            throw new ExcepcionSalida("Se encontró el carácter de salida");
        }
    }
}