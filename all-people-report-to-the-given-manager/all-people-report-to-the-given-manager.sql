# Write your MySQL query statement below
Select distinct a.employee_id
From Employees a, Employees b, Employees c
Where a.manager_id = b.employee_id
and b.manager_id = c.employee_id
and c.manager_id = 1
and a.manager_id != a .employee_id