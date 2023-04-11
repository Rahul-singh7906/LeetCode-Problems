# Write your MySQL query statement below
select firstName,lastName,city,state from Person as p
LEFT JOIN Address as a ON p.personId=a.personId;