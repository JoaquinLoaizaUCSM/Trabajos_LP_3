package Trabajo_5.Ejercicios;

import java.util.ArrayList;

class Contenedor<F, S>{
    ArrayList<Par<F, S>> pares = new ArrayList<>();

    public void agregarPar(F first, S second){
        pares.add(new Par<>(first, second));
    }

    public Par<F, S> obtenerPares(int index){
        return pares.get(index);
    }

    public ArrayList<Par<F, S>> obtenerTodosLosPares(){
        return pares;
    }

    public void mostrarPares(){
        for (Par<F, S> par : pares){
            System.out.println(par);
        }
    }
}

public class Ejercicio_4 {
    public static void main(String[] args) {
        Contenedor<Integer, String> contenedor = new Contenedor<>();
        contenedor.agregarPar(1, "Hola");
        contenedor.agregarPar(2, "Mundo");
        contenedor.agregarPar(3, "Java");

        contenedor.mostrarPares();
    }
}
