CREATE DATABASE IF NOT EXISTS customer_management;
USE customer_management;

CREATE TABLE customers (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           age INT NOT NULL,
                           email VARCHAR(255) NOT NULL,
                           location VARCHAR(255) NOT NULL
);

INSERT INTO customers (name, age, email, location)
VALUES ('Alice Smith', 30, 'alice@example.com', 'Toronto'),
       ('Bob Johnson', 40, 'bob@example.com', 'New York'),
       ('Carol Williams', 22, 'carol@example.com', 'Los Angeles'),
       ('David Brown', 35, 'david@example.com', 'Miami'),
       ('Eve Davis', 28, 'eve@example.com', 'San Francisco');
