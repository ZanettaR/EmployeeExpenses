package dev.tyler.controllers;

import com.google.gson.Gson;
import dev.tyler.data.ExpenseDAOPostgresImpl;
import dev.tyler.entities.Employee;
import dev.tyler.entities.Expense;
import dev.tyler.services.ExpenseService;
import dev.tyler.services.ExpenseServiceImpl;
import io.javalin.http.Context;

import java.util.Locale;

public class ExpenseController {
    public static ExpenseService expenseService = new ExpenseServiceImpl(new ExpenseDAOPostgresImpl());

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
        Expense e = expenseService.getExpense(id);
        if(e != null){
            String json = gson.toJson(e);
            context.result(json);
        }else{
            context.result("Expense not found.");
            context.status(404);
        }
    }

    public static void deleteExpense(Context context){
        int id = Integer.parseInt(context.pathParam("id"));
        Expense e = expenseService.getExpense(id);
        if(e != null){
            if(e.getStatus().equalsIgnoreCase("PENDING")){
                boolean result = expenseService.removeExpense(id);
                if(result){
                    context.result("Expense was deleted.");
                }else{
                    context.result("Expense was not deleted.");
                }
            }else{
                context.result("This expense cannot be deleted. It has already been " + e.getStatus().toLowerCase() + ".");
            }
        }else{
            context.result("Expense not found.");
            context.status(404);
        }
    }

    public static void approveExpense(Context context){
        int id = Integer.parseInt(context.pathParam("id"));
        Gson gson = new Gson();
        Expense expense = expenseService.getExpense(id);
        if(expense != null){
            if(expense.getStatus().equalsIgnoreCase("PENDING")){
                String json = gson.toJson(expenseService.approveExpense(expense));
                context.result(json);
            }else{
                context.result("This expense has already been " + expense.getStatus().toLowerCase() + ".");
            }
        }else{
            context.result("Expense not found.");
            context.status(404);
        }
    }

    public static void denyExpense(Context context){
        int id = Integer.parseInt(context.pathParam("id"));
        Gson gson = new Gson();
        Expense expense = expenseService.getExpense(id);
        if(expense != null){
            if(expense.getStatus().equalsIgnoreCase("PENDING")){
                String json = gson.toJson(expenseService.approveExpense(expense));
                context.result(json);
            }else{
                context.result("This expense has already been " + expense.getStatus().toLowerCase() + ".");
            }
        }else{
            context.result("Expense not found.");
            context.status(404);
        }
    }

    public static void updateExpense(Context context){
        int id = Integer.parseInt(context.pathParam("id"));
        String body = context.body();
        Gson gson = new Gson();
        Expense expense = gson.fromJson(body, Expense.class);
        expense.setId(id);

        if(expense != null){
            if(expense.getStatus().equalsIgnoreCase("PENDING")){
                expenseService.updateExpense(expense);
                context.result("Expense was updated.");
            }else{
                context.result("This expense cannot be updated. It has already been " + expense.getStatus().toLowerCase() + ".");
            }
        }else{
            context.result("Expense not found.");
            context.status(404);
        }
    }

    public static void addExpense(Context context){
        String body = context.body();
        Gson gson = new Gson();
        Expense expense = gson.fromJson(body, Expense.class);

        if(expense != null){
            expenseService.addExpense(expense);
            context.result("A new expense was created.");
            context.status(201);
        }else{
            context.result("A new expense was not created at this time.");
        }
    }
}
