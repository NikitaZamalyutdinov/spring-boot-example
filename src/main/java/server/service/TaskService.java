package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import server.domain.TaskRepository;
import server.domain.UserRepository;
import server.domain.entity.Task;
import server.domain.entity.TaskStatus;
import server.domain.entity.User;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    public void saveTask(Task task) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userRepository.findByName(name);

        // Default values
        task.setCreatedBy(user);
        task.setProgress(0);
        taskRepository.save(task);
    }

    public void updateTaskStatus(String name, TaskStatus status) {
        Task task = taskRepository.findByName(name);
        task.setStatus(status);
        taskRepository.save(task);
    }

    public List<Task> getBacklogTasks() {
        return taskRepository.findByStatus(TaskStatus.BACKLOG);
    }

    public List<Task> getInProgressTasks() {
        return taskRepository.findByStatus(TaskStatus.IN_PROGRESS);
    }

    public List<Task> getDoneTasks() {
        return taskRepository.findByStatus(TaskStatus.DONE);
    }
}
