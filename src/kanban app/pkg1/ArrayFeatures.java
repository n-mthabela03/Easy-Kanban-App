package poe_taskone.pkg1;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class ArrayFeatures {

    private ArrayList<Task> tasks = new ArrayList<>();

    private String fullName;
    private String lastName;

    // Add tasks based on user input
    public void addTasks(int numberOfTasks) {
        for (int i = 0; i < numberOfTasks; i++) {
            String name = JOptionPane.showInputDialog("Enter task name:");
            String description = JOptionPane.showInputDialog("Enter task description:");
            String developer = JOptionPane.showInputDialog("Enter developer name:");
            int duration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration (in hours):"));
            String status = JOptionPane.showInputDialog("Enter task status (To Do / Doing / Done):");

            Task task = new Task(name, i, description, developer, duration, status);
            tasks.add(task);

            JOptionPane.showMessageDialog(null, "Task successfully added!\nTask ID: " + task.getTaskID());
        }
    }

    // Display all tasks report
    public void showReport() {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available to report.");
            return;
        }

        StringBuilder report = new StringBuilder();
        int totalDuration = 0;

        for (Task task : tasks) {
            report.append("Task Name: ").append(task.taskName).append("\n");
            report.append("Developer: ").append(task.developerDetails).append("\n");
            report.append("Task ID: ").append(task.getTaskID()).append("\n");
            report.append("Description: ").append(task.taskDescription).append("\n");
            report.append("Duration: ").append(task.taskDuration).append(" hours\n");
            report.append("Status: ").append(task.taskStatus).append("\n");
            report.append("-----------------------------------\n");

            totalDuration += task.taskDuration;
        }

        report.append("Total Duration of All Tasks: ").append(totalDuration).append(" hours");

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
