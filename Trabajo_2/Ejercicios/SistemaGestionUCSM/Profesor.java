package Trabajo_2.Ejercicios.SistemaGestionUCSM;

import java.util.ArrayList;
import java.util.List;

public class Profesor extends Persona {
    private String idProfesor;
    private List<Curso> cursosAsignados;
    public static final int MAX_CURSOS_ASIGNADOS = 3;

    public Profesor(String nombre, String apellido, String idProfesor) {
        super(nombre, apellido);
        this.idProfesor = idProfesor;
        this.cursosAsignados = new ArrayList<>();
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public void asignarCurso(Curso curso) {
        if (cursosAsignados.size() < MAX_CURSOS_ASIGNADOS) {
            cursosAsignados.add(curso);
        } else {
            System.out.println("No se puede asignar más cursos. Máximo permitido: " + MAX_CURSOS_ASIGNADOS);
        }
    }

    public List<Curso> obtenerCursosAsignados() {
        return cursosAsignados;
    }

    @Override
    public String obtenerInformacion() {
        return "Profesor: " + nombre +
                " " + apellido +
                " (ID: " + idProfesor + ")" +
                " Cursos asignados: " + cursosAsignados.toString();
    }
}
