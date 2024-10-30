-- Habilitar claves foráneas en SQLite
PRAGMA foreign_keys = ON;

-- Inserción de datos en la tabla Usuarios
INSERT INTO Usuarios (nombre, email, tipo_suscripcion, fecha_creacion) VALUES
('Juan Pérez', 'juan.perez@example.com', 'Premium', '2023-01-15'),
('María Gómez', 'maria.gomez@example.com', 'Free', '2023-02-20'),
('Carlos Sánchez', 'carlos.sanchez@example.com', 'Premium', '2023-03-10'),
('Laura Díaz', 'laura.diaz@example.com', 'Free', '2023-04-05'),
('Ana López', 'ana.lopez@example.com', 'Premium', '2023-05-22'),
('Pedro Martínez', 'pedro.martinez@example.com', 'Free', '2023-06-18'),
('Lucía Torres', 'lucia.torres@example.com', 'Premium', '2023-07-12'),
('Diego Ramírez', 'diego.ramirez@example.com', 'Free', '2023-08-25'),
('Sofía Fernández', 'sofia.fernandez@example.com', 'Premium', '2023-09-30'),
('Javier Herrera', 'javier.herrera@example.com', 'Free', '2023-10-08');

-- Inserción de datos en la tabla Perfiles_Usuarios
INSERT INTO Perfiles_Usuarios (usuario_id, foto_perfil, biografia) VALUES
(1, 'foto1.jpg', 'Amante de la música rock'),
(2, 'foto2.jpg', 'Disfruto de la música clásica'),
(3, 'foto3.jpg', 'Fanático del jazz'),
(4, 'foto4.jpg', 'Me gusta descubrir nuevos artistas'),
(5, 'foto5.jpg', 'Compartiendo playlists de pop'),
(6, 'foto6.jpg', 'Explorando ritmos latinos'),
(7, 'foto7.jpg', 'Música para entrenar'),
(8, 'foto8.jpg', 'Siempre con buena música'),
(9, 'foto9.jpg', 'Melómano empedernido'),
(10, 'foto10.jpg', 'Amante de los conciertos en vivo');

-- Inserción de datos en la tabla Artistas
INSERT INTO Artistas (nombre, genero, pais_origen) VALUES
('The Beatles', 'Rock', 'Reino Unido'),
('Queen', 'Rock', 'Reino Unido'),
('Michael Jackson', 'Pop', 'Estados Unidos'),
('Madonna', 'Pop', 'Estados Unidos'),
('Luis Miguel', 'Balada', 'México'),
('Shakira', 'Pop', 'Colombia'),
('Coldplay', 'Rock', 'Reino Unido'),
('Adele', 'Soul', 'Reino Unido'),
('Bruno Mars', 'Pop', 'Estados Unidos'),
('Beyoncé', 'R&B', 'Estados Unidos');

-- Inserción de datos en la tabla Albumes
INSERT INTO Albumes (nombre, fecha_lanzamiento, genero) VALUES
('Abbey Road', '1969-09-26', 'Rock'),
('A Night at the Opera', '1975-11-21', 'Rock'),
('Thriller', '1982-11-30', 'Pop'),
('Like a Virgin', '1984-11-12', 'Pop'),
('Romance', '1991-11-19', 'Balada'),
('Laundry Service', '2001-11-13', 'Pop'),
('Parachutes', '2000-07-10', 'Rock'),
('21', '2011-01-24', 'Soul'),
('Doo-Wops & Hooligans', '2010-10-04', 'Pop'),
('Lemonade', '2016-04-23', 'R&B');

-- Inserción de datos en la tabla Albumes_Artistas
INSERT INTO Albumes_Artistas (album_id, artista_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

-- Inserción de datos en la tabla Canciones
INSERT INTO Canciones (titulo, duracion, album_id) VALUES
('Come Together', 259, 1),
('Something', 182, 1),
('Bohemian Rhapsody', 354, 2),
('Love of My Life', 216, 2),
('Beat It', 258, 3),
('Billie Jean', 293, 3),
('Like a Virgin', 215, 4),
('Material Girl', 239, 4),
('No Sé Tú', 216, 5),
('Hasta Que Me Olvides', 270, 5),
('Whenever, Wherever', 211, 6),
('Underneath Your Clothes', 200, 6),
('Yellow', 266, 7),
('Trouble', 270, 7),
('Rolling in the Deep', 228, 8),
('Someone Like You', 285, 8),
('Just the Way You Are', 220, 9),
('Grenade', 223, 9),
('Formation', 213, 10),
('Sorry', 202, 10);

-- Inserción de datos en la tabla Canciones_Artistas
INSERT INTO Canciones_Artistas (cancion_id, artista_id) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 2),
(5, 3),
(6, 3),
(7, 4),
(8, 4),
(9, 5),
(10, 5),
(11, 6),
(12, 6),
(13, 7),
(14, 7),
(15, 8),
(16, 8),
(17, 9),
(18, 9),
(19, 10),
(20, 10);

-- Inserción de datos en la tabla Listas_Reproduccion
INSERT INTO Listas_Reproduccion (nombre, usuario_id, fecha_creacion) VALUES
('Rock Clásico', 1, '2023-05-01'),
('Pop Hits', 2, '2023-06-15'),
('Baladas Románticas', 3, '2023-07-20'),
('Lo Mejor de los 80s', 4, '2023-08-05'),
('Música para Entrenar', 5, '2023-09-10'),
('Mis Favoritas', 6, '2023-10-22'),
('Top Internacional', 7, '2023-11-11'),
('Descubrimientos', 8, '2023-12-01'),
('Clásicos en Español', 9, '2024-01-16'),
('Éxitos del Momento', 10, '2024-02-28');

-- Inserción de datos en la tabla Canciones_Listas
INSERT INTO Canciones_Listas (lista_id, cancion_id) VALUES
(1, 1),
(1, 3),
(1, 13),
(2, 5),
(2, 11),
(2, 17),
(3, 9),
(3, 10),
(4, 4),
(4, 7),
(5, 17),
(5, 19),
(6, 2),
(6, 6),
(6, 12),
(7, 15),
(7, 18),
(8, 14),
(8, 16),
(9, 9),
(9, 11),
(10, 5),
(10, 15),
(10, 19);
