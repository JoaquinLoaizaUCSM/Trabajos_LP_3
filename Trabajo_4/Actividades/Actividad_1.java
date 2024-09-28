/*
package Trabajo_4.Actividades;

class CuentaBancaria {
    private final String numeroCuenta;
    private final String titular;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo es negativo");
        }
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo");
        }
        saldo += monto;
    }

    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo");
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar el retiro");
        }
        saldo -= monto;
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

}

class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}


public class Actividad_1 {
    public static void main(String[] args) {
        try {
            CuentaBancaria cuenta1 = new CuentaBancaria("123456", "Juan Pérez", 1000);
            System.out.println("Cuenta creada exitosamente: " + cuenta1.getNumeroCuenta());
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear cuenta: " + e.getMessage());
        }

        CuentaBancaria cuenta3 = new CuentaBancaria("345678", "Carlos López", 2000);

        try {
            cuenta3.retirar(1000);
            System.out.println("Retiro exitoso. Nuevo saldo: " + cuenta3.getSaldo());
        } catch (IllegalArgumentException | SaldoInsuficienteException e) {
            System.out.println("Error al retirar: " + e.getMessage());
        }
    }
}
*/
