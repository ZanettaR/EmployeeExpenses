package dev.tyler.daotests;

import dev.tyler.data.ExpenseDAO;
import dev.tyler.data.ExpenseDAOPostgresImpl;
import dev.tyler.entities.Employee;
import dev.tyler.entities.Expense;
import org.junit.jupiter.api.*;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExpenseDAOTests {
    static ExpenseDAO expenseDAO = new ExpenseDAOPostgresImpl();
    static Expense testExpense = null;

    @Test
    @Order(1)

    void create_expense_test(){
        Expense food = new Expense(0, 0, "Hibachi", "PENDING", 24.36, 1);
        food.setDate(System.currentTimeMillis());
        Expense savedExpense = expenseDAO.createExpense(food);
        ExpenseDAOTests.testExpense = savedExpense;
        Assertions.assertNotEquals(0, savedExpense.getId());
    }

    @Test
    @Order(2)
    void get_expense_by_id(){
        Expense retrievedExpense = expenseDAO.getExpenseById(testExpense.getId());
        Assertions.assertEquals(testExpense.getDate(), retrievedExpense.getDate());
    }

    @Test
    @Order(3)
    void update_expense(){
        ExpenseDAOTests.testExpense.setDescription("Description that was updated in test.");
        expenseDAO.updateExpense(testExpense);
        Expense retrievedExpense = expenseDAO.getExpenseById(testExpense.getId());
        Assertions.assertEquals(testExpense.getDescription(), retrievedExpense.getDescription());
    }

    @Test
    @Order(4)
    void get_all_expenses(){
        List<Expense> expenses = expenseDAO.getAllExpenses();
        int totalExpenses= expenses.size();
        Assertions.assertTrue(totalExpenses >= 1);
    }

    @Test
    @Order(4)
    void get_expense_by_status(){
        List<Expense> expenses = expenseDAO.getExpenseByStatus("PENDING");
        int totalExpenses= expenses.size();
        Assertions.assertTrue(totalExpenses >= 1);
    }

}
