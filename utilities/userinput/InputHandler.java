package utilities.userinput;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Handles user input with validation for various data types.
 */
public class InputHandler {
    private static final Scanner scanner = SingletonScanner.getInstance();

    /**
     * Prompts the user for an number input with both custom validation and positivity check.
     *
     * @param prompt the message shown to the user
     * @param validator the predicate to validate the input
     * @param positiveOnly whether only positive integers are allowed
     * @return the validated number input from the user
     */
    public static int getInteger(String prompt, Predicate<Integer> validator, boolean positiveOnly) {
        return getInput(prompt, scanner::nextInt, validator, positiveOnly,
                "Entrada inválida. Por favor, ingrese un número entero.",
                "Por favor, ingrese un número positivo.");
    }

    public static int getInteger(String prompt, Predicate<Integer> validator) {
        return getInteger(prompt, validator, false);
    }

    public static int getInteger(String prompt, boolean positiveOnly) {
        return getInteger(prompt, null, positiveOnly);
    }

    public static int getInteger(String prompt) {
        return getInteger(prompt, null);
    }

    public static double getDouble(String prompt, Predicate<Double> validator, boolean positiveOnly) {
        return getInput(prompt, scanner::nextDouble, validator, positiveOnly,
                "Entrada inválida. Por favor, ingrese un número decimal.",
                "Por favor, ingrese un número positivo.");
    }

    public static double getDouble(String prompt, Predicate<Double> validator) {
        return getDouble(prompt, validator, false);
    }

    public static double getDouble(String prompt, boolean positiveOnly) {
        return getDouble(prompt, null, positiveOnly);
    }

    public static double getDouble(String prompt) {
        return getDouble(prompt, null);
    }


    public static String getString(String prompt, Predicate<String> validator) {
        return getInput(prompt, scanner::nextLine, validator, "Entrada inválida. Por favor, ingrese un texto válido.");
    }

    public static String getString(String prompt) {
        return getString(prompt, null);
    }


    /**
     * General method to handle input validation for numeric types (Integer, Double, etc.).
     *
     * @param SupplierWithException the type of input (Integer, Double, etc.)
     * @param prompt the message shown to the user
     * @param supplier the method reference to get the input
     * @param validator the predicate to validate the input
     * @param positiveOnly whether only positive numbers are allowed
     * @param invalidMessage the message shown when input is invalid
     * @param positiveOnlyMessage the message shown when input is not positive
     * @return the validated input from the user
     */
    private static <T extends Number> T getInput(String prompt, SupplierWithException<T> supplier, Predicate<T> validator,
                                                 boolean positiveOnly, String invalidMessage, String positiveOnlyMessage) {
        while (true) {
            System.out.print(prompt);
            try {
                T value = supplier.get();
                scanner.nextLine(); // Clear the buffer
                if (positiveOnly && value.doubleValue() <= 0) {
                    System.out.println(positiveOnlyMessage);
                    continue;
                }
                if (validator == null || validator.test(value)) {
                    return value;
                }
                System.out.println("El valor no cumple con los criterios requeridos.");
            } catch (InputMismatchException e) {
                System.out.println(invalidMessage);
                scanner.nextLine(); // Clear the buffer
            }
        }
    }


    // Overloaded getInput method for non-numeric types
    private static <T> T getInput(String prompt, SupplierWithException<T> supplier, Predicate<T> validator,
                                  String invalidMessage) {
        while (true) {
            System.out.print(prompt);
            try {
                T value = supplier.get();
                if (validator == null || validator.test(value)) {
                    return value;
                }
                System.out.println("El valor no cumple con los criterios requeridos.");
            } catch (InputMismatchException e) {
                System.out.println(invalidMessage);
            }
        }
    }

    /**
     * Functional interface for handling input with exception.
     */
    @FunctionalInterface
    interface SupplierWithException<T> {
        T get() throws InputMismatchException;
    }
}
