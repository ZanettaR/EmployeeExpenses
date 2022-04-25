package dev.tyler.services;

import dev.tyler.entities.Expense;

public class ExpenseServiceImpl implements ExpenseService{
    @Override
    public Expense addExpense(Expense expense) {
        return this.addExpense(expense);
    }

    @Override
    public boolean removeExpense(int id) {
        return this.removeExpense(id);
    }

    @Override
    public Expense updateExpense(Expense expense) {
        return this.updateExpense(expense);
    }
}
