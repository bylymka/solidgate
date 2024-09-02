CREATE DATABASE solidgate;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    balance INTEGER NOT NULL DEFAULT 0
);

INSERT INTO users(name) VALUES('Kate');
INSERT INTO users(name) VALUES('Vadym');
INSERT INTO users(name) VALUES('Bob');
INSERT INTO users(name) VALUES('Alex');
INSERT INTO users(name) VALUES('Dan');
INSERT INTO users(name) VALUES('Mary');
INSERT INTO users(name) VALUES('Sam');


