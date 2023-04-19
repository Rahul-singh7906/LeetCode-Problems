# Write your MySQL query statement below
select unique_id,name from EmployeeUNI as e right join
Employees as emp on e.id=emp.id;