package Trabajo_3.Ejercicios.SistemaGestionUCSM;

import java.util.ArrayList;
import java.util.List;

public class SistemaGestion {
    private List<Estudiante> listaEstudiantes;
    private List<Profesor> listaProfesores;
    private List<Curso> listaCursos;

    public SistemaGestion() {
        this.listaEstudiantes = new ArrayList<>();
        this.listaProfesores = new ArrayList<>();
        this.listaCursos = new ArrayList<>();
    }

    public void inscribirEstudianteEnCurso(Estudiante estudiante, Curso curso) {
        if (!listaEstudiantes.contains(estudiante)) {
            listaEstudiantes.add(estudiante);
        }
        curso.agregarEstudiante(estudiante);
        estudiante.inscribirEnCurso(curso);
    }

    public void asignarProfesorACurso(Profesor profesor, Curso curso) {
        if (!listaProfesores.contains(profesor)) {
            listaProfesores.add(profesor);
        }
        profesor.asignarCurso(curso);
        curso.setProfesor(profesor);
    }

    public List<Curso> mostrarCursosDisponibles() {
        return listaCursos;
    }


    public void agregarCurso(Curso curso) {
        listaCursos.add(curso);
    }

    public void agregarEstudiante(Estudiante estudiante) {
        listaEstudiantes.add(estudiante);
    }

    public void agregarProfesor(Profesor profesor) {
        listaProfesores.add(profesor);
    }


    public List<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public List<Profesor> getListaProfesores() {
        return listaProfesores;
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public Curso obtenerCursoPorCodigo(String codigoCurso) {
        for (Curso curso : listaCursos) {
            if (curso.getCodigoCurso().equals(codigoCurso)) {
                return curso;
            }
        }
        return null;
    }

    public Profesor obtenerProfesorPorId(String idProfesor) {
        for (Profesor profesor : listaProfesores) {
            if (profesor.getIdProfesor().equals(idProfesor)) {
                return profesor;
            }
        }
        return null;
    }

    public Estudiante obtenerEstudiantePorMatricula(String matricula) {
        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getMatricula().equals(matricula)) {
                return estudiante;
            }
        }
        return null;
    }
}
