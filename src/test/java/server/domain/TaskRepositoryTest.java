package server.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import server.domain.entity.Task;
import server.domain.entity.TaskPriority;
import server.domain.entity.TaskStatus;
import server.domain.entity.TaskType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/test.properties")
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository repository;

    @Before
    public void a() {

    }

    @Test
    public void saveTask() {
        Task task = new Task();
        task.setPriority(TaskPriority.LOW);
        task.setStatus(TaskStatus.BACKLOG);
        task.setProgress(100);
        task.setType(TaskType.ISSUE);
        task.setName("testtask");
        repository.save(task);
    }

    @Test
    public void getBacklogTasks() {
        Assert.assertTrue(repository.findByStatus(TaskStatus.BACKLOG).size() == 1);
    }
}