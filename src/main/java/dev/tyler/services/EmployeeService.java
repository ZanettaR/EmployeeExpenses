package dev.tyler.services;

import dev.tyler.entities.Employee;
import dev.tyler.entities.Expense;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    boolean deleteEmployee(int id);
    Employee getEmployee(int id);
    boolean addEmployeeExpense(Expense expense);
    List<Employee> employees();
    List<Expense> employeeExpenseLogs(int id);
}
