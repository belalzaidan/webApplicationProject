CREATE TABLE reservations (
  id int AUTO_INCREMENT NOT NULL PRIMARY KEY,
  nameOfCustomer varchar(255),
  email varchar(255),
  phone varchar(255),
  tableOfCustomer Integer,
  item varchar(255)
);

CREATE TABLE person (
    id int AUTO_INCREMENT NOT NULL PRIMARY KEY,
    username varchar(255),
    password varchar(255)
);