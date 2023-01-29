package duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This class is a event task. It contains
 * the description of the task, the time the task
 * starts and the time the task ends.
 */
public class Event extends Task {

    private LocalDate from;
    private LocalDate to;

    /**
     * Constructs an event with the given description, from and to.
     * @param description Description of the deadline task.
     * @param from        The time the event task starts.
     * @param to          The time the event task ends.
     */
    public Event(String description, LocalDate from, LocalDate to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Constructs an event with the given description, isDone, from and to.
     * @param description Description of the deadline task.
     * @param isDone      Whether the deadline task is done.
     * @param from        The time the event task starts.
     * @param to          The time the event task ends.
     */
    public Event(String description, boolean isDone, LocalDate from, LocalDate to) {
        super(description, isDone);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: "
                + this.from.format(DateTimeFormatter.ofPattern("MMM d yyyy"))
                + " to: " + this.from.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }

    @Override
    public String toStorableString() {
        return "E" + "," + (this.isDone() ? "1" : "0") + "," + this.getDescription()
                + "," + this.from.toString() + "," + this.to.toString();
    }

}
