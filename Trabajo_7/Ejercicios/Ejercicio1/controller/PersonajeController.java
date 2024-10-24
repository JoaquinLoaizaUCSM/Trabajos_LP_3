package Trabajo_7.Ejercicios.Ejercicio1.controller;



import Trabajo_7.Ejercicios.Ejercicio1.model.Personaje;
import Trabajo_7.Ejercicios.Ejercicio1.model.PersonajeDAO;
import Trabajo_7.Ejercicios.Ejercicio1.view.PersonajeView;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class PersonajeController {
    private List<Personaje> personajes;
    private final PersonajeDAO dao;
    private final PersonajeView view;

    public PersonajeController(PersonajeView view) {
        this.dao = new PersonajeDAO();
        this.view = view;
        this.personajes = new ArrayList<>();
        cargarDatos();
    }

    private void cargarDatos() {
        try {
            this.personajes = dao.cargar();
        } catch (IOException | ClassNotFoundException e) {
            view.mostrarError("Error al cargar los datos: " + e.getMessage());
        }
    }

    public void agregarPersonaje(Personaje personaje) {
        if (personajes.contains(personaje)) {
            view.mostrarError("Ya existe un personaje con ese nombre");
            return;
        }
        personajes.add(personaje);
        guardarDatos();
        view.mostrarMensaje("Personaje agregado exitosamente");
    }

    public void eliminarPersonaje(String nombre) {
        boolean eliminado = personajes.removeIf(p -> p.getNombre().equals(nombre));
        if (eliminado) {
            guardarDatos();
            view.mostrarMensaje("Personaje eliminado exitosamente");
        } else {
            view.mostrarError("No se encontró el personaje");
        }
    }

    public Personaje buscarPersonaje(String nombre) {
        return personajes.stream()
                .filter(p -> p.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }

    public void actualizarPersonaje(String nombre, Personaje nuevosDatos) {
        Personaje personaje = buscarPersonaje(nombre);
        if (personaje != null) {
            personaje.setVida(nuevosDatos.getVida());
            personaje.setAtaque(nuevosDatos.getAtaque());
            personaje.setDefensa(nuevosDatos.getDefensa());
            personaje.setAlcance(nuevosDatos.getAlcance());
            guardarDatos();
            view.mostrarMensaje("Personaje actualizado exitosamente");
        } else {
            view.mostrarError("No se encontró el personaje");
        }
    }

    public List<Personaje> obtenerPersonajesOrdenados(String atributo) {
        return switch (atributo.toLowerCase()) {
            case "nombre" -> personajes.stream()
                    .sorted(Comparator.comparing(Personaje::getNombre))
                    .collect(Collectors.toList());
            case "vida" -> personajes.stream()
                    .sorted(Comparator.comparing(Personaje::getVida))
                    .collect(Collectors.toList());
            case "ataque" -> personajes.stream()
                    .sorted(Comparator.comparing(Personaje::getAtaque))
                    .collect(Collectors.toList());
            case "defensa" -> personajes.stream()
                    .sorted(Comparator.comparing(Personaje::getDefensa))
                    .collect(Collectors.toList());
            case "alcance" -> personajes.stream()
                    .sorted(Comparator.comparing(Personaje::getAlcance))
                    .collect(Collectors.toList());
            case "nivel" -> personajes.stream()
                    .sorted(Comparator.comparing(Personaje::getNivel))
                    .collect(Collectors.toList());
            default -> new ArrayList<>(personajes);
        };
    }

    public Personaje generarPersonajeAleatorio() {
        String[] nombres = {"Guerrero", "Mago", "Arquero", "Caballero", "Asesino"};
        Random rand = new Random();
        String nombre = nombres[rand.nextInt(nombres.length)] + rand.nextInt(100);
        return new Personaje(
            nombre,
            rand.nextInt(50) + 50,
            rand.nextInt(20) + 10,
            rand.nextInt(15) + 5,
            rand.nextInt(50) + 20
        );
    }

    public Map<String, Double> obtenerEstadisticas() {
        Map<String, Double> stats = new HashMap<>();
        stats.put("vidaPromedio", personajes.stream().mapToInt(Personaje::getVida).average().orElse(0));
        stats.put("ataquePromedio", personajes.stream().mapToInt(Personaje::getAtaque).average().orElse(0));
        stats.put("defensaPromedio", personajes.stream().mapToInt(Personaje::getDefensa).average().orElse(0));
        stats.put("nivelPromedio", personajes.stream().mapToInt(Personaje::getNivel).average().orElse(0));
        return stats;
    }

    private void guardarDatos() {
        try {
            dao.guardar(personajes);
        } catch (IOException e) {
            view.mostrarError("Error al guardar los datos: " + e.getMessage());
        }
    }

    public void exportarACSV(String archivo) {
        try {
            dao.exportarCSV(personajes, archivo);
            view.mostrarMensaje("Datos exportados exitosamente");
        } catch (IOException e) {
            view.mostrarError("Error al exportar los datos: " + e.getMessage());
        }
    }

    public void importarDeCSV(String archivo) {
        try {
            List<Personaje> importados = dao.importarCSV(archivo);
            personajes.addAll(importados);
            guardarDatos();
            view.mostrarMensaje("Datos importados exitosamente");
        } catch (IOException e) {
            view.mostrarError("Error al importar los datos: " + e.getMessage());
        }
    }
}