package Trabajo_7.Actividades;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileScannerExample {
    public static void main(String[] args) {
        String fileName = "src/Trabajo_7/Teoria/ejemplo_printwriter.txt";
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            System.out.println("Contenido del archivo " + fileName + ":");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no fue encontrado: " + e.getMessage());
        }
    }
}