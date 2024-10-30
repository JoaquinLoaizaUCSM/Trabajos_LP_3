SELECT c.titulo, a.nombre AS artista, al.nombre AS album
FROM Canciones c
         JOIN Canciones_Artistas ca ON c.cancion_id = ca.cancion_id
         JOIN Artistas a ON ca.artista_id = a.artista_id
         JOIN Albumes al ON c.album_id = al.album_id
WHERE al.genero = 'Rock';
