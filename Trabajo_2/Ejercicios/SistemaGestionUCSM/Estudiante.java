package Trabajo_2.Ejercicios.SistemaGestionUCSM;

import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Persona {
    private String matricula;
    private List<Curso> cursosInscritos;
    public static final int MAX_CURSOS_INSCRITOS = 5;

    public Estudiante(String nombre, String apellido, String matricula) {
        super(nombre, apellido);
        this.matricula = matricula;
        this.cursosInscritos = new ArrayList<>();
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void inscribirEnCurso(Curso curso) {
        if (cursosInscritos.size() < MAX_CURSOS_INSCRITOS) {
            cursosInscritos.add(curso);
        } else {
            System.out.println("No se puede inscribir en más cursos. Máximo permitido: " + MAX_CURSOS_INSCRITOS);
        }
    }

    public List<Curso> obtenerCursosInscritos() {
        return cursosInscritos;
    }

    @Override
    public String obtenerInformacion() {
        return "Estudiante: " + nombre +
                " " + apellido +
                " (Matrícula: " + matricula + ")" +
                " Cursos inscritos: " + cursosInscritos.toString();
    }
}
