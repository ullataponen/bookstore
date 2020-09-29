DROP TABLE user;
DROP TABLE book;
DROP TABLE category;

CREATE TABLE user
(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(250) NOT NULL,
password_hash VARCHAR(250) NOT NULL,
email VARCHAR(250),
role VARCHAR(250) NOT NULL);

CREATE TABLE book
(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
,title VARCHAR(250) NOT NULL
,author VARCHAR(250) NOT NULL
,isbn VARCHAR(50)
,price BIGINT
, year INT
, category_id BIGINT);

CREATE TABLE category
(category_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
,name VARCHAR(50) NOT NULL);

INSERT INTO user (username, password_hash, email, role)
VALUES ("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@mail.com", "USER"),
("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@admin.fi", "ADMIN");

INSERT INTO category (name) VALUES ("fantasy"), ("horror"), ("sci-fi"), ("non-fiction"), ("comic");

INSERT INTO book (title, author, isbn, price, year, category_id)
VALUES ("It", "Stephen King", "1234156-45", 20.00, 1984, 2), 
("Lord of the Rings", "J.R.R. Tolkien", "3146878-45", 35.00, 1954, 1),
("Akira", "Otomo Katsuhiro", "111111-22", 50.00, 1985, 5);
