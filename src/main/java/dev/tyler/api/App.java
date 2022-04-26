package dev.tyler.api;

import dev.tyler.controllers.EmployeeController;
import dev.tyler.controllers.ExpenseController;
import io.javalin.Javalin;

public class App {


    public static void main(String[] args) {
        Javalin app = Javalin.create();

        // Employee Routes
        app.get("/employees", EmployeeController::allEmployees);
        app.post("/employees", EmployeeController::addEmployee);
        app.get("/employees/{id}", EmployeeController::viewEmployee);
        app.put("/employees/{id}", EmployeeController::placholder); // TODO: UPDATE EMPLOYEE
        app.delete("/employees/{id}", EmployeeController::deleteEmployee);
        app.get("/employees/{id}/expenses", EmployeeController::employeeExpenses);
        app.post("/employees/{id}/expenses", EmployeeController::addEmployeeExpense);

        // Expense Routes
        app.get("/expenses", ExpenseController::getExpenses);
        app.post("/expenses", ExpenseController::placholder); // TODO: ADD NEW EXPENSE
        app.get("/expenses/{id}", ExpenseController::expense);
        app.put("/expenses/{id}", ExpenseController::placholder); // TODO: UPDATE EXPENSE
        app.delete("/expenses/{id}", ExpenseController::deleteExpense);
        app.patch("/expenses/{id}/approve", ExpenseController::approveExpense);
        app.patch("/expenses/{id}/deny", ExpenseController::denyExpense);

        app.start(7000);
    }
}
