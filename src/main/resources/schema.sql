CREATE TABLE Reservations (
  id int AUTO_INCREMENT NOT NULL PRIMARY KEY,
  name_Of_Customer varchar(255),
  email varchar(255),
  phone varchar(255),
  table_Of_Customer Integer,
  item varchar(255)
);

CREATE TABLE person (
    id int AUTO_INCREMENT NOT NULL PRIMARY KEY,
    username varchar(255),
    password varchar(255)
);