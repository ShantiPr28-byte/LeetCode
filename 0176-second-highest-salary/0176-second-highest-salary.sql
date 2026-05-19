# Write your MySQL query statement below
WITH salary_rank AS (
    SELECT DISTINCT salary
    FROM Employee
)

SELECT MAX(salary) AS SecondHighestSalary
FROM salary_rank
WHERE salary < (
    SELECT MAX(salary)
    FROM salary_rank
);