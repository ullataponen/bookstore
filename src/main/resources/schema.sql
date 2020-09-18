DROP TABLE book;
DROP TABLE category;

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

INSERT INTO category (name) VALUES ("fantasy"), ("horror"), ("sci-fi"), ("non-fiction"), ("comic");

INSERT INTO book (title, author, isbn, price, year, category_id)
VALUES ("It", "Stephen King", "1234156-45", 20.00, 1984, 2), 
("Lord of the Rings", "J.R.R. Tolkien", "3146878-45", 35.00, 1954, 1),
("Akira", "Otomo Katsuhiro", "111111-22", 50.00, 1985, 5);
