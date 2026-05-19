# Write your MySQL query statement below
WITH emp_manager AS (
    SELECT e.name AS Employee,
           e.salary AS emp_salary,
           m.salary AS manager_salary
    FROM Employee e
    JOIN Employee m
    ON e.managerId = m.id
)

SELECT Employee
FROM emp_manager
WHERE emp_salary > manager_salary;