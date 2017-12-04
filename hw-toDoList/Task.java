import java.time.LocalDateTime;

public class Task {

    private String name;
    private int priority;
    private LocalDateTime dueDate;
    private boolean status;

    public Task(String name, int priority, LocalDateTime dueDate
        , boolean status) {
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.status = status;
    }

    public String getTaskName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int newPriority) {
        priority = newPriority;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime newDueDate) {
        dueDate = newDueDate;
    }

    public boolean status() {
        return status;
    }

    public void changeStatus(boolean newStatus) {
        status = newStatus;
    }

    public String task2String() {
        return name + " | " + priority + " | " + dueDate + " | " + status;
    }
}
