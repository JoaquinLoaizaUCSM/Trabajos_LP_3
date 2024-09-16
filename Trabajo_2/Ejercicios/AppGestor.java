package Trabajo_2.Ejercicios;
import Trabajo_2.Ejercicios.SistemaGestionUCSM.*;
import Trabajo_2.Ejercicios.Datos.DataContainer;
import utilities.consolemenu.*;
import utilities.userinput.*;



public class AppGestor {
    public static void main(String[] args) {
        // Crear el sistema de gestión
        SistemaGestion sistemaGestion = new SistemaGestion();

        // Crear un contenedor de datos para probar
        DataContainer dataContainer = new DataContainer();
        dataContainer.inicializarSistemaGestion(sistemaGestion);
        // Crear el manejador de entradas
        MenuInputHandler inputHandler = new MenuInputHandler(new InputValidator());

        // Crear el menú principal
        ConsoleMenu mainMenu = new ConsoleMenu("Menú Principal", inputHandler);

        // Submenú para gestionar estudiantes
        ConsoleMenu estudianteMenu = new ConsoleMenu("Gestión de Estudiantes", inputHandler);
        estudianteMenu.addOption(new MenuOption() {
            @Override
            public String getText() {
                return "Agregar Estudiante";
            }

            @Override
            public Command getCommand() {
                return new MenuCommand(() -> {
                    String nombre = InputHandler.getString("Ingrese el nombre del estudiante: ");
                    String apellido = InputHandler.getString("Ingrese el apellido del estudiante: ");
                    String matricula = InputHandler.getString("Ingrese la matrícula del estudiante: ");

                    Estudiante estudiante = new Estudiante(nombre, apellido, matricula);
                    sistemaGestion.agregarEstudiante(estudiante);
                    System.out.println("Estudiante agregado exitosamente.");
                });
            }

            @Override
            public void execute() {
                getCommand().execute();
            }
        });

        estudianteMenu.addOption(new MenuOption() {
            @Override
            public String getText() {
                return "Listar Estudiantes";
            }

            @Override
            public Command getCommand() {
                return new MenuCommand(() -> {
                    System.out.println("Lista de Estudiantes:");
                    for (Estudiante estudiante : sistemaGestion.getListaEstudiantes()) {
                        System.out.println(estudiante.obtenerInformacion());
                    }
                });
            }

            @Override
            public void execute() {
                getCommand().execute();
            }
        });

        estudianteMenu.addOption(new MenuOption() {
            @Override
            public String getText() {
                return "Volver al Menú Principal";
            }

            @Override
            public Command getCommand() {
                return new MenuCommand(estudianteMenu::exitMenu);
            }

            @Override
            public void execute() {
                getCommand().execute();
            }
        });

        // Submenú para gestionar profesores
        ConsoleMenu profesorMenu = new ConsoleMenu("Gestión de Profesores", inputHandler);
        profesorMenu.addOption(new MenuOption() {
            @Override
            public String getText() {
                return "Agregar Profesor";
            }

            @Override
            public Command getCommand() {
                return new MenuCommand(() -> {
                    String nombre = InputHandler.getString("Ingrese el nombre del profesor: ");
                    String apellido = InputHandler.getString("Ingrese el apellido del profesor: ");
                    String idProfesor = InputHandler.getString("Ingrese el ID del profesor: ");

                    Profesor profesor = new Profesor(nombre, apellido, idProfesor);
                    if (sistemaGestion.obtenerProfesorPorId(idProfesor) != null) {
                        System.out.println("El ID del profesor ya existe.");
                        return;
                    }
                    sistemaGestion.agregarProfesor(profesor);
                    System.out.println("Profesor agregado exitosamente.");
                });
            }

            @Override
            public void execute() {
                getCommand().execute();
            }
        });

        profesorMenu.addOption(new MenuOption() {
            @Override
            public String getText() {
                return "Listar Profesores";
            }

            @Override
            public Command getCommand() {
                return new MenuCommand(() -> {
                    System.out.println("Lista de Profesores:");
                    for (Profesor profesor : sistemaGestion.getListaProfesores()) {
                        System.out.println(profesor.obtenerInformacion());
                    }
                });
            }

            @Override
            public void execute() {
                getCommand().execute();
            }
        });

        profesorMenu.addOption(new MenuOption() {
            @Override
            public String getText() {
                return "Volver al Menú Principal";
            }

            @Override
            public Command getCommand() {
                return new MenuCommand(profesorMenu::exitMenu);
            }

            @Override
            public void execute() {
                getCommand().execute();
            }
        });

        // Submenú para gestionar cursos
        ConsoleMenu cursoMenu = new ConsoleMenu("Gestión de Cursos", inputHandler);
        cursoMenu.addOption(new MenuOption() {
            @Override
            public String getText() {
                return "Agregar Curso";
            }

            @Override
            public Command getCommand() {
                return new MenuCommand(() -> {
                    String nombre = InputHandler.getString("Ingrese el nombre del curso: ");
                    String categoria = InputHandler.getString("Ingrese la categoría del curso: ");
                    String codigoCurso = InputHandler.getString("Ingrese el código del curso: ");

                    if (sistemaGestion.obtenerCursoPorCodigo(codigoCurso) != null) {
                        System.out.println("El código del curso ya existe.");
                        return;
                    }

                    Curso curso = new Curso(nombre, categoria, codigoCurso);
                    sistemaGestion.agregarCurso(curso);
                    System.out.println("Curso agregado exitosamente.");
                });
            }

            @Override
            public void execute() {
                getCommand().execute();
            }
        });

        cursoMenu.addOption(new MenuOption() {
            @Override
            public String getText() {
                return "Listar Cursos";
            }

            @Override
            public Command getCommand() {
                return new MenuCommand(() -> {
                    System.out.println("Lista de Cursos:");
                    for (Curso curso : sistemaGestion.getListaCursos()) {
                        System.out.println("Curso: "
                                + curso.getNombre() + ", Categoría: "
                                + curso.getCategoria() + ", Código: "
                                + curso.getCodigoCurso());
                    }
                });
            }

            @Override
            public void execute() {
                getCommand().execute();
            }
        });

        cursoMenu.addOption(new MenuOption() {
            @Override
            public String getText() {
                return "Asignar Profesor a Curso";
            }

            @Override
            public Command getCommand() {
                return new MenuCommand(() -> {
                    String codigoCurso = InputHandler.getString("Ingrese el código del curso: ");
                    Curso curso = sistemaGestion.obtenerCursoPorCodigo(codigoCurso);

                    if (curso != null) {
                        String idProfesor = InputHandler.getString("Ingrese el ID del profesor: ");
                        Profesor profesor = sistemaGestion.obtenerProfesorPorId(idProfesor);

                        if (curso.getProfesor() == profesor) {
                            System.out.println("El profesor ya está asignado a este curso.");

                        }else if (profesor != null) {
                            sistemaGestion.asignarProfesorACurso(profesor, curso);
                            System.out.println("Profesor asignado exitosamente al curso.");

                        }  else {
                            System.out.println("Profesor no encontrado.");
                        }
                    } else {
                        System.out.println("Curso no encontrado.");
                    }
                });
            }

            @Override
            public void execute() {
                getCommand().execute();
            }
        });

        cursoMenu.addOption(new MenuOption() {
            @Override
            public String getText() {
                return "Inscribir Estudiante en Curso";
            }

            @Override
            public Command getCommand() {
                return new MenuCommand(() -> {
                    String codigoCurso = InputHandler.getString("Ingrese el código del curso: ");
                    Curso curso = sistemaGestion.obtenerCursoPorCodigo(codigoCurso);

                    if (curso != null) {
                        String matricula = InputHandler.getString("Ingrese la matrícula del estudiante: ");
                        Estudiante estudiante = sistemaGestion.obtenerEstudiantePorMatricula(matricula);
                        if (curso.getEstudiantesInscritos().contains(estudiante)) {
                            System.out.println("El estudiante ya está inscrito en este curso.");
                        }
                        else if (estudiante != null) {
                            sistemaGestion.inscribirEstudianteEnCurso(estudiante, curso);
                            System.out.println("Estudiante inscrito exitosamente en el curso.");
                        }
                         else {
                            System.out.println("Estudiante no encontrado.");
                        }
                    } else {
                        System.out.println("Curso no encontrado.");
                    }
                });
            }

            @Override
            public void execute() {
                getCommand().execute();
            }
        });

        cursoMenu.addOption(new MenuOption() {
            @Override
            public String getText() {
                return "Volver al Menú Principal";
            }

            @Override
            public Command getCommand() {
                return new MenuCommand(cursoMenu::exitMenu);
            }

            @Override
            public void execute() {
                getCommand().execute();
            }
        });

        // Agregar submenús al menú principal
        mainMenu.addOption(new MenuOption() {
            @Override
            public String getText() {
                return "Gestión de Estudiantes";
            }

            @Override
            public Command getCommand() {
                return new MenuCommand(estudianteMenu::show);
            }

            @Override
            public void execute() {
                getCommand().execute();
            }
        });

        mainMenu.addOption(new MenuOption() {
            @Override
            public String getText() {
                return "Gestión de Profesores";
            }

            @Override
            public Command getCommand() {
                return new MenuCommand(profesorMenu::show);
            }

            @Override
            public void execute() {
                getCommand().execute();
            }
        });

        mainMenu.addOption(new MenuOption() {
            @Override
            public String getText() {
                return "Gestión de Cursos";
            }

            @Override
            public Command getCommand() {
                return new MenuCommand(cursoMenu::show);
            }

            @Override
            public void execute() {
                getCommand().execute();
            }
        });

        mainMenu.addOption(new MenuOption() {
            @Override
            public String getText() {
                return "Salir";
            }

            @Override
            public Command getCommand() {
                return new MenuCommand(mainMenu::exitMenu);
            }

            @Override
            public void execute() {
                getCommand().execute();
            }
        });

        // Mostrar el menú principal
        mainMenu.show();
    }
}
