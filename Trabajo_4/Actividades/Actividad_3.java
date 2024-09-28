package Trabajo_4.Actividades;


class LimiteCreditoExcedidoException extends Exception {
    public LimiteCreditoExcedidoException(String mensaje) {
        super(mensaje);
    }
}


class CuentaCredito extends CuentaBancaria {
    private double limiteCredito;

    public CuentaCredito(String numeroCuenta, String titular, double saldoInicial, double limiteCredito) {
        super(numeroCuenta, titular, saldoInicial);
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void retirar(double monto) throws IllegalArgumentException, LimiteCreditoExcedidoException {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo");
        }
        if (getSaldo() + limiteCredito < monto) {
            throw new LimiteCreditoExcedidoException("El retiro excede el límite de crédito disponible");
        }
        super.setSaldo(getSaldo() - monto);
    }

    @Override
    public void transferir(CuentaBancaria destino, double monto)
            throws SaldoInsuficienteException, CuentaNoEncontradaException, LimiteCreditoExcedidoException {
        if (destino == null) {
            throw new CuentaNoEncontradaException("La cuenta destino no existe");
        }
        this.retirar(monto);
        destino.depositar(monto);
    }


}

public class Actividad_3 {
    public static void main(String[] args) {
        CuentaCredito cuentaCredito = new CuentaCredito("444444", "David", 1000, 500);
        CuentaBancaria cuentaNormal = new CuentaBancaria("555555", "Eva", 500);


        try {
            cuentaCredito.retirar(1200);
            System.out.println("Retiro exitoso. \nNuevo saldo: " + cuentaCredito.getSaldo());
        } catch (LimiteCreditoExcedidoException e) {
            System.out.println("Error en el retiro: " + e.getMessage());
        }


        try {
            cuentaCredito.retirar(1501);
        } catch (LimiteCreditoExcedidoException e) {
            System.out.println("Error en el retiro: " + e.getMessage());
        }


        try {
            cuentaCredito.transferir(cuentaNormal, 200);
            System.out.println("Transferencia exitosa");
            System.out.println("Saldo cuenta crédito: " + cuentaCredito.getSaldo());
            System.out.println("Saldo cuenta normal: " + cuentaNormal.getSaldo());
        } catch (SaldoInsuficienteException | CuentaNoEncontradaException | LimiteCreditoExcedidoException e) {
            System.out.println("Error en la transferencia: " + e.getMessage());
        }


        try {
            cuentaCredito.transferir(cuentaNormal, 1000);
        } catch (SaldoInsuficienteException | CuentaNoEncontradaException | LimiteCreditoExcedidoException e) {
            System.out.println("Error en la transferencia: " + e.getMessage());
        }
    }
}
