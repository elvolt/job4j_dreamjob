CREATE TABLE post
(
    id          SERIAL PRIMARY KEY ,
    name        VARCHAR(100),
    description TEXT,
    created     DATE
);

CREATE TABLE candidate
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100)
);