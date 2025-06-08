package poe_taskone.pkg1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Features {
    ArrayList<Task> tasks = new ArrayList<>();
    private String fullName;
    private String lastName;

    public void addTasks(int numTasks) {
        for (int i = 0; i < numTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter task name:");
            String taskDescription;
            do {
                taskDescription = JOptionPane.showInputDialog("Enter task description (max 50 characters):");
                if (taskDescription.length() > 50) {
                    JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
                }
            } while (taskDescription.length() > 50);

            String developerDetails = JOptionPane.showInputDialog("Enter developer name:");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration (in hours):"));

            String[] statuses = {"To Do", "Doing", "Done"};
            String taskStatus = (String) JOptionPane.showInputDialog(null, "Choose task status", "Status",
                    JOptionPane.QUESTION_MESSAGE, null, statuses, statuses[0]);

            Task task = new Task(taskName, i, taskDescription, developerDetails, taskDuration, taskStatus);
            tasks.add(task);
            JOptionPane.showMessageDialog(null, task.printTaskDetails());
        }

        int totalHours = tasks.stream().mapToInt(Task::returnTotalHours).sum();
        JOptionPane.showMessageDialog(null, "Total hours: " + totalHours);
    }

    public void showReport() {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks to show.");
            return;
        }
        StringBuilder report = new StringBuilder("------ Task Report ------\n\n");
        for (Task task : tasks) {
            report.append(task.printTaskDetails()).append("\n----------------------\n");
        }
        JOptionPane.showMessageDialog(null, report.toString());
    }

    public void setCustomerFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCustomerLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCustomerFullName() {
        return fullName;
    }

    public String getCustomerLastName() {
        return lastName;
    }
}
