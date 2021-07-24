CREATE TABLE IF NOT EXISTS post
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(100),
    description TEXT,
    created     DATE
);

CREATE TABLE IF NOT EXISTS city
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE
);

CREATE TABLE IF NOT EXISTS candidate
(
    id      SERIAL PRIMARY KEY,
    name    VARCHAR(100),
    city_id INTEGER REFERENCES city (id)
);

CREATE TABLE IF NOT EXISTS users
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(100),
    email    VARCHAR(100) UNIQUE,
    password VARCHAR(100)
);

INSERT INTO city (name)
VALUES ('Москва'),
       ('Санкт-Петербург'),
       ('Екатеринбург'),
       ('Воронеж'),
       ('Новосибирск'),
       ('Нижний Новгород'),
       ('Другой')
ON CONFLICT DO NOTHING;