# Write your MySQL query statement below
SELECT p.FirstName, p.LastName, a.City, a.State
FROM Person AS p
LEFT OUTER JOIN Address AS a
ON p.PersonId = a.PersonId

