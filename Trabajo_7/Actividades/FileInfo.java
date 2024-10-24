package Trabajo_7.Actividades;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

public class FileInfo {
    public static void main(String[] args) {
        // Especifica la ruta del archivo
        File file = new File ("src/Trabajo_6/archivo.txt");

        System.out.println(file.getName());
        // Verifica si el archivo existe
        if (file.exists()) {

        // Obtiene información del archivo
            String fileName = file.getName();
            long fileSize = file.length(); // tamaño en bytes
            long lastModified = file.lastModified(); // fecha de última modificación
            boolean isDirectory = file.isDirectory();

            // Formatear la fecha de última modificación
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String lastModifiedDate = sdf.format(lastModified);

            // Imprimir la información
            System.out.println("Nombre del archivo: " + fileName);
            System.out.println("Tamaño del archivo: " + fileSize + " bytes");
            System.out.println("Última modificación: " + lastModifiedDate);
            System.out.println("¿Es un directorio? " + (isDirectory ? "Sí" : "No"));
        } else {
            System.out.println("El archivo no existe.");
        }
    }
}