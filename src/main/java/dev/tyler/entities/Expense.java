package dev.tyler.entities;

import java.util.Date;

public class Expense {
    private int id;
    private long date;
    private String description;
    private String status;
    private double amount;
    private int expenseOwner;

    public Expense() {
    }

    public Expense(int id, long date, String description, String status, double amount, int expenseOwner) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.status = status;
        this.amount = amount;
        this.expenseOwner = expenseOwner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getExpenseOwner() {
        return expenseOwner;
    }

    public void setExpenseOwner(int expenseOwner) {
        this.expenseOwner = expenseOwner;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", date=" + new Date(date) +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                '}';
    }
}
