package Trabajo_3.Actividades;

public class Actividad_1 {
    public static void main(String[] args) {
        Vehiculo coche = new Coche();
        Vehiculo bicicleta = new Bicicleta();

        acelerarVehiculo(coche);
        acelerarVehiculo(bicicleta);
    }

    public static void acelerarVehiculo(Vehiculo vehiculo) {
        vehiculo.acelerar();
    }
}


abstract class Vehiculo {
    public abstract void acelerar();
}

class Coche extends Vehiculo{

    @Override
    public void acelerar() {
        System.out.println("Acelerando con el motor");
    }
}

class Bicicleta extends Vehiculo{

    @Override
    public void acelerar(){
        System.out.println("Acelerando con el pedaleando");

    }
}