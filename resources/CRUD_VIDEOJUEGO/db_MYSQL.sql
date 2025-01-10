-- Eliminar la base de datos si existe
DROP DATABASE IF EXISTS ejercicios_novato;

-- Crear la base de datos
CREATE DATABASE ejercicios_novato;

-- Usar la base de datos
USE ejercicios_novato;

-- Crear la tabla VIDEOJUEGOS
CREATE TABLE VIDEOJUEGOS (
    NOMBRE VARCHAR(50) NOT NULL UNIQUE,
    PLATAFORMA VARCHAR(20) NOT NULL,
    DURACION INT NOT NULL CHECK (DURACION >= 0),
    RECOMENDABLE TINYINT(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB 
  CHARACTER SET utf8mb4 
  COLLATE utf8mb4_spanish2_ci;

-- Insertar registros de ejemplo
INSERT INTO VIDEOJUEGOS (NOMBRE, PLATAFORMA, DURACION, RECOMENDABLE) VALUES
('The Witcher 3', 'PC', 50, 1),
('Halo Infinite', 'Xbox', 15, 1),
('God of War', 'PlayStation', 30, 1),
('Celeste', 'Switch', 8, 1),
('Cyberpunk 2077', 'PC', 60, 0),
('The Last of Us', 'PlayStation', 25, 1),
('Minecraft', 'Multiplataforma', 100, 0),
('Call of Duty', 'PC', 20, 0),
('Stardew Valley', 'Switch', 50, 1),
('Elden Ring', 'PC', 80, 1),
('Street Fighter V', 'PC', 10, 1),           -- Juego de peleas competitivo
('FIFA 23', 'Multiplataforma', 20, 1),      -- Deporte, fútbol
('Hollow Knight', 'Switch', 40, 1),         -- Indie de aventura y acción
('GTA V', 'Multiplataforma', 60, 1),        -- Acción y mundo abierto
('League of Legends', 'PC', 100, 0),        -- MOBA, tiempo infinito
('Among Us', 'Multiplataforma', 5, 0),      -- Juego social y de estrategia
('Cuphead', 'PC', 15, 1),                   -- Estilo retro, desafiante
('Sekiro', 'PC', 50, 1),                    -- Juego de acción y dificultad alta
('Clash Royale', 'Móvil', 5, 1),            -- Juego móvil competitivo
('Tetris', 'Multiplataforma', 2, 1);        -- Clásico atemporal