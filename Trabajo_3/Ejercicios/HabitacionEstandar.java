package Trabajo_3.Ejercicios;

public class HabitacionEstandar extends Habitacion implements ServicioLimpieza {

    public HabitacionEstandar(int numero, String tipo, double precioBase, GestorHabitacion gestorDisponibilidad) {
        super(numero, tipo, precioBase, gestorDisponibilidad);
    }

    public void aplicarDescuento() {
        System.out.println("Aplicando descuento a habitación estándar");
    }

    @Override
    public void solicitarLimpieza() {
        System.out.println("Solicitando limpieza para habitación estándar");
    }
}

class HabitacionSuite extends Habitacion implements ServicioLimpieza, ServicioComida, ServicioLavanderia {

    public HabitacionSuite(int numero, String tipo, double precioBase, GestorHabitacion gestorDisponibilidad) {
        super(numero, tipo, precioBase, gestorDisponibilidad);
    }

    public void aplicarServicioEspecial() {
        System.out.println("Aplicando servicio especial para habitación suite");
    }

    @Override
    public void solicitarLimpieza() {
        System.out.println("Solicitando limpieza para habitación suite");
    }

    @Override
    public void pedirComida(String plato) {
        System.out.println("Pidiendo comida para habitación suite: " + plato);
    }

    @Override
    public void solicitarLavanderia() {
        System.out.println("Solicitando lavandería para habitación suite");
    }
}
