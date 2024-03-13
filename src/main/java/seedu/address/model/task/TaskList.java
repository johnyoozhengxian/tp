package seedu.address.model.task;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.task.exepctions.TaskNotFoundException;

/**
 * A list of tasks.
 */
public class TaskList {

    private final ObservableList<Task> internalList = FXCollections.observableArrayList();
    private final ObservableList<Task> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    /**
     * Adds a task to the list.
     */
    public void add(Task task) {
        internalList.add(task);
    }

    /**
     * Removes the equivalent task from the list.
     * The Employee must exist in the list.
     */
    public void remove(Task toRemove) {
        if (!internalList.remove(toRemove)) {
            throw new TaskNotFoundException();
        }
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<Task> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    public void setTasks(List<Task> tasks) {
        internalList.setAll(tasks);
    }

    @Override
    public String toString() {
        return internalList.toString();
    }
}