package dev.tyler.services;

import dev.tyler.data.EmployeeDAO;
import dev.tyler.data.ExpenseDAOPostgresImpl;
import dev.tyler.entities.Employee;
import dev.tyler.entities.Expense;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDAO employeeDAO;
    private ExpenseService expenseService = new ExpenseServiceImpl(new ExpenseDAOPostgresImpl());
    public EmployeeServiceImpl(EmployeeDAO employeeDAO){ this.employeeDAO = employeeDAO; }

    @Override
    public Employee addEmployee(Employee employee) {
        return this.employeeDAO.createEmployee(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return this.employeeDAO.updateEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(int id) {
        return this.employeeDAO.deleteEmployeeById(id);
    }

    @Override
    public Employee getEmployee(int id) {
        return this.employeeDAO.getEmployeeById(id);
    }

    @Override
    public boolean addEmployeeExpense(Expense expense) {
        Expense e = expenseService.addExpense(expense);
        if(e != null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Employee> employees() {
        return this.employeeDAO.getAllEmployees();
    }

    @Override
    public List<Expense> employeeExpenseLogs(int id) {
        return this.employeeDAO.getEmployeeExpenses(id);
    }
}
