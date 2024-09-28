package Trabajo_4.Actividades;

import java.util.ArrayList;
import java.util.List;

class CuentaNoEncontradaException extends Exception {
    public CuentaNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}

class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}

class SaldoNoCeroException extends Exception {
    public SaldoNoCeroException(String mensaje) {
        super(mensaje);
    }
}

class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;
    private boolean avilitado = true;
    private List<String> historial = new ArrayList<>();

    public List<String> getHistorial() {
        return historial;
    }

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo es negativo");
        }
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }



    public void registrarTrasaccion(String trasaccion){
        historial.add(trasaccion);

    }

    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo");
        }
        saldo += monto;
        registrarTrasaccion("Deposito: s/" + monto);
    }

    public void retirar(double monto) throws SaldoInsuficienteException, LimiteCreditoExcedidoException {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo");
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar el retiro");
        }
        saldo -= monto;
        registrarTrasaccion("Retirar: s/" + monto);
    }

    public void transferir(CuentaBancaria destino, double monto)
            throws SaldoInsuficienteException, CuentaNoEncontradaException, LimiteCreditoExcedidoException {
        if (destino == null) {
            throw new CuentaNoEncontradaException("La cuenta no existe");
        }
        if (monto > this.saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
        this.retirar(monto);
        destino.depositar(monto);
        registrarTrasaccion("Traferencia a "+destino.titular+ ":s/" + monto);
    }

    public void cerrarCuenta() throws SaldoNoCeroException {
        if (this.saldo != 0) {
            throw new SaldoNoCeroException("No se puede cerrar la cuenta. El saldo no es cero");
        }
        avilitado = false;
        System.out.println("Cuenta cerrada exitosamente");
    }

    // Getters y setters
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}

public class Actividad_2 {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria("111111", "Alice", 1000);
        CuentaBancaria cuenta2 = new CuentaBancaria("222222", "Bob", 500);

        // Prueba de transferencia válida
        try {
            cuenta1.transferir(cuenta2, 300);
            System.out.println("Transferencia exitosa");
            System.out.println("Saldo cuenta1: " + cuenta1.getSaldo());
            System.out.println("Saldo cuenta2: " + cuenta2.getSaldo());
        } catch (SaldoInsuficienteException | CuentaNoEncontradaException e) {
            System.out.println("Error en la transferencia: " + e.getMessage());
        } catch (LimiteCreditoExcedidoException e) {
            System.out.println("El limite de credito no es suficiente " + e.getMessage());
        }

        // Prueba de transferencia con saldo insuficiente
        try {
            cuenta1.transferir(cuenta2, 2000);
        } catch (SaldoInsuficienteException | CuentaNoEncontradaException | LimiteCreditoExcedidoException e) {
            System.out.println("Error en la transferencia: " + e.getMessage());
        }

        // Prueba de transferencia a cuenta inexistente
        try {
            cuenta1.transferir(null, 100);
        } catch (SaldoInsuficienteException | CuentaNoEncontradaException | LimiteCreditoExcedidoException e) {
            System.out.println("Error en la transferencia: " + e.getMessage());
        }

        // Prueba de cierre de cuenta con saldo
        try {
            cuenta1.cerrarCuenta();
        } catch (SaldoNoCeroException e) {
            System.out.println("Error al cerrar la cuenta: " + e.getMessage());
        }

        // Prueba de cierre de cuenta con saldo cero
        CuentaBancaria cuenta3 = new CuentaBancaria("333333", "Charlie", 0);
        try {
            cuenta3.cerrarCuenta();
        } catch (SaldoNoCeroException e) {
            System.out.println("Error al cerrar la cuenta: " + e.getMessage());
        }
    }
}
