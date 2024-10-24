package Trabajo_7.Actividades;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class WriterExample {
    public static void main(String[] args) {
        String fileName1 = "src/Trabajo_7/Teoria/ejemplo_filewriter.txt";
        String fileName2 = "src/Trabajo_7/Teoria/ejemplo_printwriter.txt";
        String content = "Hola, esto es un ejemplo de escritura.\n";
        int number = 42;
// Usando FileWriter
        try (FileWriter fileWriter = new FileWriter(fileName1)) {
            fileWriter.write(content);
            fileWriter.write("El número es: " + number);
        } catch (IOException e) {
            e.printStackTrace();
        }
// Usando PrintWriter
        try (PrintWriter printWriter = new PrintWriter(fileName2)) {
            printWriter.println(content);
            printWriter.printf("El número es: %d%n", number);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}