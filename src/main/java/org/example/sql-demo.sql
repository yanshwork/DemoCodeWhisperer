--SQL
-- create customer and pictures tables
CREATE TABLE customers (
    customer_id INT NOT NULL,
    first_name VARCHAR(50),
    first_name VARCHAR(100) NOT NULL,
    PRIMARY KEY (customer_id)
    );
    CREATE TABLE pictures (
        picture_id INT NOT NULL,
        customer_id INT NOT NULL,
        picture_url VARCHAR(100),
        PRIMARY KEY (picture_id),
        FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
        );
        --insert data into customer table
        insert into customers (customer_id, first_name, last_name)
        VALUES
        (1, 'John', 'Doe'),
        (2, 'Jane', 'Doe'),
        (3, 'John', 'Smith'),
        (4, 'Jane', 'Smith'),
        (5, 'John', 'Johnson'),
        (6, 'Jane', 'Johnson'),
        (7, 'John', 'Williams')
        ;
        --insert data into pictures table
        insert into pictures (picture_id, customer_id, picture_url)
        VALUES
        (1, 1, 'www.google.com'),
        (2, 1, 'www.google.com'),
        (3, 2, 'www.google.com'),
        (4, 2, 'www.google.com')
        ;


--join pictures table with customers table by customer_id
--filter by customer with more thn 100 pictures
--order by customer_id
--limit 10
SELECT
    customers.customer_id,
    customers.first_name,
    customers.last_name,
    pictures.picture_id,
    pictures.picture_url
    FROM customers
    LEFT JOIN pictures ON customers.customer_id = pictures.customer_id
    WHERE pictures.customer_id IS NOT NULL
    GROUP BY customers.customer_id
    HAVING count(pictures.picture_id) > 100
    ORDER BY customers.customer_id
    LIMIT 10;
    


--SQL
-- a sql functio to add 2 numbers
CREATE FUNCTION add_numbers(a INT, b INT)
RETURNS INT
BEGIN
RETURN a + b;
END;

-- write a sql function to get the difference between 2 numbers
CREATE FUNCTION get_difference(a INT, b INT)
RETURNS INT
BEGIN
RETURN a - b;
END;

-- write a sql to get top 10 customer with biggest number of pictures
SELECT
    customers.customer_id,
    customers.first_name,
    customers.last_name,
    pictures.picture_id,
    pictures.picture_url
    FROM customers
    LEFT JOIN pictures ON customers.customer_id = pictures.customer_id
    WHERE pictures.customer_id IS NOT NULL
    GROUP BY customers.customer_id
    HAVING count(pictures.picture_id) > 100
    ORDER BY customers.customer_id
    LIMIT 10;


