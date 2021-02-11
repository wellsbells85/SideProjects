-- INSERT
-- 1. Add Klingon as a spoken language in the USA
SELECT * 
FROM countrylanguage
;

INSERT INTO countrylanguage (countrycode, language, isofficial, percentage)
        VALUES ('USA', 'Klingon', false, 0.1)
;
-- 2. Add Klingon as a spoken language in Great Britain (GBR)
INSERT INTO countrylanguage VALUES ('GBR', 'Klingon', false, 0.2)
;

-- UPDATE
-- 1. Update the capital of the USA to Houston
SELECT city.name || ' is the capital of ' || country.name
FROM city INNER JOIN country ON city.id = country.capital
WHERE country.code = 'USA'
;

UPDATE country
SET capital = 3796
WHERE code = 'USA'
;
-- 2. Update the capital of the USA to Washington DC and the head of state
UPDATE country
SET capital = (SELECT id FROM city WHERE name = 'Washington' AND district = 'District of Columbia'), headofstate = 'Joseph Biden'
WHERE code = 'USA'
;
-- DELETE
-- 1. Delete English as a spoken language in the USA
DELETE FROM countrylanguage
WHERE countrycode = 'USA' AND language = 'English'
;
-- 2. Delete all occurrences of the Klingon language 
DELETE FROM countrylanguage
WHERE language LIKE 'Klingon%'
;
-- REFERENTIAL INTEGRITY
-- 1. Try just adding Elvish to the country language table.
INSERT INTO countrylanguage (language) VALUES ('Elvish');
-- 2. Try inserting English as a spoken language in the country ZZZ. What happens?
INSERT INTO countrylanguage VALUES('ZZZ', 'English', true, 99.0);
-- 3. Try deleting the country USA. What happens?
DELETE FROM country
WHERE code = 'USA'
;
-- CONSTRAINTS
-- 1. Try inserting English as a spoken language in the USA
INSERT INTO countrylanguage VALUES('USA', 'English', true, 99.0);
-- 2. Try again. What happens?
INSERT INTO countrylanguage VALUES('USA', 'English', true, 99.0);
-- 3. Let's relocate the USA to the continent - 'Outer Space'
UPDATE country
SET continent = 'Outer Space'
WHERE code = 'USA'
;
-- How to view all of the constraints
SELECT pg_constraint.*
FROM pg_catalog.pg_constraint
INNER JOIN pg_catalog.pg_class ON pg_class.oid = pg_constraint.conrelid
INNER JOIN pg_catalog.pg_namespace ON pg_namespace.oid = connamespace;
-- TRANSACTIONS
-- 1. Try deleting all of the rows from the country language table and roll it back.

-- DELETE FROM countrylanguage;

-- 2. Try updating all of the cities to be in the USA and roll it back

-- UPDATE city SET countrycode = 'USA';
-- SELECT * FROM city;

-- 3. Demonstrate two different SQL connections trying to access the same table where one happens to be inside of a transaction but hasn't committed yet.


