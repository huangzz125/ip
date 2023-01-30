package duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * This class is a Storage that helps with the writing and reading
 * of saved contents made by user.
 */
public class Storage {

    private static final String FILE_NAME = "data.txt";
    private final File file;

    public Storage() {
        file = new File(FILE_NAME);
    }

    /**
     * Loads and parses saved content into a TaskList.
     * @return TaskList of user.
     */
    public TaskList readSavedFile() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error when creating file: " + e);
            }
        }
        TaskList taskList = new TaskList();
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                taskList.addTask(parseStringToTask(myReader.nextLine()));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return taskList;
    }

    /**
     * Takes in a String and returns a Task.
     * @param string List of tasks in use by the app.
     * @return Task.
     */
    public Task parseStringToTask(String string) {
        String[] inputArray = string.split(",");
        if (inputArray[0].equals("T")) {
            return new ToDo(inputArray[2], inputArray[1].equals("1"));
        } else if (inputArray[0].equals("D")) {
            return new Deadline(inputArray[2], inputArray[1].equals("1"), LocalDate.parse(inputArray[3]));
        } else {
            return new Event(inputArray[2], inputArray[1].equals("1"),
                    LocalDate.parse(inputArray[3]),
                    LocalDate.parse(inputArray[4]));
        }
    }

    /**
     * Saves tasklist to file.
     * @param taskList Lists of tasks in use by the app.
     *
     */
    public void saveTaskListToStorage(TaskList taskList) {
        try {
            FileWriter myWriter = new FileWriter(file); // this truncates the duke.txt to size 0
            for (int i = 0; i < taskList.getArraySize(); i++) {
                myWriter.write(taskList.getTask(i).toStorableString() + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
