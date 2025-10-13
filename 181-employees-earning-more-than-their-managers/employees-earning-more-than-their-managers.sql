# Write your MySQL query statement below
SELECT a.Name as Employee
FROM Employee as a
JOIN Employee as b
ON a.managerId = b.Id
AND a.salary > b.salary