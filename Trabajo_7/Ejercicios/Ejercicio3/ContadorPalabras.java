package Trabajo_7.Ejercicios.Ejercicio3;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class ContadorPalabras {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            procesarArchivo(selectedFile);
        } else {
            System.out.println("No se seleccionó ningún archivo.");
        }
    }

    private static void procesarArchivo(File archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            int lineas = 0;
            int palabras = 0;
            int caracteres = 0;
            Map<String, Integer> frecuenciaPalabras = new HashMap<>();

            String linea;
            while ((linea = br.readLine()) != null) {
                lineas++;
                caracteres += linea.length();

                String[] palabrasEnLinea = linea.split("\\s+");
                for (String palabra : palabrasEnLinea) {
                    palabra = limpiarPalabra(palabra);
                    if (!palabra.isEmpty()) {
                        palabras++;
                        frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
                    }
                }
            }

            // Mostrar resultados
            System.out.println("Total de líneas: " + lineas);
            System.out.println("Total de palabras: " + palabras);
            System.out.println("Total de caracteres: " + caracteres);
            System.out.println("Promedio de palabras por línea: " + String.format("%.2f", (double) palabras / lineas));

            // Mostrar palabras más frecuentes
            System.out.println("Palabras más frecuentes:");
            frecuenciaPalabras.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .limit(5)  // Mostrar las 5 palabras más frecuentes
                    .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            System.out.println("Por favor, seleccione otro archivo.");
            main(new String[0]);  // Volver a ejecutar el programa
        }
    }

    private static String limpiarPalabra(String palabra) {
        StringBuilder palabraLimpia = new StringBuilder();
        for (char c : palabra.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                palabraLimpia.append(Character.toLowerCase(c));
            }
        }
        return palabraLimpia.toString();
    }
}