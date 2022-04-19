package dev.tyler.data;

import dev.tyler.entities.Employee;
import dev.tyler.entities.Expense;
import dev.tyler.utilities.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDAOPostgresImpl implements EmployeeDAO {
    @Override
    public Employee createEmployee(Employee employee) {
        try{
            Connection conn = ConnectionUtil.createConnection();
            String sql = "";
            PreparedStatement ps = conn.prepareStatement(sql);

            return null;
        }catch (SQLException e){
            return null;
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        try{
            Connection conn = ConnectionUtil.createConnection();
            String sql = "";
            PreparedStatement ps = conn.prepareStatement(sql);

            return null;
        }catch (SQLException e){
            return null;
        }
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        try{
            Connection conn = ConnectionUtil.createConnection();
            String sql = "";
            PreparedStatement ps = conn.prepareStatement(sql);

            return null;
        }catch (SQLException e){
            return null;
        }
    }

    @Override
    public List<Expense> getEmployeeExpenses(int id) {
        try{
            Connection conn = ConnectionUtil.createConnection();
            String sql = "";
            PreparedStatement ps = conn.prepareStatement(sql);

            return null;
        }catch (SQLException e){
            return null;
        }
    }
}
