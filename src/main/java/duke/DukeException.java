package duke;

/**
 * This is a DukeException that contains error message
 * for the user.
 */
public class DukeException extends Exception {

    public DukeException(String errorMessage) {
        super(errorMessage);
    }

    @Override
    public String getMessage() {
        return "OOPS!!! " + super.getMessage();
    }

}
