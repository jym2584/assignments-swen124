package assignment_132;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;
@Testable
public class TaskTest {
    @Test
    public void taskTest() {
        String expected = "[Task{Sweep, 1}, Task{Mop, 2}, Task{Laundary, 3}]";

        List<Task> optimalTasks = Task.getMostTasks(6);

        assertEquals(expected, optimalTasks.toString());
    }
    
}
