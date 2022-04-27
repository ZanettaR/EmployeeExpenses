package dev.tyler.controllers;

import com.google.gson.Gson;
import dev.tyler.data.ExpenseDAOPostgresImpl;
import dev.tyler.entities.Employee;
import dev.tyler.entities.Expense;
import dev.tyler.services.ExpenseService;
import dev.tyler.services.ExpenseServiceImpl;
import io.javalin.http.Context;

public class ExpenseController {
    public static ExpenseService expenseService = new ExpenseServiceImpl(new ExpenseDAOPostgresImpl());

    public static void placholder(Context context){}
    // Get all employees
    public static void getExpenses(Context context){
        String status = context.queryParam("status");
        if(status == null){
            Gson gson = new Gson();
            String json = gson.toJson(expenseService.expenseLogs());
            context.result(json);
        } else {
            Gson gson = new Gson();
            String json = gson.toJson(expenseService.getExpenseByStatus(status));
            context.result(json);
        }

    }

    public static void viewExpense(Context context){
        int id = Integer.parseInt(context.pathParam("id"));
        Gson gson = new Gson();
        String json = gson.toJson(expenseService.getExpense(id));
        context.result(json);
    }

    public static void deleteExpense(Context context){
        int id = Integer.parseInt(context.pathParam("id"));
        Gson gson = new Gson();
        String json = gson.toJson(expenseService.removeExpense(id));
        context.result(json);
    }

    public static void approveExpense(Context context){
        int id = Integer.parseInt(context.pathParam("id"));
        Gson gson = new Gson();
        Expense expense = expenseService.getExpense(id);
        String json = gson.toJson(expenseService.approveExpense(expense));
        context.result(json);
    }

    public static void denyExpense(Context context){
        int id = Integer.parseInt(context.pathParam("id"));
        Gson gson = new Gson();
        Expense expense = expenseService.getExpense(id);
        String json = gson.toJson(expenseService.denyExpense(expense));
        context.result(json);
    }

    public static void updateExpense(Context context){
        int id = Integer.parseInt(context.pathParam("id"));
        String body = context.body();
        Gson gson = new Gson();
        Expense expense = gson.fromJson(body, Expense.class);
        expense.setId(id);
        expenseService.updateExpense(expense);
        context.result("Expense was updated.");
    }

    public static void addExpense(Context context){
        String body = context.body();
        Gson gson = new Gson();
        Expense expense = gson.fromJson(body, Expense.class);
        expenseService.addExpense(expense);
        context.result("A new employee was created.");
    }
}
