package poe_taskone.pkg1;

import javax.swing.JOptionPane;

public class Registration {

    public static Features newTask = new Features();

    public static void main(String[] args) {

        // User login/registration
        String username = JOptionPane.showInputDialog(null, "Please enter your username:");
        String password = JOptionPane.showInputDialog(null, "Please enter your password:");

        if (!checkUsername(username)) return;
        if (!checkPassword(password)) return;

        // Optionally register the user here using Login class (optional)
        if (!Login.registerUser(username, password)) {
            JOptionPane.showMessageDialog(null, "Registration failed.");
            return;
        }

        // Capture user details
        String fullName = JOptionPane.showInputDialog(null, "Please Enter Your full name");
        newTask.setCustomerFullName(fullName);

        String lastName = JOptionPane.showInputDialog(null, "Please Enter Your last name");
        newTask.setCustomerLastName(lastName);

        // Menu loop
        while (true) {
            String menuInput = JOptionPane.showInputDialog(null,
                    "Please Choose from the options below:\n"
                            + "1. Add tasks\n"
                            + "2. Show report\n"
                            + "3. Quit");

            if (menuInput == null) break; // user cancelled dialog

            int menuOption;
            try {
                menuOption = Integer.parseInt(menuInput);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input, please enter a number.");
                continue;
            }

            switch (menuOption) {
                case 1:
                    int numTasks = 0;
                    try {
                        numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to add?"));
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid number entered.");
                        continue;
                    }
                    newTask.addTasks(numTasks); // Use instance method to add tasks
                    break;
                case 2:
                    newTask.showReport(); // Show task report
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option.");
            }
        }
    }

    public static boolean checkUsername(String username) {
        if (username != null && username.length() <= 5 && username.contains("_")) {
            JOptionPane.showMessageDialog(null, "Username successfully captured.");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted. "
                    + "It should contain an underscore and be no more than 5 characters.");
            return false;
        }
    }

    public static boolean checkPassword(String password) {
        if (password != null && password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*\\d.*") &&
                password.matches(".*[!@#$%^&*()].*")) {

            JOptionPane.showMessageDialog(null, "Password successfully captured.");
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban, it is great to see you again.");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted. "
                    + "Ensure it contains at least 8 characters, a capital letter, a number and a special character.");
            return false;
        }
    }
}
