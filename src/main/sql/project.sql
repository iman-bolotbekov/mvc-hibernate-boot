CREATE TABLE UserTest (
    id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    age int CHECK (age > 0) NOT NULL
);
