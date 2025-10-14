# Write your MySQL query statement below


-- SELECT c.name as customers
-- FROM customers as c
-- LEFT JOIN orders as o
-- WHERE o.customerid is null

SELECT name as customers
FROM customers
WHERE id NOT IN (select customerid from orders)