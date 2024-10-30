package Trabajo_8.Actividad;


public class Main {
    public static void main(String[] args) {
        ArtistasDAO dao = new ArtistasDAO();

        // Crear la tabla si no existe
        dao.createTable();


        dao.insertarArtista("Taylor Swift", "Pop", "Estados Unidos");


        dao.recuperarArtista(1);

        dao.actualizarArtista(1, "Taylor Swift", "Pop/Country", "Estados Unidos");

        dao.borrarArtista(1);
    }
}