/*
package Trabajo_5.Actividades;

public class Actividad_2 {
    public class Pila<E> {

        private int tamanio; // número de elementos en la pila
        private int superior; // ubicación del elemento superior
        private E[] elementos; // arreglo que almacena los elementos de la pila
        // el constructor sin argumentos crea una pila del tamaño predeterminado

        public Pila() {
            this(10); // tamaño predeterminado de la pila
        }
        // fin del constructor de Pila sin argumentos

        // constructor que crea una pila del número especificado de elementos
        public Pila(int s) {
            tamanio = s > 0 ? s : 10; // establece el tamaño de la Pila
            superior = -1; // al principio, la MarcoTeorico.Pila está vacía
            elementos = (E[]) new Object[tamanio]; // crea el arreglo
        } // fin del constructor de Pila sin argumentos

        // mete un elemento a la pila; si tiene éxito, devuelve verdadero;
        // en caso contrario, lanza excepción ExcepcionPilaLlena
        public void push(E valorAMeter) throws ExcepcionPilaLlena {
            if (superior == tamanio - 1) // si la pila está llena
                throw new ExcepcionPilaLlena(String.format("La Pila esta llena, no se puede meter %s", valorAMeter));

            elementos[++superior] = valorAMeter; // mete valorAMeter enPila
        }

        // devuelve el último elemento o lanza ExcepcionPilaVacia
        public E pop() throws ExcepcionPilaVacia {
            if (superior == -1) // si la pila está vacía
                throw new ExcepcionPilaVacia("Pila vacia, no se puede sacar");
            return elementos[superior--]; // elimina y devuelve el ultimo
        } // fin del método pop

    } // fin de la clase MarcoTeorico.Pila< E >
}
*/
