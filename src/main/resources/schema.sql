DROP TABLE IF EXISTS CustomerDetails;
CREATE TABLE CustomerDetails
(
    id        NUMBER PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(255),
    lastName  VARCHAR(255),
    phone     VARCHAR(255)
);

DROP TABLE IF EXISTS Customer;
CREATE TABLE Customer
(
    id                NUMBER PRIMARY KEY AUTO_INCREMENT,
    username          VARCHAR(255),
    customerDetailsId NUMBER
);

DROP TABLE IF EXISTS Delivery;
CREATE TABLE Delivery
(
    id             NUMBER PRIMARY KEY AUTO_INCREMENT,
    submissionDate DATE,
    customerId     NUMBER
);

DROP TABLE IF EXISTS Pizza;
CREATE TABLE Pizza
(
    id          NUMBER PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(255),
    ingredients VARCHAR(255)
);

DROP TABLE IF EXISTS PizzaOrder;
CREATE TABLE PizzaOrder
(
    id         NUMBER PRIMARY KEY AUTO_INCREMENT,
    quantity   VARCHAR(255),
    size       VARCHAR(255),
    pizzaId    NUMBER,
    deliveryId NUMBER
);

DROP TABLE IF EXISTS Ingredient;
CREATE TABLE Ingredient
(
    id          NUMBER PRIMARY KEY AUTO_INCREMENT,
    ingredients VARCHAR(255),
    pizzaId     NUMBER
);