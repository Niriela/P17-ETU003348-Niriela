CREATE DATABASE depenses;

USE depenses;

CREATE TABLE depenses_credit(
    id_credit INT AUTO_INCREMENT PRIMARY KEY,
    libelle VARCHAR(250),
    montant DECIMAL(10,2)
);

CREATE TABLE depenses_depenses(
    id_depenses INT AUTO_INCREMENT PRIMARY KEY,
    id_credit INT REFERENCES depenses_credit(id_credit),
    montant DECIMAL(10,2)
);

