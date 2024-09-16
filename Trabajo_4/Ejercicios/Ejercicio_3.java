package Trabajo_4.Ejercicios;

class Numero {
    private double valor;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) throws IllegalArgumentException {
        if (valor < 0) {
            throw new IllegalArgumentException("El valor no puede ser negativo");
        }
        this.valor = valor;
    }
}

public class Ejercicio_3 {
    public static void main(String[] args) {
        Numero num = new Numero();

        try {
            num.setValor(5);
            System.out.println("Valor establecido: " + num.getValor());

            num.setValor(-3);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

