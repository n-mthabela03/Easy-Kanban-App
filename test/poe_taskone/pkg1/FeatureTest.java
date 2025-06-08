package poe_taskone.pkg1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FeatureTest {

    @Test
    public void testCheckTaskDescriptionSuccess() {
        Task task = new Task("Test Feature", 0, "This is a valid description", "Alice Smith", 5, "To Do");
        assertTrue(task.checkTaskDescription());
    }

    @Test
    public void testCheckTaskDescriptionFailure() {
        Task task = new Task("Test Feature", 0, "This is an excessively long description that exceeds fifty characters", "Alice Smith", 5, "To Do");
        assertFalse(task.checkTaskDescription());
    }

    @Test
    public void testCreateTaskID() {
        String expected = "LO:1:BYN";
        String actual = Task.createTaskID("Login Feature", 1, "Robyn");
        assertEquals(expected, actual);
    }

    @Test
    public void testReturnTotalHours() {
        Task t1 = new Task("Login Feature", 0, "Create Login", "Robyn", 8, "To Do");
        Task t2 = new Task("Add Task Feature", 1, "Add Task to list", "Mike", 10, "Doing");
        int total = t1.returnTotalHours() + t2.returnTotalHours();
        assertEquals(18, total);
    }

    @Test
    public void testTotalHoursFromFeatures() {
        Features f = new Features();

        // Manually add tasks to the Features tasks list
        f.tasks.add(new Task("Task1", 0, "Desc1", "Dev1", 10, "To Do"));
        f.tasks.add(new Task("Task2", 1, "Desc2", "Dev2", 12, "Doing"));
        f.tasks.add(new Task("Task3", 2, "Desc3", "Dev3", 55, "Done"));
        f.tasks.add(new Task("Task4", 3, "Desc4", "Dev4", 11, "To Do"));
        f.tasks.add(new Task("Task5", 4, "Desc5", "Dev5", 1, "Doing"));

        int totalHours = f.tasks.stream().mapToInt(Task::returnTotalHours).sum();

        assertEquals(89, totalHours);  // 10+12+55+11+1 = 89
    }
}
