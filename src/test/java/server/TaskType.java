package server;

import org.junit.Assert;
import org.junit.Test;
import server.domain.Task;
import server.web.TaskController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class TaskType {
    TaskController taskController = new TaskController();

    @Test
    public void a(){
        Assert.assertTrue(taskController.populateTaskTypes().containsAll(Arrays.asList(Task.Type.values())));
    }
}
