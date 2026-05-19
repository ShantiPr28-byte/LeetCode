# Write your MySQL query statement below
WITH dept_max AS (
    SELECT departmentId, MAX(salary) AS max_salary
    FROM Employee
    GROUP BY departmentId
)

SELECT d.name AS Department,
       e.name AS Employee,
       e.salary AS Salary
FROM Employee e
JOIN dept_max dm
ON e.departmentId = dm.departmentId
AND e.salary = dm.max_salary
JOIN Department d
ON e.departmentId = d.id;