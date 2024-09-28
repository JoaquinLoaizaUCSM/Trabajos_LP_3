package Trabajo_5.Actividades;

class Pila<E> {

    private int tamanio; // número de elementos en la pila
    private int superior; // ubicación del elemento superior
    private E[] elementos; // arreglo que almacena los elementos de la pila

    public Pila() {
        this(10);
    }

    public Pila(int s) {
        tamanio = s > 0 ? s : 10; // establece el tamaño de la Pila
        superior = -1; // al principio, la MarcoTeorico.Pila está vacía
        elementos = (E[]) new Object[tamanio]; // crea el arreglo
    }

    public void push(E valorAMeter) throws ExcepcionPilaLlena {
        if (superior == tamanio - 1)
            throw new ExcepcionPilaLlena(String.format("La Pila esta llena, no se puede meter %s", valorAMeter));
        elementos[++superior] = valorAMeter;
    }


    public E pop() throws ExcepcionPilaVacia {
        if (superior == -1) // si la pila está vacía
            throw new ExcepcionPilaVacia("Pila vacia, no se puede sacar");
        return elementos[superior--]; // elimina y devuelve el ultimo
    }


    public boolean esIgual(Pila<E> pila) {
        if (superior != pila.superior) {
            return false;
        }
        for (int i = 0; i < superior; i++) {
            if (!elementos[i].equals(pila.elementos[i])) {
                return false;
            }
        }
        return true;
    }
}


public class Actividad_4 {
    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>(5);
        Pila<Integer> pila1 = new Pila<>(5);
        Pila<Integer> pila2 = new Pila<>(2);
        Pila<Integer> pila3 = new Pila<>(2);
        try {
            pila.push(1);
            pila.push(2);
            pila.push(3);
            pila.push(4);
            pila.push(5);

            pila1.push(1);
            pila1.push(2);
            pila1.push(3);
            pila1.push(4);
            pila1.push(5);
            System.out.println(pila.esIgual(pila1));


            pila2.push(11);
            pila2.push(2);

            pila3.push(10);
            pila3.push(2);
            System.out.println(pila2.esIgual(pila3));

        } catch (ExcepcionPilaLlena excepcionPilaLlena) {
            excepcionPilaLlena.printStackTrace();
        }
    }
}
