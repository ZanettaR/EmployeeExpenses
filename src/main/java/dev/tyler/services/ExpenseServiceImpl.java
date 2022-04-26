package dev.tyler.services;

import dev.tyler.data.ExpenseDAO;
import dev.tyler.entities.Expense;

import java.util.List;

public class ExpenseServiceImpl implements ExpenseService{
    private ExpenseDAO expenseDAO;

    public ExpenseServiceImpl(ExpenseDAO expenseDAO){ this.expenseDAO = expenseDAO; }

    @Override
    public Expense addExpense(Expense expense) {
        expense.setDate(System.currentTimeMillis());
        return this.expenseDAO.createExpense(expense);
    }

    @Override
    public boolean removeExpense(int id) {
        return this.expenseDAO.deleteExpenseById(id);
    }

    @Override
    public Expense getExpense(int id) {
        return this.expenseDAO.getExpenseById(id);
    }

    @Override
    public Expense updateExpense(Expense expense) {
        return this.expenseDAO.updateExpense(expense);
    }

    @Override
    public Expense approveExpense(Expense expense) {
        expense.setStatus("APPROVED");
        return this.expenseDAO.updateExpense(expense);
    }

    @Override
    public Expense denyExpense(Expense expense) {
        expense.setStatus("DENIED");
        return this.expenseDAO.updateExpense(expense);
    }

    @Override
    public List<Expense> getExpenseByStatus(String status) {
        return this.expenseDAO.getExpenseByStatus(status);
    }

    @Override
    public List<Expense> expenseLogs() {
        return this.expenseDAO.getAllExpenses();
    }
}
