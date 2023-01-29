package duke;

/**
 * This abstract class is a Task. A task contains
 * the description of the task and whether the task is completed.
 */
public abstract class Task {

    private String description;
    private boolean isDone;

    /**
     * Constructs a task with the given description.
     * @param description Description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Constructs a task with the given description and isDone.
     * @param description Description of the deadline task.
     * @param isDone      Whether the deadline task is done.
     */
    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    public abstract String toStorableString();

    public boolean isDone() {
        return this.isDone;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void markAsUndone() {
        this.isDone = false;
    }

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        return (isDone ? "[X] " : "[] ") + this.description;
    }

}
