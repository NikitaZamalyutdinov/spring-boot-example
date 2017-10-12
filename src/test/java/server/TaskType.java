package server;

import org.junit.Assert;
import org.junit.Test;
import server.domain.entity.TaskFake;
import server.web.TaskController;

import java.util.Arrays;

public class TaskType {
    TaskController taskController = new TaskController();

    @Test
    public void a(){
        Assert.assertTrue(taskController.populateTaskTypes().containsAll(Arrays.asList(TaskFake.Type.values())));
    }
}
