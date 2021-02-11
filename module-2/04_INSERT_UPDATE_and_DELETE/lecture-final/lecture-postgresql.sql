-- INSERT
-- 1. Add Klingon as a spoken language in the USA
SELECT * FROM countrylanguage;
INSERT INTO countrylanguage (language, percentage, isofficial, countrycode) 
VALUES ('Klingon', 0.1, false, 'USA'); 

-- 2. Add Klingon as a spoken language in Great Britain (GBR)
INSERT INTO countrylanguage VALUES ('GBR', 'Klingon 2', false, 0.2) , ('GBR', 'Klingon 3', false, 0.1);


-- UPDATE
-- 1. Update the capital of the USA to Houston
SELECT city.name || ', ' || city.district || ' is the capital of ' || country.name
FROM city INNER JOIN country ON city.id = country.capital
WHERE country.code = 'USA';

SELECT * FROM country WHERE code = 'USA';

UPDATE country 
SET capital = (SELECT id FROM city WHERE name = 'Pittsburgh')
WHERE code = 'USA';

SELECT id FROM city WHERE name = 'Houston';
-- Washington: 3813
-- Houston: 3796

-- 2. Update the capital of the USA to Washington DC and the head of state
UPDATE country
SET headofstate = 'Jennifer O''Brien', capital = 3813
WHERE code = 'USA';

-- DELETE
-- 1. Delete English as a spoken language in the USA
SELECT * FROM countrylanguage WHERE countrycode = 'USA';
DELETE FROM countrylanguage WHERE countrycode = 'USA' AND language = 'English';

-- 2. Delete all occurrences of the Klingon language 
SELECT * FROM countrylanguage WHERE language LIKE 'Klingon%';
DELETE FROM countrylanguage WHERE language LIKE 'Klingon%';

SELECT * FROM countrylanguage WHERE language = 'English';

DELETE FROM countrylanguage WHERE language = 'English';
DELETE FROM countrylanguage WHERE countrycode = 'USA';

DELETE FROM countrylanguage ;

SELECT * FROM countrylanguage;



INSERT INTO city (id, name, countrycode, district, population) VALUES (0, '', '', '', 0);
UPDATE city SET id = 0, name = '', countrycode = '', district = '', population = 0 WHERE id = <condition>;



-- REFERENTIAL INTEGRITY
-- 1. Try just adding Elvish to the country language table.
SELECT * FROM countrylanguage;

INSERT INTO countrylanguage (language) VALUES ('Elvish');
-- INSERT INTO countrylanguage (countrycode, language, isofficial, percentage ) VALUES (DEFAULT, 'Elvish', DEFAULT, DEFAULT);

-- 2. Try inserting English as a spoken language in the country ZZZ. What happens?
INSERT INTO countrylanguage (countrycode, language, isofficial, percentage) 
                     VALUES ('ZZZ',        'English',   true ,   99.0);

SELECT * FROM country WHERE code = 'ZZZ';

-- 3. Try deleting the country USA. What happens?

DELETE FROM country WHERE code = 'USA';

-- CONSTRAINTS

--NOT NULL
--UNIQUE
--PRIMARY KEY - allows FKs to establish a relationship, and enforces NOT NULL and UNIQUE,
--FOREIGN KEY - enforces valid PK values, and limits deletion of the PK row if FK row exists
--CHECK - specifies acceptable values that can be entered in the column
--DEFAULT - provides a default value for the column





-- 1. Try inserting English as a spoken language in the USA
INSERT INTO countrylanguage VALUES ('USA', 'English', true, 100.0);

-- 2. Try again. What happens?


-- 3. Let's relocate the USA to the continent - 'Outer Space'
SELECT DISTINCT continent FROM country; --WHERE code = 'USA';
UPDATE country
SET continent = 'Outer Space'
WHERE code = 'USA';



-- How to view all of the constraints
SELECT pg_constraint.*
FROM pg_catalog.pg_constraint
INNER JOIN pg_catalog.pg_class ON pg_class.oid = pg_constraint.conrelid
INNER JOIN pg_catalog.pg_namespace ON pg_namespace.oid = connamespace;


-- TRANSACTIONS
-- 1. Try deleting all of the rows from the country language table and roll it back.
DELETE FROM countrylanguage;

-- 2. Try updating all of the cities to be in the USA and roll it back

UPDATE city SET countrycode = 'USA';

SELECT * FROM city;
SELECT * FROM countrylanguage;




-- 3. Demonstrate two different SQL connections trying to access the same table 
--    where one happens to be inside of a transaction but hasn't committed yet.

UPDATE country SET headofstate = 'Tom Medvitz';

SELECT name, headofstate FROM country;

COMMIT;
