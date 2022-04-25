package dev.tyler.daotests;

import dev.tyler.data.EmployeeDAO;
import dev.tyler.data.EmployeeDAOPostgresImpl;
import dev.tyler.data.ExpenseDAO;
import dev.tyler.data.ExpenseDAOPostgresImpl;
import dev.tyler.entities.Employee;
import dev.tyler.entities.Expense;
import org.junit.jupiter.api.*;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeDAOTests {

    static EmployeeDAO employeeDAO = new EmployeeDAOPostgresImpl();
    static Employee testEmployee = null;

    @Test
    @Order(1)
    void create_employee(){
        Employee zee = new Employee(0, "Zanetta" , "Tyler");
        Employee savedEmployee = employeeDAO.createEmployee(zee);
        EmployeeDAOTests.testEmployee = savedEmployee;
        Assertions.assertNotEquals(0, savedEmployee.getId());
    }

    @Test
    @Order(2)
    void get_employee_by_id(){
        Employee retrievedEmployee = employeeDAO.getEmployeeById(testEmployee.getId());
        Assertions.assertEquals(testEmployee.getFirstName(), retrievedEmployee.getFirstName());
    }

    @Test
    @Order(3)
    void update_employee(){
        EmployeeDAOTests.testEmployee.setLastName("T.");
        employeeDAO.updateEmployee(testEmployee);
        Employee retrievedEmployee = employeeDAO.getEmployeeById(testEmployee.getId());
        Assertions.assertEquals(testEmployee.getLastName(), retrievedEmployee.getLastName());
    }

    @Test
    @Order(4)
    void get_employee_expenses(){
        ExpenseDAO expenseDAO = new ExpenseDAOPostgresImpl();
        expenseDAO.createExpense(new Expense(0, System.currentTimeMillis(), "Create from employee test.", "", 54.36,  testEmployee.getId()));
        expenseDAO.createExpense(new Expense(0, System.currentTimeMillis(), "Create from employee test time 2.", "", 4.36,  testEmployee.getId()));

        List<Expense> employeeExpenses = employeeDAO.getEmployeeExpenses(testEmployee.getId());
        int totalExpenses = employeeExpenses.size();
        Assertions.assertTrue(totalExpenses >= 1);
    }
}
