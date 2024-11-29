package Trabajo_11.Actividades;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

interface Observador {
    void update(String mensaje);
}


interface EstrategiaOperacion {
    double calcular(double operando1, double operando2);
}


interface Comando {
    void ejecutar();

    void deshacer();
}

class Persona implements Observador {  // Fixed interface implementation
    private final String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void update(String mensaje) {
        System.out.println(nombre + " recibió: " + mensaje);
    }
}

class SistemaNotificacion {
    private final List<Observador> observadores = new ArrayList<>();

    public void suscribir(Observador observador) {
        observadores.add(observador);
    }

    public void desuscribir(Observador observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores(String mensaje) {
        for (Observador observador : observadores) {
            observador.update(mensaje);
        }
    }
}

class Suma implements EstrategiaOperacion {
    @Override
    public double calcular(double operando1, double operando2) {
        return operando1 + operando2;
    }
}

class Resta implements EstrategiaOperacion {
    @Override
    public double calcular(double operando1, double operando2) {
        return operando1 - operando2;
    }
}

class Multiplicacion implements EstrategiaOperacion {
    @Override
    public double calcular(double operando1, double operando2) {
        return operando1 * operando2;
    }
}

class Division implements EstrategiaOperacion {
    @Override
    public double calcular(double operando1, double operando2) {
        if (operando2 == 0) {
            throw new ArithmeticException("La división por cero no está permitida.");
        }
        return operando1 / operando2;
    }
}

class Calculadora {
    private EstrategiaOperacion estrategia;

    public void setEstrategia(EstrategiaOperacion estrategia) {
        this.estrategia = estrategia;
    }

    public double calcular(double operando1, double operando2) {
        return estrategia.calcular(operando1, operando2);
    }
}

class ComandoCalculadora implements Comando {
    private final Calculadora calculadora;
    private final double operando1;
    private final double operando2;
    private double resultado;
    private final EstrategiaOperacion estrategia;
    private final SistemaNotificacion sistemaNotificacion;

    public ComandoCalculadora(Calculadora calculadora, double operando1, double operando2, EstrategiaOperacion estrategia,
                              SistemaNotificacion sistemaNotificacion) {
        this.calculadora = calculadora;
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.estrategia = estrategia;
        this.sistemaNotificacion = sistemaNotificacion;
    }

    @Override
    public void ejecutar() {
        calculadora.setEstrategia(estrategia);
        resultado = calculadora.calcular(operando1, operando2);
        sistemaNotificacion.notificarObservadores("Resultado de la operación: " + resultado);
    }

    @Override
    public void deshacer() {
        sistemaNotificacion.notificarObservadores("Deshaciendo última operación: Resultado fue " + resultado);
        resultado = 0;
    }
}

// Invocador
class GestorComandos {
    private final Stack<Comando> historialComandos = new Stack<>();

    public void ejecutarComando(Comando comando) {
        comando.ejecutar();
        historialComandos.push(comando);
    }

    public void deshacerUltimoComando() {
        if (!historialComandos.isEmpty()) {
            historialComandos.pop().deshacer();
        } else {
            System.out.println("No hay comandos para deshacer.");
        }
    }
}


public class CalculadoraPrincipal {
    public static void main(String[] args) {
        // Configuración
        SistemaNotificacion sistemaNotificacion = new SistemaNotificacion();
        Persona persona1 = new Persona("Alice");
        Persona persona2 = new Persona("Bob");
        sistemaNotificacion.suscribir(persona1);
        sistemaNotificacion.suscribir(persona2);
        Calculadora calculadora = new Calculadora();
        GestorComandos gestorComandos = new GestorComandos();

        // Realizar cálculo
        Comando sumaComando = new ComandoCalculadora(calculadora, 10, 5, new Suma(), sistemaNotificacion);
        gestorComandos.ejecutarComando(sumaComando);

        Comando restaComando = new ComandoCalculadora(calculadora, 10, 5, new Resta(), sistemaNotificacion);
        gestorComandos.ejecutarComando(restaComando);

        Comando multiplicacionComando = new ComandoCalculadora(calculadora, 10, 5, new Multiplicacion(), sistemaNotificacion);
        gestorComandos.ejecutarComando(multiplicacionComando);

        Comando divisionComando = new ComandoCalculadora(calculadora, 10, 2, new Division(), sistemaNotificacion);
        gestorComandos.ejecutarComando(divisionComando);

        // Deshacer último comando
        gestorComandos.deshacerUltimoComando();
    }
}