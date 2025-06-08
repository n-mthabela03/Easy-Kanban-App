package poe_taskone.pkg1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    Login login = new Login();

    @Test
    // Test if the username is correctly formatted
    public void testCheckUserNameFormattedCorrectly() {
        assertTrue(login.registerUser("kyl_1", "Ch&&sec@ke99!"));  // Valid username and password
    }

    @Test
    // Test if the username is incorrectly formatted
    public void testCheckUserNameFormattedIncorrectly() {
        boolean result = login.registerUser("kyle!!!!!!!", "Ch&&sec@ke99!");
        assertFalse(result);
    }

    @Test
    // Test if password meets complexity
    public void testCheckPasswordStrongComplexity() {
        assertTrue(login.registerUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    // Test if password fails complexity rules
    public void testCheckPasswordWeakComplexity() {
        boolean result = login.registerUser("kyl_1", "password");
        assertFalse(result);
    }

    @Test
    // Test if login returns true when credentials match
    public void testReturnLoginStatusSuccess() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!");
        assertTrue(Login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    // Test if login returns false when credentials do not match
    public void testReturnLoginStatusFailure() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!");
        assertFalse(Login.loginUser("wrong_user", "wrong_pass"));
    }
}
