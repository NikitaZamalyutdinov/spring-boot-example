package server.domain;

import org.springframework.data.repository.CrudRepository;
import server.domain.entity.Task;
import server.domain.entity.TaskStatus;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long>{

    List<Task> findByStatus(TaskStatus status);
    Task findByName(String name);

}