package service;

import model.Employee;

import java.util.List;

public interface EmployeeDao {
   void add (Employee employee);
    Employee getById(int id);
    List<Employee> getAllEmployee();
    void deleteEmployee(int id);
    void updateEmployee(int id, Employee employee);
}

