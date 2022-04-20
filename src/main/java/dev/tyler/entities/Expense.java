package dev.tyler.entities;

public class Expense {
    private int id;
    private long date;
    private String description;
    private String status;
    private double amount;

    public Expense() {
    }

    public Expense(int id, long date, String description, String status, double amount) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.status = status;
        this.amount = amount;
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

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                '}';
    }
}
