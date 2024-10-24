package utilities.consoleinput.validators;

import java.util.ArrayList;
import java.util.List;

public abstract class NumberValidator {
    protected final List<ValidationRule<Integer>> rules = new ArrayList<>();
}
