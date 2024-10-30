SELECT c.titulo, l.nombre AS lista
FROM Usuarios u
         JOIN Listas_Reproduccion l ON u.usuario_id = l.usuario_id
         JOIN Canciones_Listas cl ON l.lista_id = cl.lista_id
         JOIN Canciones c ON cl.cancion_id = c.cancion_id
WHERE u.nombre = 'Juan Pérez';
