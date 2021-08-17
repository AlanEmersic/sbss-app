INSERT INTO CustomerDetails (firstName, lastName, phone)
VALUES ('Ivo', 'Ivić', '0991234567'),
       ('Pero', 'Perić', '0951234567'),
       ('Ana', 'Banana', '0961234567'),
       ('Petra', 'Perić', '0981234567');

INSERT INTO Customer (username, customerDetailsId)
VALUES ('iivic', 1),
       ('pperic', 2),
       ('abanana', 3),
       ('pperic', 4);

INSERT INTO Delivery (submissionDate, customerId)
VALUES ('2021-02-25', 1),
       ('2021-08-14', 2),
       ('2021-06-04', 3),
       ('2021-08-20', 4);

INSERT INTO Pizza (name, ingredients)
VALUES ('Margherita', 'Tomato'),
       ('Margherita', 'Mozzarella'),
       ('Quattro Stagioni', 'Tomato'),
       ('Carbonara', 'Tomato');

INSERT INTO PizzaOrder (quantity, size, pizzaId, deliveryId)
VALUES ('2', 'MEDIUM', 1, 1),
       ('5', 'SMALL', 2, 2),
       ('1', 'LARGE', 4, 4),
       ('3', 'MEDIUM', 3, 4);

INSERT INTO Ingredient (ingredients, pizzaId)
VALUES ('Tomato', 1),
       ('Mozzarella', 2),
       ('Tomato', 3),
       ('Tomato', 4);
