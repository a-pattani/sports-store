-- Create database if it does not exist
CREATE DATABASE IF NOT EXISTS mysportsonlinestore;

-- Create a new user with a specified password
CREATE USER IF NOT EXISTS 'user'@'%' IDENTIFIED BY 'password';

-- Grant all privileges on the new database to the new user
GRANT ALL PRIVILEGES ON mysportsonlinestore.* TO 'user'@'%';

-- Flush the privileges to ensure they are applied
FLUSH PRIVILEGES;

-- Switch to the created database
USE mysportsonlinestore;

-- Create users table
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

-- Create products table
CREATE TABLE IF NOT EXISTS products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL
);

-- Insert data into products table
INSERT INTO products (name, description, price)
VALUES ('Football', 'Description of Product1', 300.00),
       ('Sportsball', 'Description of Product2', 550.00);

INSERT INTO users (username, password, email)
VALUES ('root', 'root', 'root@root.com');