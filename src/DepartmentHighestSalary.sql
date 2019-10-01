SELECT D.Name as Department, E.Name as Employee, E.Salary
FROM Department D, Employee E
where D.Id = E.DepartmentId
and (DepartmentId, Salary) in
    (SELECT DepartmentId, max(Salary) as max From Employee GROUP BY DepartmentId)