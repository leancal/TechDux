DROP TABLE IF EXISTS users;

CREATE TABLE USERS (
    id INT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255)
);

INSERT INTO users (username, password, role, id) VALUES
('test', '$2a$10$qC2V8OPMq5LfvkdZf3rONujTtEcp7EUqR/MxgFB.M.d8zSavBGQvW', 'USER', 1);

DROP TABLE IF EXISTS EQUIPOS;

CREATE TABLE IF NOT EXISTS equipos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    liga VARCHAR(255),
    pais VARCHAR(255)
);

INSERT INTO equipos (nombre, liga, pais) VALUES
('Real Madrid', 'La Liga', 'España'),
('FC Barcelona', 'La Liga', 'España'),
('Manchester United', 'Premier League', 'Inglaterra'),
('Liverpool FC', 'Premier League', 'Inglaterra'),
('Juventus FC', 'Serie A', 'Italia'),
('AC Milan', 'Serie A', 'Italia'),
('Bayern Munich', 'Bundesliga', 'Alemania'),
('Borussia Dortmund', 'Bundesliga', 'Alemania'),
('Paris Saint-Germain', 'Ligue 1', 'Francia'),
('Olympique de Marseille', 'Ligue 1', 'Francia'),
('FC Porto', 'Primeira Liga', 'Portugal'),
('Sporting CP', 'Primeira Liga', 'Portugal'),
('Ajax Amsterdam', 'Eredivisie', 'Países Bajos'),
('Feyenoord', 'Eredivisie', 'Países Bajos'),
('Celtic FC', 'Scottish Premiership', 'Escocia'),
('Rangers FC', 'Scottish Premiership', 'Escocia'),
('Galatasaray SK', 'Süper Lig', 'Turquía'),
('Fenerbahçe SK', 'Süper Lig', 'Turquía'),
('Club América', 'Liga MX', 'México'),
('Chivas de Guadalajara', 'Liga MX', 'México'),
('LA Galaxy', 'MLS', 'Estados Unidos'),
('New York City FC', 'MLS', 'Estados Unidos');
