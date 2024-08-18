package utilities.userinput;

import java.util.function.Predicate;

/**
 * Encapsulates the validation logic.
 */
public class InputValidator {

    /**
     * Validates an integer input based on a custom predicate.
     *
     * @param value the integer value to validate
     * @param validator the predicate to validate the input
     * @return true if the input is valid, false otherwise
     */
    public static boolean validateInteger(int value, Predicate<Integer> validator) {
        return validator.test(value);
    }

    /**
     * Validates a string input based on a custom predicate.
     *
     * @param input the string value to validate
     * @param validator the predicate to validate the input
     * @return true if the input is valid, false otherwise
     */
    public static boolean validateString(String input, Predicate<String> validator) {
        return validator.test(input);
    }
}
