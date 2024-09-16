package utilities.consolemenu;

// Implementación de la interfaz MenuOption
public class MenuEstandar implements MenuOption {
    private final String text;
    private final Command command;

    public MenuEstandar(String text, Command command) {
        this.text = text;
        this.command = command;
    }


    @Override
    public String getText() {
        return text;
    }

    @Override
    public Command getCommand() {
        return command;
    }

    @Override
    public void execute() {
        command.execute();
    }
}
