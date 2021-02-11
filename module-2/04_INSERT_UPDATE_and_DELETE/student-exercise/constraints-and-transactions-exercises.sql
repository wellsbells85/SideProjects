-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
INSERT INTO actor(actor_id, first_name, last_name)
VALUES(DEFAULT, 'HAMPTON', 'AVENUE'), (DEFAULT, 'LISA', 'BYWAY')
; 
-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.
INSERT INTO film(film_id, title, description, release_year, language_id, original_language_id, 
        rental_duration, rental_rate, length, replacement_cost, rating)
VALUES(DEFAULT, 'Euclidean PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece',
        2008, (SELECT language_id FROM language WHERE name = 'English') , DEFAULT, DEFAULT, DEFAULT, 198, DEFAULT, DEFAULT)
;
-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.
INSERT INTO film_actor(film_id, actor_id)
VALUES  ((SELECT film_id FROM film WHERE title = 'Euclidean PI'), (SELECT actor_id FROM actor WHERE first_name = 'LISA' AND last_name = 'BYWAY')),
        ((SELECT film_id FROM film WHERE title = 'Euclidean PI'), (SELECT actor_id FROM actor WHERE first_name = 'HAMPTON' AND last_name = 'AVENUE'))
;
-- 4. Add Mathmagical to the category table.
INSERT INTO category VALUES(DEFAULT, 'Mathmagical')
;
-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
INSERT INTO film_category(film_id, category_id)
VALUES  ((SELECT film_id FROM film WHERE title = 'Euclidean PI'), (SELECT category_id FROM category WHERE name = 'Mathmagical')),
        ((SELECT film_id FROM film WHERE title = 'EGG IGBY'), (SELECT category_id FROM category WHERE name = 'Mathmagical')),
        ((SELECT film_id FROM film WHERE title = 'KARATE MOON'), (SELECT category_id FROM category WHERE name = 'Mathmagical')),
        ((SELECT film_id FROM film WHERE title = 'RANDOM GO'), (SELECT category_id FROM category WHERE name = 'Mathmagical')),
        ((SELECT film_id FROM film WHERE title = 'YOUNG LANGUAGE'), (SELECT category_id FROM category WHERE name = 'Mathmagical'))
;
-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)
UPDATE film
SET rating = 'G'
WHERE film_id IN  
        ( 
        SELECT film_id
        FROM film f
        INNER JOIN film_category fc USING(film_id)
        INNER JOIN category c USING(category_id)
        WHERE name = 'Mathmagical'
        )        
;
-- 7. Add a copy of "Euclidean PI" to all the stores.
INSERT INTO inventory(inventory_id, film_id, store_id)
VALUES  (DEFAULT, (SELECT film_id FROM film WHERE title = 'Euclidean PI'), (SELECT store_id FROM store LIMIT 1)),
        (DEFAULT, (SELECT film_id FROM film WHERE title = 'Euclidean PI'), (SELECT store_id FROM store LIMIT 1 OFFSET 1))
;
-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
DELETE FROM film
WHERE title = 'Euclidean PI'
;
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>

--      No, there is referencial integrity enforced by the actors that are listed as part of the cast in film_actor table.

-- 9. Delete Mathmagical from the category table.
DELETE FROM category
WHERE name = 'Mathmagical'
;
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>

--      No, there is referencial integrity enforced by the films that are in that category in the film_category table.

-- 10. Delete all links to Mathmagical in the film_category tale.
DELETE FROM film_category
WHERE category_id IN
        (
        SELECT category_id
        FROM category
        WHERE name = 'Mathmagical'
        )
;
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>

--      Yes, this is where the integrity of the category was enforced. The link is now broken, separating the films from this respective category.

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
DELETE FROM category
WHERE name = 'Mathmagical'
;

DELETE FROM film
WHERE title = 'Euclidean PI'
;
-- (Did either deletes succeed? Why?)
-- <YOUR ANSWER HERE>

--      Mathmagical is now deleted because the integrity is broken. However, until the cast is removed from film_actor, the movie cannot be deleted.

-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.
DELETE FROM film_actor
WHERE film_id IN 
        (
        SELECT film_id
        FROM film
        WHERE title = 'Euclidean PI'
        )
;
        -- PREVIOUS COMMAND REMOVES THE FILM FROM film_actor TABLE, UNENFORCING CAST INTEGRITY
        
DELETE FROM inventory
WHERE film_id IN 
        (
        SELECT film_id
        FROM film
        WHERE title = 'Euclidean PI'
        )
;
        -- PREVIOUS COMMAND REMOVES THE FILM FROM inventory TABLE, UNENFORCING STORE and RENTAL INTEGRITY
        
DELETE FROM film
WHERE title = 'Euclidean PI'
;
        -- PREVIOUS COMMAND REMOVES THE FILM FROM film TABLE
        
SELECT *
FROM film
ORDER BY film_id DESC
;
        -- CONFIRMS THAT THE MOST RECENT film_id DOES NOT BELONG TO 'Euclidean PI'