package poe_taskone.pkg1;

import javax.swing.JOptionPane;

public class Login {
    public static String storedUsername = "";
    public static String storedPassword = "";

    public static boolean registerUser(String username, String password) {
        if (!username.contains("_") || username.length() > 5) {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted. Please ensure it contains an underscore and is no more than 5 characters.");
            return false;
        }

        if (password.length() < 8 || !password.matches(".*[A-Z].*") || !password.matches(".*\\d.*") || !password.matches(".*[!@#$%^&*()].*")) {
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted. Please ensure it contains at least 8 characters, a capital letter, a number, and a special character.");
            return false;
        }

        storedUsername = username;
        storedPassword = password;
        return true;
    }

    public static boolean loginUser(String username, String password) {
        if (username.equals(storedUsername) && password.equals(storedPassword)) {
            JOptionPane.showMessageDialog(null, "Welcome " + username + ", it is great to see you again.");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Username or password incorrect. Please try again.");
            return false;
        }
    }
}
