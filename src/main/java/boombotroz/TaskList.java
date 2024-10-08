package boombotroz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Contains the task list and its operands.
 */
public class TaskList {
    private List<Task> taskList;
    public TaskList() {
        taskList = new ArrayList<>();
    }

    /**
     * Returns size of task list.
     */
    public int getSize() {
        return taskList.size();
    }

    /**
     * Returns task list array.
     */
    public List<Task> getTaskList() {
        return this.taskList;
    }

    /**
     * Returns the task from the task list at that index.
     *
     * @param index position of task in task list.
     */
    public Task getTask(int index) {
        assert index >= 0 && index < taskList.size() : "Index out of bounds";
        return taskList.get(index);
    }

    /**
     * Adds task to task list.
     *
     * @param task task to be added
     */
    public void addTask(Task task) {
        taskList.add(task);
    }

    /**
     * Deletes task from task list and displays number of tasks remaining.
     *
     * @param input input given by user.
     * @param ui handles errors that may occur.
     * @return message of task that is deleted.
     * @throws BoomException If position not given OR position out of range.
     */
    public String deleteTask(String input, Ui ui) throws BoomException {
        // check if there is a given task number to delete
        ui.hasNumber(input);
        int index = Integer.parseInt(input.split(" ")[1]) - 1;
        // check if the task number falls within the task list range
        ui.isWrongRange(index, this);

        String s = "";
        s = ui.deleteTaskMessage(this, index);
        taskList.remove(taskList.get(index));
        return s;

    }

    /**
     * Marks task from task list.
     *
     * @param input input given by user.
     * @param ui handles errors that may occur.
     * @return Message after task is marked.
     * @throws BoomException If position not given OR position out of range.
     */
    public String markTask(String input, Ui ui) throws BoomException {
        // check if there is a given task number to mark
        ui.hasNumber(input);
        int index = Integer.parseInt(input.split(" ")[1]) - 1;
        // check if the task number falls within the task list range
        ui.isWrongRange(index, this);

        taskList.get(index).setMark(true);
        return ui.markTaskMessage(this, index);
    }

    /**
     * Unmarks task from task list.
     *
     * @param input input given by user.
     * @param ui handles errors that may occur.
     * @return Message after task is unmarked.
     * @throws BoomException If position not given OR position out of range.
     */
    public String unmarkTask(String input, Ui ui) throws BoomException {
        // check if there is a given task number to unmark
        ui.hasNumber(input);
        int index = Integer.parseInt(input.split(" ")[1]) - 1;
        // check if the task number falls within the task list range
        ui.isWrongRange(index, this);

        taskList.get(index).setMark(false);
        return ui.unmarkTaskMessage(this, index);
    }

    /**
     * Returns all the task from task list.
     */
    public String getAll() {
        Collections.sort(taskList, Comparator.comparingInt(Task::getPriority).reversed());
        String s = "";
        for (int i = 0; i < taskList.size(); i++) {
            s += taskList.get(i) + "\n";
        }
        return s;
    }

}
