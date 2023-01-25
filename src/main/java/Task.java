public abstract class Task {
    private String description;
    private boolean isDone;
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }
    public abstract String toStorableString();

    public boolean isDone() {
        return this.isDone;
    }
    public void markAsUndone() {
        this.isDone = false;
    }

    public String getDescription() {
        return this.description;
    }
    public void markAsDone() {
        this.isDone = true;
    }
    public String toString() {
        return (isDone ? "[X] " : "[] ") + this.description;
    }

}
