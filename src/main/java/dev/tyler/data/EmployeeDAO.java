package dev.tyler.data;

import dev.tyler.entities.Employee;
import dev.tyler.entities.Expense;

import java.util.List;

public interface EmployeeDAO {

    Employee createEmployee(Employee employee);

    Employee getEmployeeById(int id);

    Employee updateEmployee(Employee employee);

    List<Expense> getEmployeeExpenses(int id);
}
