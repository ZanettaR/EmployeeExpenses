package dev.tyler.controllers;


import com.google.gson.Gson;
import dev.tyler.data.EmployeeDAOPostgresImpl;
import dev.tyler.entities.Employee;
import dev.tyler.entities.Expense;
import dev.tyler.services.EmployeeService;
import dev.tyler.services.EmployeeServiceImpl;
import io.javalin.http.Context;

public class EmployeeController {

    public static EmployeeService employeeService = new EmployeeServiceImpl(new EmployeeDAOPostgresImpl());

    public static void updateEmployee(Context context){
        int id = Integer.parseInt(context.pathParam("id"));
        String body = context.body();
        Gson gson = new Gson();
        Employee employee = gson.fromJson(body, Employee.class);
        if(employee != null){
            employee.setId(id);
            employeeService.updateEmployee(employee);
            context.result("Employee was updated.");
        }else{
            context.result("Employee not found");
            context.status(404);
        }
    }

    // Get all employees
    public static void allEmployees(Context context){
        Gson gson = new Gson();
        String json = gson.toJson(employeeService.employees());
        context.result(json);
    }

    public static void addEmployee(Context context){
        String body = context.body();
        Gson gson = new Gson();
        Employee employee = gson.fromJson(body, Employee.class);
        employeeService.addEmployee(employee);
        context.result("A new employee was created.");
    }

    public static void deleteEmployee(Context context){
        int id = Integer.parseInt(context.pathParam("id"));
        Gson gson = new Gson();
        boolean result = employeeService.deleteEmployee(id);
        if(result){
            String json = gson.toJson(true);
            context.result(json);
        }else{
            context.result("Employee not found.");
            context.status(404);
        }

    }

    //Get selected employee
    public static void viewEmployee(Context context){
        int id = Integer.parseInt(context.pathParam("id"));
        Gson gson = new Gson();
        Employee e  = employeeService.getEmployee(id);
        if(e != null){
            String json = gson.toJson(e);
            context.result(json);
        }else{
            context.result("Employee not found.");
            context.status(404);
        }
    }

    // Get selected employee's expenses
    public static void employeeExpenses(Context context){
        int id = Integer.parseInt(context.pathParam("id"));
        Gson gson = new Gson();
        String json = gson.toJson(employeeService.employeeExpenseLogs(id));
        context.result(json);
    }

    public static void addEmployeeExpense(Context context){
        int id = Integer.parseInt(context.pathParam("id"));
        String body = context.body();
        Gson gson = new Gson();
        Expense expense = gson.fromJson(body, Expense.class);
        if(expense != null){
            expense.setExpenseOwner(id);
            employeeService.addEmployeeExpense(expense);
            context.result("A new employee expense was created.");
            context.status(201);
        }else{
            context.result("A new employee was not created at this time.");
        }
    }
}
