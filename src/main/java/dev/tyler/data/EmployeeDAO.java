package dev.tyler.data;

import dev.tyler.entities.Employee;
import dev.tyler.entities.Expense;

import java.util.List;

public interface EmployeeDAO {

    Employee createEmployee(Employee employee);

    Employee getEmployeeById(int id);

    Employee updateEmployee(Employee employee);

    boolean deleteEmployeeById(int id);

    List<Employee> getAllEmployees();

    List<Expense> getEmployeeExpenses(int id);
}
