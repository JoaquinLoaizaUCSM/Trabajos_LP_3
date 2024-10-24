package Trabajo_7.Ejercicios.Ejercicio1.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonajeDAO {
    private static final String ARCHIVO_DATOS = "Trabajo_7/Ejercicios/Ejercicio1/personajes.dat";

    public void guardar(List<Personaje> personajes) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_DATOS))) {
            oos.writeObject(new ArrayList<>(personajes));
        }
    }

    @SuppressWarnings("unchecked")
    public List<Personaje> cargar() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_DATOS))) {
            return (List<Personaje>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
    }

    public void exportarCSV(List<Personaje> personajes, String archivo) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
            writer.println("nombre,nivel,vida,ataque,defensa,alcance");
            for (Personaje p : personajes) {
                writer.printf("%s,%d,%d,%d,%d,%d%n",
                    p.getNombre(), p.getNivel(), p.getVida(),
                    p.getAtaque(), p.getDefensa(), p.getAlcance());
            }
        }
    }

    public List<Personaje> importarCSV(String archivo) throws IOException {
        List<Personaje> personajes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String line = reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                personajes.add(new Personaje(
                    datos[0],
                    Integer.parseInt(datos[2]),
                    Integer.parseInt(datos[3]),
                    Integer.parseInt(datos[4]),
                    Integer.parseInt(datos[5])
                ));
            }
        }
        return personajes;
    }
}