package dev.tyler.entities;

public class Expense {
    private int id;
    private long date;
    private String desc;
    private String status;

    public Expense() {
    }

    public Expense(int id, long date, String desc, String status) {
        this.id = id;
        this.date = date;
        this.desc = desc;
        this.status = status;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", date=" + date +
                ", desc='" + desc + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
