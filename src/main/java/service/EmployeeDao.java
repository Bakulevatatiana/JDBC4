package service;

import java.util.List;

public interface EmployeeDao {
   Integer add (Employee employee);
    Employee getById(int id);
    List<Employee> getAllEmployee();
    void deleteEmployee(Employee employee);
    void updateEmployee(int id, Employee employee);
}

