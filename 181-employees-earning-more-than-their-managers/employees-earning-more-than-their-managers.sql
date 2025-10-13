# Write your MySQL query statement below
SELECT a.Name as Employee
FROM Employee as a
JOIN Employee as b
ON a.managerid = b.id
AND a.salary > b.salary