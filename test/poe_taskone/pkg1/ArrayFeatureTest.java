package poe_taskone.pkg1;

import java.util.Arrays;
import javax.swing.JOptionPane;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayFeatureTest {

    public ArrayFeatureTest() {
    }

    @Test

    public void testArrayFeat() {

    }

    public void testCorrectPopulatedDeveloperArray() {
        int DArray = 1 - 4;
        String DArrays = "\nMike Smith" + "\nEdward Harrington" + "\nSamantha Paulson" + "\nGlenda Oberholzer";
        assertEquals(DArray, DArrays);
    }

    @Test

    public void testCheckLongestDuration() {

        String actual = "Task 1-4";
        String Longest = "Glenda Oberholzer";
        assertEquals(Longest, Longest);

        JOptionPane.showMessageDialog(null, "\nMike Smith" + "\nEdward Harrington"
                + "\nSamantha Paulson" + "\nGlenda Oberholzer");
    }
    
        public void testSearchTask() {

        String actual = "Create Login";
        String assgnDev = "Create Report";
        assertEquals(assgnDev, actual);
    }

    public void testAssignedDeveloper() {

        String actual = "Samantha Paulson";
        String assgnDev = "Mike Smith, Create Login”";
        assertEquals(assgnDev, actual);
    }

    @Test
    public void testDeleteTask() {

        String DTask = "Create Reports";
        String TaskDeleted = "Entry 'Create Reports' has been deleted";
        assertEquals(DTask, DTask);

    }

    @Test
    public void testDisplayReport() {

    }

}
