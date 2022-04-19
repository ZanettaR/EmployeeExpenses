package dev.tyler.data;

import dev.tyler.entities.Expense;
import dev.tyler.utilities.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpenseDAOPostgresImpl implements ExpenseDAO{
    @Override
    public Expense createExpense(Expense expense) {
        try{
            Connection conn = ConnectionUtil.createConnection();
            String sql = "insert into expense values(default, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, expense.getDate());
            ps.setString(2, expense.getDescription());
            ps.setString(3, expense.getStatus());
            ps.setInt(4, expense.getAmount());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int generatedId = rs.getInt("expense_id");
            expense.setId(generatedId);
            return expense;
        }catch (SQLException e){
            return null;
        }
    }

    @Override
    public Expense getExpenseById(int id) {
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
    public Expense updateExpense(Expense expense) {
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
    public boolean deleteExpenseById(int id) {
        try{
            Connection conn = ConnectionUtil.createConnection();
            String sql = "";
            PreparedStatement ps = conn.prepareStatement(sql);

            return true;
        }catch (SQLException e){
            return false;
        }

    }
}
