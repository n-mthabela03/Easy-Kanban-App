package poe_taskone.pkg1;

public class Task {
    String taskName;
    int taskNumber;
    String taskDescription;
    String developerDetails;
    int taskDuration;
    String taskID;
    String taskStatus;

    public Task(String taskName, int taskNumber, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID(taskName, taskNumber, developerDetails);
    }

    public String printTaskDetails() {
        return "Task Name: " + taskName + "\n" +
                "Developer: " + developerDetails + "\n" +
                "Task ID: " + taskID + "\n" +
                "Description: " + taskDescription + "\n" +
                "Duration: " + taskDuration + " hours\n" +
                "Status: " + taskStatus;
    }

    public static String createTaskID(String name, int num, String dev) {
        String namePart = name.length() >= 2 ? name.substring(0, 2) : name.toUpperCase();
        String devPart = dev.length() >= 3 ? dev.substring(dev.length() - 3) : dev.toUpperCase();
        return (namePart + ":" + num + ":" + devPart).toUpperCase();
    }

    public int returnTotalHours() {
        return taskDuration;
    }

    public String getTaskID() {
        return taskID;
    }
    public boolean checkTaskDescription() {
    return this.taskDescription.length() <= 50;
}

}
