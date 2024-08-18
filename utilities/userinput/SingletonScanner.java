package utilities.userinput;

import java.util.Scanner;

/**
 * Singleton class for managing the single instance of Scanner.
 */
public class SingletonScanner {
    private static final Scanner INSTANCE = new Scanner(System.in);

    private SingletonScanner() {
        // Prevent instantiation
    }

    public static Scanner getInstance() {
        return INSTANCE;
    }
}
