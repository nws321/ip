package boombotroz;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Main class where execution occurs.
 */
public class Boombotroz {
    private Ui ui;
    private Storage storage;
    private Parser parser;
    private TaskList taskList;

    /**
     * Creates necessary objects and existence of text file to be written into.
     *
     * @param filePath file path to text file.
     */
    public Boombotroz(String filePath) {
        assert filePath != null && !filePath.isEmpty() : "File path should not be null or empty.";
        ui = new Ui();
        storage = new Storage(filePath);
        taskList = new TaskList();
        parser = new Parser();
        try {
            storage.loadTasks(taskList);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");

        }

    }

    /**
     * Displays current task list.
     *
     * @return List of all the tasks.
     * @throws FileNotFoundException If file not in directory.
     */
    public String printTaskList() throws FileNotFoundException {
        try {
            return storage.printTasks(taskList);

        } catch (FileNotFoundException e) {
            return "File not found";

        }
    }

    /**
     * Generates a response for the user's chat message.
     */
    public String run(String input) {

        while (!input.equals("bye")) {
            try {
                if (input.equals("list")) {
                    return parser.getList(ui, taskList);


                } else if (input.startsWith("mark ")) {
                    return parser.markTask(taskList, input, storage, ui);


                } else if (input.startsWith("unmark ")) {
                    return parser.unmarkTask(taskList, input, storage, ui);


                } else if (input.startsWith("delete ")) {
                    return parser.deleteTask(taskList, input, storage, ui);


                } else if (input.startsWith("find ")) {
                    return parser.findTask(taskList, input, ui);


                } else if (input.startsWith("todo ")) {
                    return parser.toDoTask(taskList, input, storage, ui);


                } else if (input.startsWith("deadline ")) {
                    return parser.deadlineTask(taskList, input, storage, ui);


                } else if (input.startsWith("event ")) {
                    return parser.eventTask(taskList, input, storage, ui);


                } else {
                    ui.invalidInput();

                }
            } catch (BoomException e) {
                return e.getMessage();


            } catch (FileNotFoundException e) {
                return "File not found";

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "Bye. Hope to see you again soon!";
    }

    public static void main(String[] args) {

    }


}

