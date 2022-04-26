package dev.tyler.data;

import dev.tyler.entities.Expense;
import dev.tyler.utilities.ConnectionUtil;
import dev.tyler.utilities.LogLevel;
import dev.tyler.utilities.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAOPostgresImpl implements ExpenseDAO{
    @Override
    public Expense createExpense(Expense expense) {
        try{
            Connection conn = ConnectionUtil.createConnection();
            String sql = "insert into expense values(default, ?, ?, default, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, expense.getDate());
            ps.setString(2, expense.getDescription());
            ps.setDouble(3, expense.getAmount());
            ps.setInt(4, expense.getExpenseOwner());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int generatedId = rs.getInt("expense_id");
            expense.setId(generatedId);
            return expense;
        } catch (SQLException e){
            Logger.log(e.getMessage(), LogLevel.ERROR);
            return null;
        }
    }

    @Override
    public Expense getExpenseById(int id) {
        try{
            Connection conn = ConnectionUtil.createConnection();
            String sql = "select * from expense where expense_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();
            Expense expense = new Expense();
            expense.setId(rs.getInt("expense_id"));
            expense.setDate(rs.getLong("expense_date"));
            expense.setDescription(rs.getString("description"));
            expense.setStatus(rs.getString("status"));
            expense.setAmount(rs.getDouble("amount"));
            expense.setExpenseOwner(rs.getInt("eid"));

            return expense;
        }catch (SQLException e){
            Logger.log(e.getMessage(), LogLevel.ERROR);
            return null;
        }
    }

    @Override
    public Expense updateExpense(Expense expense) {
        try{
            Connection conn = ConnectionUtil.createConnection();
            String sql = "update expense set expense_date = ?, description = ?, " +
                    "status = ?, amount = ?, eid = ? where expense_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, expense.getDate());
            ps.setString(2, expense.getDescription());
            ps.setString(3,expense.getStatus());
            ps.setDouble(4, expense.getAmount());
            ps.setInt(5, expense.getExpenseOwner());
            ps.setInt(6, expense.getId());
            ps.executeUpdate();

            return expense;
        }catch (SQLException e){
            Logger.log(e.getMessage(), LogLevel.ERROR);
            return null;
        }
    }

    @Override
    public boolean deleteExpenseById(int id) {
        try{
            Connection conn = ConnectionUtil.createConnection();
            String sql = "delete from expense where expense_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();

            return true;
        }catch (SQLException e){
            Logger.log(e.getMessage(), LogLevel.ERROR);
            return false;
        }
    }

    @Override
    public List<Expense> getExpenseByStatus(String status) {
        try{
            Connection conn = ConnectionUtil.createConnection();
            String sql = "select * from expense where status = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            ResultSet rs = ps.executeQuery();
            List<Expense> expenses = new ArrayList();
            while (rs.next()){
                Expense expense = new Expense();
                expense.setId(rs.getInt("expense_id"));
                expense.setDate(rs.getLong("expense_date"));
                expense.setDescription(rs.getString("description"));
                expense.setStatus(rs.getString("status"));
                expense.setAmount(rs.getDouble("amount"));
                expense.setExpenseOwner(rs.getInt("eid"));
                expenses.add(expense);
            }
            return expenses;
        }catch (SQLException e){
            Logger.log(e.getMessage(), LogLevel.ERROR);
            return null;
        }
    }

    @Override
    public List<Expense> getAllExpenses() {
        try{
            Connection conn = ConnectionUtil.createConnection();
            String sql = "select * from expense";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Expense> expenses = new ArrayList();
            while (rs.next()){
                Expense expense = new Expense();
                expense.setId(rs.getInt("expense_id"));
                expense.setDate(rs.getLong("expense_date"));
                expense.setDescription(rs.getString("description"));
                expense.setStatus(rs.getString("status"));
                expense.setAmount(rs.getDouble("amount"));
                expense.setExpenseOwner(rs.getInt("eid"));
                expenses.add(expense);
            }
            return expenses;

        }catch (SQLException e){
            Logger.log(e.getMessage(), LogLevel.ERROR);
            return null;
        }
    }
}
