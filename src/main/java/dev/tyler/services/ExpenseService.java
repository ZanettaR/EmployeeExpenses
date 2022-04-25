package dev.tyler.services;

import dev.tyler.entities.Expense;

public interface ExpenseService {

    Expense addExpense(Expense expense);

    boolean removeExpense(int id);

    Expense updateExpense(Expense expense);
}
