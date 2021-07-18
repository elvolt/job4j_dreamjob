CREATE TABLE IF NOT EXISTS post
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(100),
    description TEXT,
    created     DATE
);

CREATE TABLE IF NOT EXISTS candidate
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS users
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(100),
    email    VARCHAR(100),
    password VARCHAR(100)
);