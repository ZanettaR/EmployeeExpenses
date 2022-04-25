package dev.tyler.services;

import dev.tyler.data.ExpenseDAO;
import dev.tyler.entities.Expense;

public class ExpenseServiceImpl implements ExpenseService{
    private ExpenseDAO expenseDAO;

    public ExpenseServiceImpl(ExpenseDAO expenseDAO){ this.expenseDAO = expenseDAO; }

    @Override
    public Expense addExpense(Expense expense) { return this.expenseDAO.createExpense(expense); }

    @Override
    public boolean removeExpense(int id) {
        return this.expenseDAO.deleteExpenseById(id);
    }

    @Override
    public Expense updateExpense(Expense expense) { return this.expenseDAO.updateExpense(expense); }
}
