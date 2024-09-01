package utilities.consolemenu;

import java.util.ArrayList;
import java.util.List;

public class ConsoleMenu {
    private String title;
    private List<MenuOption> options;
    private MenuInputHandler inputHandler;
    private boolean exit;

    public ConsoleMenu(String title, MenuInputHandler inputHandler) {
        this.title = title;
        this.options = new ArrayList<>();
        this.inputHandler = inputHandler;
        this.exit = false;
    }

    public void addOption(MenuOption option) {
        options.add(option);
    }

    public void show() {
        exit = false;
        do {
            System.out.println("\n" + title);
            System.out.println("--------------------");
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i).getText());
            }
            System.out.println("--------------------");
            handleUserInput();
        } while (!exit);
    }

    private void handleUserInput() {
        int choice = inputHandler.getValidatedInput("Escoga una opcion: ", options.size());
        options.get(choice - 1).execute();
    }

    public void exitMenu() {
        this.exit = true;
    }
}