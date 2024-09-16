package Trabajo_2.Ejercicios.Datos;


import Trabajo_2.Ejercicios.SistemaGestionUCSM.*;

import java.util.List;
import java.util.ArrayList;

public class DataContainer {
    private List<Estudiante> estudiantes;
    private List<Profesor> profesores;
    private List<Curso> cursos;

    public DataContainer() {
        this.estudiantes = new ArrayList<>();
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
        cargarDatos();
    }

    private void cargarDatos() {
        // Crear algunos estudiantes de ejemplo
        estudiantes.add(new Estudiante("Juan", "Pérez", "E001"));
        estudiantes.add(new Estudiante("Ana", "Gómez", "E002"));
        estudiantes.add(new Estudiante("Luis", "Martínez", "E003"));

        // Crear algunos profesores de ejemplo
        profesores.add(new Profesor("Carlos", "López", "P001"));
        profesores.add(new Profesor("María", "Fernández", "P002"));
        profesores.add(new Profesor("Miguel", "Rodríguez", "P003"));

        // Crear algunos cursos de ejemplo
        cursos.add(new Curso("Matemáticas", "Ciencias", "C101"));
        cursos.add(new Curso("Programación", "Tecnología", "C102"));
        cursos.add(new Curso("Historia", "Humanidades", "C103"));
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void inicializarSistemaGestion(SistemaGestion sistemaGestion) {
        for (Estudiante estudiante : estudiantes) {
            sistemaGestion.agregarEstudiante(estudiante);
        }

        for (Profesor profesor : profesores) {
            sistemaGestion.agregarProfesor(profesor);
        }

        for (Curso curso : cursos) {
            sistemaGestion.agregarCurso(curso);
        }
    }
}
