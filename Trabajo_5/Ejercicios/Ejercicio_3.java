package Trabajo_5.Ejercicios;

class Par <F, S>{
    private F first;
    private S second;

    public Par(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public boolean esIgual(){
        if (first == null){
            return second == null;
        }
        return first.equals(second);
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Primero: " + first +
                "\nSegundo: " + second ;
    }
}

public class Ejercicio_3 {
    public static void main(String[] args) {
        Par<Integer, String> par = new Par<>(1, "Hola");
        imprimirPar(par);
        Par<String, Integer> par1= new Par<>("numero", 1);
        imprimirPar(par1);
    }

    public static <A,B> void imprimirPar(Par<A, B> par){
        System.out.println(par);

    }
}
