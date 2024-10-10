package Trabajo_5.Actividades;

public class Actividad_3 {
    public static void main(String[] args) {
        Persona grossman = new Persona(18);
        Persona luis = new Persona(18);

        System.out.println(IgualGenerico.esIgualA(luis,grossman));
        System.out.println(IgualGenerico.esIgualA("luis","luis"));
        System.out.println(IgualGenerico.esIgualA(luis,null));
        System.out.println(IgualGenerico.esIgualA(null,null));
    }
}

class Persona{
    int id;

    public Persona(int id) {
        this.id = id;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona persona)) return false;

        return id == persona.id;
    }
}


class IgualGenerico{

    public static <T> boolean esIgualA(T a, T b){

        if (a == null){
            return b == null;
        }
        return a.equals(b);
    }
}