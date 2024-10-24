package Trabajo_7.Actividades;

import java.io.FileWriter;
import java.io.IOException;
public class FileWriterExample {
    public static void main(String[] args) {
        String fileName = "src/Trabajo_7/Teoria/archivo.txt";
        String[] lines = {
                "Primera línea del archivo.",
                "Segunda línea del archivo.",
                "Tercera línea del archivo."
        };
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String line : lines) {
                writer.write(line);
                writer.write(System.lineSeparator());
            }
            System.out.println("Contenido escrito en el archivo: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}