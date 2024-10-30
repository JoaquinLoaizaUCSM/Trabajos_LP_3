package Trabajo_8.Ejercicio.model.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    private static Connection connection;

    // Cambiar la dirección de la base de datos según la ubicación del archivo
    private static final String URL = "jdbc:sqlite:Trabajo_8\\Ejercicio\\musica.db";

    private DatabaseConnection() {
        // Constructor privado para evitar instanciación
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Cargar el driver de SQLite
                Class.forName("org.sqlite.JDBC");
                // Establecer la conexión
                connection = DriverManager.getConnection(URL);
                // Habilitar claves foráneas
                Statement stmt = connection.createStatement();
                stmt.execute("PRAGMA foreign_keys = ON");
                stmt.close();
                System.out.println("Conexión establecida con la base de datos.");
            } catch (ClassNotFoundException e) {
                System.err.println("Error al cargar el driver de SQLite.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("Error al conectar con la base de datos.");
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada con la base de datos.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión con la base de datos.");
                e.printStackTrace();
            }
        }
    }
}
