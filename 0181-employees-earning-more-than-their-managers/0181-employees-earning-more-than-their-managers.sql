# Write your MySQL query statement below
Select a.name as Employee 
from Employee as a JOIN Employee as b
ON a.managerId=b.id
and a.salary>b.salary