package utilities.consolemenu;

public class MenuCommand implements Command {
    private Runnable action;

    public MenuCommand(Runnable action) {
        this.action = action;
    }

    @Override
    public void execute() {
        action.run();
    }
}

