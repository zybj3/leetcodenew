CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    DECLARE M INT;
    SET M=N-1;
    RETURN (
        # Write your MySQL query statement below.
        SELECT Salary
        FROM Employee
        GROUP BY Salary
        ORDER BY Salary DESC
        LIMIT 1 OFFSET M

    );
END




