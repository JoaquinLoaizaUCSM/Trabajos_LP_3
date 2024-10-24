package Trabajo_7.Actividades;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriterExample {
    public static void main(String[] args) {
        String fileName = "src/Trabajo_7/Teoria/texto_printwriter.txt";
        String[] lines = {
                "Primera línea del archivo.",
                "Segunda línea del archivo.",
                "Tercera línea del archivo."
        };
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (String line : lines) {
                writer.println(line);
            }
            System.out.println("Contenido escrito en el archivo: " + fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}