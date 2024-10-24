package Trabajo_7.Actividades;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class BinaryFileInputStream {
    public static void main(String[] args) {

        // Especifica la ruta del archivo binario
        String filePath = "src/Trabajo_7/Teoria/datos.bin";
        // Usa FileInputStream y DataInputStream para leer el archivo binario

        try (FileInputStream fis = new FileInputStream(filePath);
             DataInputStream dis = new DataInputStream(fis)) {
            // Leer y mostrar los datos en el orden en que fueron escritos
            int numeroEntero = dis.readInt();
            double numeroDoble = dis.readDouble();
            String texto = dis.readUTF();
            System.out.println("Número entero leído: " + numeroEntero);
            System.out.println("Número doble leído: " + numeroDoble);
            System.out.println("Texto leído: " + texto);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }
}