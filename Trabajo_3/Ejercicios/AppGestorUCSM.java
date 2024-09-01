package Trabajo_3.Ejercicios;


import Trabajo_3.Ejercicios.SistemaGestionUCSM.*;

public class AppGestorUCSM {
    public static void main(String[] args) {
        // Crear el sistema de gestión
        SistemaGestion sistemaGestion = new SistemaGestion();

        // Crear estudiantes
        Estudiante estudiante1 = new Estudiante("Juan", "Pérez", "E001");
        Estudiante estudiante2 = new Estudiante("Ana", "Gómez", "E002");

        // Crear profesores
        Profesor profesor1 = new Profesor("Carlos", "López", "P001");

        // Crear cursos
        Curso curso1 = new Curso("Matemáticas", "Ciencias", "C101");
        Curso curso2 = new Curso("Programación", "Tecnología", "C102");

        // Agregar cursos al sistema
        sistemaGestion.agregarCurso(curso1);
        sistemaGestion.agregarCurso(curso2);

        // Asignar profesor a un curso
        sistemaGestion.asignarProfesorACurso(profesor1, curso1);

        // Inscribir estudiantes en cursos
        sistemaGestion.inscribirEstudianteEnCurso(estudiante1, curso1);
        sistemaGestion.inscribirEstudianteEnCurso(estudiante2, curso1);
        sistemaGestion.inscribirEstudianteEnCurso(estudiante1, curso2);

        // Mostrar información
        System.out.println(profesor1.obtenerInformacion());
        System.out.println(estudiante1.obtenerInformacion());
        System.out.println("Estudiantes inscritos en " + curso1.getNombre() + ": " + curso1.obtenerCantidadEstudiantes());
        System.out.println("Estudiantes inscritos en " + curso2.getNombre() + ": " + curso2.obtenerCantidadEstudiantes());
    }
}
