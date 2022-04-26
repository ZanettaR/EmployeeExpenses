package dev.tyler.services;

import dev.tyler.entities.Expense;

import java.util.List;

public interface ExpenseService {

    Expense addExpense(Expense expense);

    boolean removeExpense(int id);

    Expense getExpense(int id);

    Expense updateExpense(Expense expense);

    Expense approveExpense(Expense expense);

    Expense denyExpense(Expense expense);

    List<Expense> getExpenseByStatus(String status);

    List<Expense> expenseLogs();
}
