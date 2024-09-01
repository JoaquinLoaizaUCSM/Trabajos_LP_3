package utilities.consolemenu;

import utilities.userinput.*;
import java.util.function.Predicate;

public class MenuInputHandler {

    Predicate<Integer> rangoValidador = ValidatorFactory.betweenInclusive(1, 100);

    private InputValidator validator;

    public MenuInputHandler(InputValidator validator) {
        this.validator = validator;
    }

    public int getValidatedInput(String prompt, int maxOption) {
        return InputHandler.getInteger(prompt, ValidatorFactory.betweenInclusive(1, maxOption));
    }
}