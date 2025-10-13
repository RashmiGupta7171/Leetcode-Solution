/* Write your T-SQL query statement below */


SELECT p.firstname,p.lastname,a.state,a.city
FROM person as p
LEFT JOIN address as a
ON p.personid = a.personid