INSERT INTO artist
VALUES  (DEFAULT, 'Nick', 'Great-One')
;

INSERT INTO art
VALUES  (DEFAULT, 'The Artiste', 3),
        (DEFAULT, DEFAULT, 3)
;

BEGIN TRANSACTION;

DROP TABLE IF EXISTS purchase;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS art;
DROP TABLE IF EXISTS artist;


CREATE TABLE customer 
(
        customer_id serial primary key,
        first_name varchar(100) not null,
        last_name varchar(100) not null,
        address varchar(200) null,
        phone varchar(20) null
);

CREATE TABLE artist 
(
        artist_id serial primary key,
        first_name varchar(100) not null,
        last_name varchar(100) null
);

CREATE TABLE art
(
        art_id serial,
        title varchar(300) default 'Untitled' not null,
        artist_id int not null,
        
        constraint pk_art primary key (art_id),
        constraint fk_art_artist foreign key (artist_id) references artist (artist_id)
);

CREATE TABLE purchase
(
        customer_id int not null,
        art_id int not null,
        price money not null,
        purchase_date timestamp not null,
        
        constraint pk_purchase primary key (customer_id, art_id, purchase_date),
        constraint fk_purchase_customer foreign key (customer_id) references customer (customer_id),
        constraint fk_purchase_art foreign key (art_id) references art (art_id)
);

COMMIT;