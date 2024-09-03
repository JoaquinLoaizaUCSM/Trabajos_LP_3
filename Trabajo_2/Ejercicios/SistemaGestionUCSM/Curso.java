package Trabajo_2.Ejercicios.SistemaGestionUCSM;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nombre;
    private String categoria;
    private String codigoCurso;
    private Profesor profesor;
    private List<Estudiante> estudiantesInscritos;

    public Curso(String nombre, String categoria, String codigoCurso) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.codigoCurso = codigoCurso;
        this.estudiantesInscritos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Estudiante> getEstudiantesInscritos() {
        return estudiantesInscritos;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantesInscritos.add(estudiante);
    }

    public void removerEstudiante(Estudiante estudiante) {
        estudiantesInscritos.remove(estudiante);
    }

    public int obtenerCantidadEstudiantes() {
        return estudiantesInscritos.size();
    }

    public String toString() {
        return "Curso: " + nombre + " (" + categoria + ") - Código: " + codigoCurso;
    }
}
