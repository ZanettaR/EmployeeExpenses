package dev.tyler.services;

import dev.tyler.entities.Employee;
import dev.tyler.entities.Expense;

import java.util.List;

public interface EmployeeService {
    List<Expense> expenseLogs(int id);
}
