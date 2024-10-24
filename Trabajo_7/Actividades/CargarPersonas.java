package Trabajo_7.Actividades;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class CargarPersonas {
    public static void main(String[] args) {
// Cargar los objetos desde un archivo
        try (FileInputStream fis = new FileInputStream("src/Trabajo_7/Teoria/personas.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Persona p1 = (Persona) ois.readObject();
            Persona p2 = (Persona) ois.readObject();
            System.out.println("Personas cargadas desde el archivo:");
            System.out.println(p1);
            System.out.println(p2);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar las personas: " + e.getMessage());
        }
    }
}