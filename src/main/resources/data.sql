INSERT INTO Customers (voornaam, achternaam, telefoonnummer)
VALUES ('Jesse', 'Mulder', '0612345678'),('henk', 'hallo', '0623456789');

INSERT INTO Car (merk, autotype, bouwjaar, km_Stand)
VALUES ('ford', 'focus', '2005', '115.000'),('toyota', 'supra', '1998', '154.000'),('dodge', 'ram1500', '2017', '112.000'),('toyota', 'supra', '2020', '60.000');

INSERT INTO Part (onderdeel, prijs, reparatieduur)
VALUES ('remschijf', '35', '30'), ('band', '300', '20'), ('koelvloeistof', '10', '5'), ('uitlaat', '700', '240');

INSERT INTO users (username, apikey, email, enabled, password)
VALUES ('jesse200370', '', 'jesse200370@gmail.com', 'true', 'password');

INSERT INTO customer_car (customer_id, car_id)
VALUES ('1', '1');

INSERT INTO authorities (authority, username)
VALUES ('ADMIN', 'jesse200370');

