SELECT a.nombre AS artista, COUNT(ca.cancion_id) AS total_canciones
FROM Artistas a
         JOIN Canciones_Artistas ca ON a.artista_id = ca.artista_id
GROUP BY a.artista_id;
