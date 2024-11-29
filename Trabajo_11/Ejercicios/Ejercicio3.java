package Trabajo_11.Ejercicios;

import java.util.Stack;

interface Comando {
    void ejecutar();

    void deshacer();

    void rehacer();
}

class Dispositivo {
    public void encender() {
        System.out.println("El dispositivo está ENCENDIDO.");
    }

    public void apagar() {
        System.out.println("El dispositivo está APAGADO.");
    }
}

class Luz extends Dispositivo {
    public void alternar() {
        System.out.println("La luz ha cambiado de estado.");
    }
}

class Ventilador extends Dispositivo {
    private boolean modoAutomatico = false;

    public void alternarModoAutomatico() {
        modoAutomatico = !modoAutomatico;
        System.out.println("El ventilador ahora está en modo " + (modoAutomatico ? "automático." : "manual."));
    }
}

class GestorComandos {
    private final Stack<Comando> pilaHistorial = new Stack<>();
    private final Stack<Comando> pilaRehacer = new Stack<>();

    public void ejecutarComando(Comando comando) {
        comando.ejecutar();
        pilaHistorial.push(comando);
        pilaRehacer.clear();  // Limpiar pila de rehacer después de ejecutar un nuevo comando
    }

    public void deshacer() {
        if (!pilaHistorial.isEmpty()) {
            Comando comando = pilaHistorial.pop();
            comando.deshacer();
            pilaRehacer.push(comando);  // Almacenar en pila de rehacer
        }
    }

    public void rehacer() {
        if (!pilaRehacer.isEmpty()) {
            Comando comando = pilaRehacer.pop();
            comando.rehacer();
            pilaHistorial.push(comando);  // Almacenar de nuevo en pila de historial
        }
    }
}

class ComandoEncenderLuz implements Comando {
    private final Luz luz;

    public ComandoEncenderLuz(Luz luz) {
        this.luz = luz;
    }

    @Override
    public void ejecutar() {
        luz.encender();
    }

    @Override
    public void deshacer() {
        luz.apagar();
    }

    @Override
    public void rehacer() {
        luz.encender();
    }
}

public class Ejercicio3 {
    public static void main(String[] args) {
        Luz luz = new Luz();
        GestorComandos gestor = new GestorComandos();

        Comando comandoEncenderLuz = new ComandoEncenderLuz(luz);
        gestor.ejecutarComando(comandoEncenderLuz);

        gestor.deshacer();  // Apagar la luz
        gestor.rehacer();   // Encender la luz nuevamente

        Ventilador ventilador = new Ventilador();
        ventilador.alternarModoAutomatico();
        ventilador.alternarModoAutomatico();
    }
}