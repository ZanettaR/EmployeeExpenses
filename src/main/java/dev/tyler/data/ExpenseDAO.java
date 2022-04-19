package dev.tyler.data;

import dev.tyler.entities.Expense;

public interface ExpenseDAO {

    Expense createExpense(Expense expense);

    Expense getExpenseById(int id);

    Expense updateExpense(Expense expense);

    boolean deleteExpenseById(int id);
}
