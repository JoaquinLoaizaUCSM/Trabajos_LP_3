package Trabajo_11.Actividades;

interface EstrategiaPromocion {
    double aplicarDescuento(double precio);
}

class SinPromocion implements EstrategiaPromocion {
    @Override
    public double aplicarDescuento(double precio) {
        return precio;
    }
}

class DescuentoDiezPorciento implements EstrategiaPromocion {
    @Override
    public double aplicarDescuento(double precio) {
        return precio * 0.3;
    }
}

class PromocionEspecial implements EstrategiaPromocion {
    @Override
    public double aplicarDescuento(double precio) {
        return precio * 0.5;
    }
}

class CalculadoraPrecios {
    private EstrategiaPromocion estrategiaPromocion;

    public void establecerEstrategia(EstrategiaPromocion estrategiaPromocion) {
        this.estrategiaPromocion = estrategiaPromocion;
    }

    public double calcularPrecio(double precio) {
        return estrategiaPromocion.aplicarDescuento(precio);
    }
}

public class Actividad_2 {
    public static void main(String[] args) {
        CalculadoraPrecios calculadoraPrecios = new CalculadoraPrecios();

        calculadoraPrecios.establecerEstrategia(new SinPromocion());
        System.out.println("Precio sin descuento: " + calculadoraPrecios.calcularPrecio(100.0));

        calculadoraPrecios.establecerEstrategia(new DescuentoDiezPorciento());
        System.out.println("Precio con 10% de descuento: " + calculadoraPrecios.calcularPrecio(100.0));

        calculadoraPrecios.establecerEstrategia(new PromocionEspecial());
        System.out.println("Precio con promoción especial: " + calculadoraPrecios.calcularPrecio(100.0));
    }
}