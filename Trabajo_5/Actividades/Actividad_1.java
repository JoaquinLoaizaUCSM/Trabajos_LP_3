package Trabajo_5.Actividades;

public class Actividad_1 {
    // método genérico imprimirArreglo
    public static < E > void imprimirArreglo( E[] arregloEntrada )
    {
    // muestra los elementos del arreglo
        for ( E elemento : arregloEntrada )
            System.out.printf( "%s ", elemento );
        System.out.println();
    } // fin del método imprimirArreglo

    public static void main(String[] args) {
    // crea arreglos de objetos Integer, Double y Character
        Integer[] arregloInteger = { 1, 2, 3, 4, 5, 6 };
        Double[] arregloDouble = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };Character[] arregloCharacter = { 'H', 'O', 'L', 'A' };
        System.out.println( "El arreglo arregloInteger contiene:" );
        imprimirArreglo( arregloInteger ); // pasa un arreglo Integer
        System.out.println( "\nEl arreglo arregloDouble contiene:" );
        imprimirArreglo( arregloDouble ); // pasa un arreglo Double
        System.out.println( "\nEl arreglo arregloCharacter contiene:" );imprimirArreglo( arregloCharacter );
        // pasa un arreglo Character
        // } // fin de main
    } // fin de la clase PruebaMetodoGenerico
}

