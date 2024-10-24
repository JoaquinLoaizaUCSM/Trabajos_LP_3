package Trabajo_7.Actividades;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) {
        String fileName = "src/Trabajo_7/Teoria/archivo.txt";
        BufferedReader bufferedReader = null;
        try {
            FileReader fr = new FileReader(fileName);
            bufferedReader = new BufferedReader(fr);
            String line;
            System.out.println("Contenido del archivo " + fileName + ":");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}