package utilities.userinput;

import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * Factory class for creating common validators for integers and strings.
 */
public class ValidatorFactory {

    /**
     * Creates a validator for integers that checks if the value is between min and max inclusive.
     *
     * @param min the minimum allowed value
     * @param max the maximum allowed value
     * @return a predicate that validates the range
     */
    public static Predicate<Integer> betweenInclusive(int min, int max) {
        return value -> value >= min && value <= max;
    }

    /**
     * Creates a validator for strings that checks if the length is between the specified range.
     *
     * @param minLength the minimum allowed length
     * @param maxLength the maximum allowed length
     * @return a predicate that validates the length
     */
    public static Predicate<String> lengthBetween(int minLength, int maxLength) {
        return input -> input.length() >= minLength && input.length() <= maxLength;
    }

    /**
     * Creates a validator for strings that checks if all characters are uppercase.
     *
     * @return a predicate that validates if a string is fully uppercase
     */
    public static Predicate<String> isUpperCase() {
        return input -> input.equals(input.toUpperCase());
    }

    /**
     * Creates a validator for strings that checks if all characters are lowercase.
     *
     * @return a predicate that validates if a string is fully lowercase
     */
    public static Predicate<String> isLowerCase() {
        return input -> input.equals(input.toLowerCase());
    }

    /**
     * Creates a validator for strings that checks if it matches a specific regular expression pattern.
     *
     * @param regex the regular expression pattern to match
     * @return a predicate that validates if a string matches the pattern
     */
    public static Predicate<String> matchesPattern(String regex) {
        return input -> Pattern.matches(regex, input);
    }

    /**
     * Creates a validator for validating email format using a regular expression.
     *
     * @return a predicate that validates if a string matches an email format
     */
    public static Predicate<String> isEmail() {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return matchesPattern(emailRegex);
    }

    /**
     * Creates a validator for validating phone number format using a regular expression.
     * This example uses a simple pattern for North American phone numbers.
     *
     * @return a predicate that validates if a string matches a phone number format
     */
    public static Predicate<String> isPhoneNumber() {
        // Format: 900304239
        String phoneRegex = "^d{9}[0-9]$";
        return matchesPattern(phoneRegex);
    }
}
