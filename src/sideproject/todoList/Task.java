package sideproject.todoList;

public class Task {
    private String description;
    private boolean isDone;
    private Priority priority;

    public Task(String description,Priority priority) {
        this.description = description;
        this.isDone = false;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markDone() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        String status = isDone ? "[x]" : "[]";
        return status + description+ " (우선순위: " + priority + ")";
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
