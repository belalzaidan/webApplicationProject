CREATE TABLE bestillinger (
  id int AUTO_INCREMENT NOT NULL PRIMARY KEY,
  navn varchar(255),
  epost varchar(255),
  telefon varchar(255),
  vare integer,
  bord varchar(255)
);

CREATE TABLE person (
    id int AUTO_INCREMENT NOT NULL PRIMARY KEY,
    username varchar(255),
    password varchar(255)
)