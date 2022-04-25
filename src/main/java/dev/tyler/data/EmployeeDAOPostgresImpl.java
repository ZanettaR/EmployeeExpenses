package dev.tyler.data;

import dev.tyler.entities.Employee;
import dev.tyler.entities.Expense;
import dev.tyler.utilities.ConnectionUtil;
import dev.tyler.utilities.LogLevel;
import dev.tyler.utilities.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOPostgresImpl implements EmployeeDAO {

    static ExpenseDAO expenseDAO = new ExpenseDAOPostgresImpl();

    @Override
    public Employee createEmployee(Employee employee) {
        try{
            Connection conn = ConnectionUtil.createConnection();
            String sql = "insert into employee values(default, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int generatedId = rs.getInt("employee_id");
            employee.setId(generatedId);

            return employee;
        }catch (SQLException e){
            Logger.log(e.getMessage(), LogLevel.ERROR);
            return null;
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        try{
            Connection conn = ConnectionUtil.createConnection();
            String sql = "select * from employee where employee_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Employee employee = new Employee();
            employee.setId(rs.getInt("employee_id"));
            employee.setFirstName(rs.getString("firstname"));
            employee.setLastName(rs.getString("lastname"));

            return employee;
        }catch (SQLException e){
            Logger.log(e.getMessage(), LogLevel.ERROR);
            return null;
        }
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        try{
            Connection conn = ConnectionUtil.createConnection();
            String sql = "update employee set firstname = ?, lastname = ? where employee_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setInt(3, employee.getId());
            ps.executeUpdate();

            return employee;
        }catch (SQLException e){
            Logger.log(e.getMessage(), LogLevel.ERROR);
            return null;
        }
    }

    @Override
    public boolean addEmployeeExpense(int id) {
        return false;
    }

    @Override
    public List<Expense> getEmployeeExpenses(int id) {
        try{
            Connection conn = ConnectionUtil.createConnection();
            String sql = "select * from employee inner join expense on employee.employee_id = expense.eid where employee_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            List<Expense> expenses = new ArrayList();
            while (rs.next()){
                Expense expense = expenseDAO.getExpenseById(rs.getInt("expense_id"));
                expenses.add(expense);
            }

            return expenses;
        }catch (SQLException e){
            Logger.log(e.getMessage(), LogLevel.ERROR);
            return null;
        }
    }
}
