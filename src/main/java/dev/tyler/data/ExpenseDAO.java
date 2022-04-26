package dev.tyler.data;

import dev.tyler.entities.Expense;

import java.util.List;

public interface ExpenseDAO {

    Expense createExpense(Expense expense);

    Expense getExpenseById(int id);

    Expense updateExpense(Expense expense);

    boolean deleteExpenseById(int id);

    List<Expense> getExpenseByStatus(String status);

    List<Expense> getAllExpenses();

}
