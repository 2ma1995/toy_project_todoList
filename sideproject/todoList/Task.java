package sideproject.todoList;

public class Task {
    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markDone() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        if (!isDone) {
            return "[ ]"+description;
        } else{
            return "[x]"+description;
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
