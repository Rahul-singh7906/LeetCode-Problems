# Write your MySQL query statement below
select a.Name AS 'Employee' from Employee as a,
Employee as b 
where
a.managerId=b.id and a.salary>b.salary