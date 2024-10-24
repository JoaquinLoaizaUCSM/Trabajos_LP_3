package utilities.consoleinput.validators;
import utilities.consoleinput.exceptions.ValidationException;
import utilities.consoleinput.Messages;

import java.util.function.Predicate;

/**
 * Validator for integer inputs.
 */
public class IntegerValidator extends NumberValidator implements InputValidator<Integer> {
    private Integer minValue;
    private Integer maxValue;

    public IntegerValidator min(int minValue) {
        this.minValue = minValue;
        return this;
    }

    public IntegerValidator max(int maxValue) {
        this.maxValue = maxValue;
        return this;
    }

    public IntegerValidator condition(Predicate<Integer> condition, String errorMessageKey, Object... params) {
        rules.add(new ValidationRule<>(condition, Messages.get(errorMessageKey, params)));
        return this;
    }

    public IntegerValidator errorMessage(String errorMessageKey, Object... params) {
        if (!rules.isEmpty()) {
            rules.getLast().setErrorMessage(Messages.get(errorMessageKey, params));
        }
        return this;
    }

    @Override
    public Integer validate(String input) throws ValidationException {
        int value;
        try {
            value = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new ValidationException(Messages.get("error.number.invalid"));
        }

        if (minValue != null && value < minValue) {
            throw new ValidationException(Messages.get("error.number.min", minValue));
        }

        if (maxValue != null && value > maxValue) {
            throw new ValidationException(Messages.get("error.number.max", maxValue));
        }

        for (ValidationRule<Integer> rule : rules) {
            if (!rule.getCondition().test(value)) {
                throw new ValidationException(rule.getErrorMessage());
            }
        }

        return value;
    }
}
