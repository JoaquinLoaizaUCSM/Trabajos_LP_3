package utilities.consolemenu;

public interface MenuOption {
    String getText();
    Command getCommand();
    void execute();
}
