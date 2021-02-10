-- ********* INNER JOIN ***********

-- Let's find out who made payment 16666:
SELECT *
FROM payment 
WHERE payment_id = 16666
;
-- Ok, that gives us a customer_id, but not the name. We can use the customer_id to get the name FROM the customer table
SELECT *
FROM payment p
JOIN customer c ON p.customer_id = c.customer_id
WHERE p.payment_id = 16666
;
-- We can see that the * pulls back everything from both tables. We just want everything from payment and then the first and last name of the customer:
SELECT p.*, c.first_name, c.last_name
FROM payment p
JOIN customer c ON p.customer_id = c.customer_id
WHERE p.payment_id = 16666
;
-- But when did they return the rental? Where would that data come from? From the rental table, so let’s join that.
SELECT r.return_date
FROM payment p
INNER JOIN customer c ON p.customer_id = c.customer_id
INNER JOIN rental r ON r.customer_id = c.customer_id
WHERE p.payment_id = 16666
;
-- What did they rent? Film id can be gotten through inventory.
SELECT f.title
FROM payment p
INNER JOIN rental r USING(rental_id)
INNER JOIN inventory i USING(inventory_id)
INNER JOIN film f USING(film_id)
WHERE p.payment_id = 16666
;
-- What if we wanted to know who acted in that film?
SELECT a.first_name, a.last_name
FROM payment p
INNER JOIN rental r USING(rental_id)
INNER JOIN inventory i USING(inventory_id)
INNER JOIN film f USING(film_id)
INNER JOIN film_actor fa USING(film_id)
INNER JOIN actor a USING(actor_id)
WHERE p.payment_id = 16666
ORDER BY a.last_name
;
-- What if we wanted a list of all the films and their categories ordered by film title
SELECT f.title, c.name
FROM film f
INNER JOIN film_category fc ON fc.film_id = f.film_id
INNER JOIN category c ON c.category_id = fc.category_id
ORDER BY f.title
;
-- Show all the 'Comedy' films ordered by film title
SELECT f.title
FROM film f
INNER JOIN film_category fc USING(film_id)
INNER JOIN category c USING(category_id)
WHERE c.name = 'Comedy'
ORDER BY f.title
;
-- Finally, let's count the number of films under each category
SELECT c.name, COUNT(*)
FROM film f
INNER JOIN film_category fc USING(film_id)
INNER JOIN category c USING(category_id)
GROUP BY c.name
ORDER BY c.name
;
-- ********* LEFT JOIN ***********

-- (There aren't any great examples of left joins in the "dvdstore" database, so the following queries are for the "world" database)

-- A Left join, selects all records from the "left" table and matches them with records from the "right" table if a matching record exists.

-- Let's display a list of all countries and their capitals, if they have some.
SELECT c.name AS city, co.name AS country
FROM country co
LEFT JOIN city c ON c.id = co.capital
ORDER BY co.name
;
-- Only 232 rows
-- But we’re missing entries:

-- There are 239 countries. So how do we show them all even if they don’t have a capital?
-- That’s because if the rows don’t exist in both tables, we won’t show any information for it. If we want to show data FROM the left side table everytime, we can use a different join:

-- *********** UNION *************

-- Back to the "dvdstore" database...

-- Gathers a list of all first names used by actors and customers
-- By default removes duplicates

-- Gather the list, but this time note the source table with 'A' for actor and 'C' for customer
