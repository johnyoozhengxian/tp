package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.DeleteTaskCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.task.Task;
import seedu.address.model.task.TaskId;
import seedu.address.model.task.TaskName;


public class DeleteTaskCommandParserTest {
    @Test
    public void test() throws ParseException, CommandException {
        DeleteTaskCommandParser parser = new DeleteTaskCommandParser();
        Model m = new ModelManager();
        m.addTask(new Task(new TaskName("Test"), new TaskId(123)));

        DeleteTaskCommand dtc = parser.parse("123");

        assertTrue(m.getFilteredTaskList().size() == 1);
        dtc.execute(m);
        assertTrue(m.getFilteredTaskList().size() == 0);
    }

    @Test
    public void test2() throws ParseException {
        DeleteTaskCommandParser parser = new DeleteTaskCommandParser();
        try {
            parser.parse("");
        } catch (ParseException e) {
            assertEquals(e.getMessage(), "Invalid command format! \n"
                    + "deletetask: Removes the task identified by the taskID used in the displayed task list.\n"
                    + "Parameters: taskID (must be a positive integer)\n"
                    + "Example: deletetask 1");
        }
    }
}
