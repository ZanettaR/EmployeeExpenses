package dev.tyler.services;

import dev.tyler.data.EmployeeDAO;
import dev.tyler.entities.Employee;
import dev.tyler.entities.Expense;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO){ this.employeeDAO = employeeDAO; }

    @Override
    public List<Expense> expenseLogs(int id) {
        return this.employeeDAO.getEmployeeExpenses(id);
    }
}
