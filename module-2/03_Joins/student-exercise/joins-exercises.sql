-- The following queries utilize the "dvdstore" database.

-- 1. All of the films that Nick Stallone has appeared in
-- (30 rows)
SELECT f.title
FROM film f
INNER JOIN film_actor fa USING(film_id)
INNER JOIN actor a USING(actor_id)
WHERE a.first_name = 'NICK' AND a.last_name = 'STALLONE'
;
-- 2. All of the films that Rita Reynolds has appeared in
-- (20 rows)
SELECT f.title
FROM film f
INNER JOIN film_actor fa USING(film_id)
INNER JOIN actor a USING(actor_id)
WHERE a.first_name = 'RITA' AND a.last_name = 'REYNOLDS'
;
-- 3. All of the films that Judy Dean or River Dean have appeared in
-- (46 rows)
SELECT f.title, a.first_name
FROM film f
INNER JOIN film_actor fa USING(film_id)
INNER JOIN actor a USING(actor_id)
WHERE a.first_name IN ('JUDY', 'RIVER') AND a.last_name = 'DEAN'
;
-- 4. All of the the ‘Documentary’ films
-- (68 rows)
SELECT f.title
FROM film f
INNER JOIN film_category USING(film_id)
INNER JOIN category c USING(category_id)
WHERE c.name = 'Documentary'
;
-- 5. All of the ‘Comedy’ films
-- (58 rows)
SELECT f.title
FROM film f
INNER JOIN film_category USING(film_id)
INNER JOIN category c USING(category_id)
WHERE c.name = 'Comedy'
;
-- 6. All of the ‘Children’ films that are rated ‘G’
-- (10 rows)
SELECT f.title
FROM film f
INNER JOIN film_category USING(film_id)
INNER JOIN category c USING(category_id)
WHERE c.name = 'Children' AND f.rating = 'G'
;
-- 7. All of the ‘Family’ films that are rated ‘G’ and are less than 2 hours in length
-- (3 rows)
SELECT f.title
FROM film f
INNER JOIN film_category USING(film_id)
INNER JOIN category c USING(category_id)
WHERE c.name = 'Family' AND f.rating = 'G' AND f.length < 120
;
-- 8. All of the films featuring actor Matthew Leigh that are rated ‘G’
-- (9 rows)
SELECT f.title
FROM actor a
INNER JOIN film_actor fa USING(actor_id)
INNER JOIN film f USING(film_id)
INNER JOIN film_category fc USING(film_id)
INNER JOIN category c USING(category_id)
WHERE f.rating = 'G' AND a.first_name = 'MATTHEW' AND a.last_name = 'LEIGH'
;
-- 9. All of the ‘Sci-Fi’ films released in 2006
-- (61 rows)
SELECT f.title
FROM film f
INNER JOIN film_category fc USING(film_id)
INNER JOIN category c USING(category_id)
WHERE f.release_year = 2006 AND c.name = 'Sci-Fi'
;
-- 10. All of the ‘Action’ films starring Nick Stallone
-- (2 rows)
SELECT f.title
FROM actor a
INNER JOIN film_actor fa USING(actor_id)
INNER JOIN film f USING(film_id)
INNER JOIN film_category fc USING(film_id)
INNER JOIN category c USING(category_id)
WHERE a.first_name = 'NICK' AND a.last_name = 'STALLONE' AND c.name = 'Action'
;
-- 11. The address of all stores, including street address, city, district, and country
-- (2 rows)
SELECT a.address, c.city, a.district, co.country
FROM store s
INNER JOIN address a USING(address_id)
INNER JOIN city c USING(city_id)
INNER JOIN country co USING(country_id)
;
-- 12. A list of all stores by ID, the store’s street address, and the name of the store’s manager
-- (2 rows)
SELECT store_id, address, first_name || ' ' || last_name AS store_manager
FROM address a
INNER JOIN store USING(address_id)
INNER JOIN staff USING(store_id)
WHERE store.manager_staff_id = staff.staff_id
;
-- 13. The first and last name of the top ten customers ranked by number of rentals 
-- (#1 should be “ELEANOR HUNT” with 46 rentals, #10 should have 39 rentals)
SELECT c.first_name || ' ' || c.last_name AS customer_name, COUNT(rental_id) AS rentals
FROM customer c
INNER JOIN rental r USING(customer_id)
GROUP BY customer_id
ORDER BY rentals DESC LIMIT 10
;
-- 14. The first and last name of the top ten customers ranked by dollars spent 
-- (#1 should be “KARL SEAL” with 221.55 spent, #10 should be “ANA BRADLEY” with 174.66 spent)
SELECT c.first_name || ' ' || c.last_name AS customer_name, SUM(amount) AS dollars_spent
FROM customer c
INNER JOIN payment p USING(customer_id)
GROUP BY customer_id
ORDER BY dollars_spent DESC LIMIT 10
;
-- 15. The store ID, street address, total number of rentals, total amount of sales (i.e. payments), and average sale of each store.
-- (NOTE: Keep in mind that an employee may work at multiple stores.)
-- (Store 1 has 7928 total rentals and Store 2 has 8121 total rentals)
SELECT store_id, address, COUNT(p.amount) AS number_rentals, SUM(p.amount) AS sales_in_dollars, ROUND(AVG(p.amount)::numeric, 2) AS avg_sales
FROM payment p
INNER JOIN rental r USING(rental_id)
INNER JOIN inventory i USING(inventory_id)
INNER JOIN store s USING(store_id)
INNER JOIN address a USING(address_id)
GROUP BY store_id, address
ORDER BY store_id
;
-- 16. The top ten film titles by number of rentals
-- (#1 should be “BUCKET BROTHERHOOD” with 34 rentals and #10 should have 31 rentals)
SELECT f.title, COUNT(rental_id) AS rentals
FROM film f
INNER JOIN inventory i USING(film_id)
INNER JOIN rental r USING(inventory_id)
GROUP BY film_id
ORDER BY rentals DESC LIMIT 10
;
-- 17. The top five film categories by number of rentals 
-- (#1 should be “Sports” with 1179 rentals and #5 should be “Family” with 1096 rentals)
SELECT c.name, COUNT(rental_id) AS rentals
FROM rental r
INNER JOIN inventory i USING(inventory_id)
INNER JOIN film f USING(film_id)
INNER JOIN film_category fc USING(film_id)
INNER JOIN category c USING(category_id)
GROUP BY c.name
ORDER BY rentals DESC LIMIT 5
;
-- 18. The top five Action film titles by number of rentals 
-- (#1 should have 30 rentals and #5 should have 28 rentals)
SELECT f.title, COUNT(rental_id) AS rentals
FROM rental r
INNER JOIN inventory i USING(inventory_id)
INNER JOIN film f USING(film_id)
INNER JOIN film_category fc USING(film_id)
INNER JOIN category c USING(category_id)
WHERE c.name = 'Action'
GROUP BY title
ORDER BY rentals DESC LIMIT 5
;
-- 19. The top 10 actors ranked by number of rentals of films starring that actor 
-- (#1 should be “GINA DEGENERES” with 753 rentals and #10 should be “SEAN GUINESS” with 599 rentals)
SELECT a.first_name || ' ' || a.last_name AS actor_name , COUNT(rental_id) AS rentals
FROM actor a
INNER JOIN film_actor fa USING(actor_id)
INNER JOIN film f USING(film_id)
INNER JOIN inventory i USING(film_id)
INNER JOIN rental r USING(inventory_id)
GROUP BY actor_id
ORDER BY rentals DESC LIMIT 10
;
-- 20. The top 5 “Comedy” actors ranked by number of rentals of films in the “Comedy” category starring that actor 
-- (#1 should have 87 rentals and #5 should have 72 rentals)
SELECT a.first_name || ' ' || a.last_name AS actor_name , COUNT(rental_id) AS rentals
FROM actor a
INNER JOIN film_actor fa USING(actor_id)
INNER JOIN film f USING(film_id)
INNER JOIN inventory i USING(film_id)
INNER JOIN rental r USING(inventory_id)
WHERE f.film_id IN 
                (       
                SELECT film_id
                FROM film_category
                INNER JOIN category c USING(category_id)
                WHERE c.name = 'Comedy'         
                )
GROUP BY actor_id
ORDER BY rentals DESC LIMIT 5
;