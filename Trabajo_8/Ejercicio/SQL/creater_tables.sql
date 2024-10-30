PRAGMA foreign_keys = ON;

CREATE TABLE Usuarios (
usuario_id INTEGER PRIMARY KEY AUTOINCREMENT,
nombre VARCHAR(100) NOT NULL,
email VARCHAR(100) UNIQUE NOT NULL,
tipo_suscripcion VARCHAR(50) NOT NULL,
fecha_creacion DATE NOT NULL
);

CREATE TABLE Perfiles_Usuarios (
perfil_id INTEGER PRIMARY KEY AUTOINCREMENT,
usuario_id INTEGER UNIQUE NOT NULL,
foto_perfil VARCHAR(255),
biografia TEXT,
FOREIGN KEY (usuario_id) REFERENCES Usuarios(usuario_id) ON DELETE CASCADE
);

CREATE TABLE Artistas (
artista_id INTEGER PRIMARY KEY AUTOINCREMENT,
nombre VARCHAR(100) NOT NULL,
genero VARCHAR(50),
pais_origen VARCHAR(50)
);

CREATE TABLE Albumes (
 album_id INTEGER PRIMARY KEY AUTOINCREMENT,
 nombre VARCHAR(100) NOT NULL,
 fecha_lanzamiento DATE,
 genero VARCHAR(50)
);

CREATE TABLE Albumes_Artistas (
album_artista_id INTEGER PRIMARY KEY AUTOINCREMENT,
album_id INTEGER NOT NULL,
artista_id INTEGER NOT NULL,
FOREIGN KEY (album_id) REFERENCES Albumes(album_id) ON DELETE CASCADE,
FOREIGN KEY (artista_id) REFERENCES Artistas(artista_id) ON DELETE CASCADE
);

CREATE TABLE Canciones (
cancion_id INTEGER PRIMARY KEY AUTOINCREMENT,
titulo VARCHAR(100) NOT NULL,
duracion INTEGER NOT NULL, -- Duración en segundos
album_id INTEGER,
FOREIGN KEY (album_id) REFERENCES Albumes(album_id) ON DELETE SET NULL
);

CREATE TABLE Canciones_Artistas (
cancion_artista_id INTEGER PRIMARY KEY AUTOINCREMENT,
cancion_id INTEGER NOT NULL,
artista_id INTEGER NOT NULL,
FOREIGN KEY (cancion_id) REFERENCES Canciones(cancion_id) ON DELETE CASCADE,
FOREIGN KEY (artista_id) REFERENCES Artistas(artista_id) ON DELETE CASCADE
);

CREATE TABLE Listas_Reproduccion (
lista_id INTEGER PRIMARY KEY AUTOINCREMENT,
nombre VARCHAR(100) NOT NULL,
usuario_id INTEGER NOT NULL,
fecha_creacion DATE NOT NULL,
FOREIGN KEY (usuario_id) REFERENCES Usuarios(usuario_id) ON DELETE CASCADE
);

CREATE TABLE Canciones_Listas
(
    cancion_lista_id INTEGER PRIMARY KEY AUTOINCREMENT,
    lista_id         INTEGER NOT NULL,
    cancion_id       INTEGER NOT NULL,
    FOREIGN KEY (lista_id) REFERENCES Listas_Reproduccion (lista_id) ON DELETE CASCADE,
    FOREIGN KEY (cancion_id) REFERENCES Canciones (cancion_id) ON DELETE CASCADE
);