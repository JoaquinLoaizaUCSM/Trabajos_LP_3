package Trabajo_6.Actividades.teoria;

public class Main {
    public static void main(String[] args) {
        TaskView vista = new TaskView();
        TaskController controlador = new TaskController(vista);

        controlador.addTask("Cocinar");
        controlador.addTask("Limpizar baño");

        controlador.displayTasks();

        controlador.completeTask(0);
        controlador.completeTask(1);

        controlador.displayTasks();


        controlador.deleteTask(1);

        controlador.displayTasks();

        controlador.editTask(0,"Limpiar cocina");
    }
}
