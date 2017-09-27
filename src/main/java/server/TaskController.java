package server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import server.Data.Task;
import server.Data.TaskRepository;

import java.util.List;

@Controller
public class TaskController {

    TaskRepository taskRepository = new TaskRepository();

    @RequestMapping(value = "/tasks")
    public String getAllTasks() {
        return "tasks";
    }

    @ModelAttribute("backlogTasks")
    public List<Task> populateBacklogTasks(){
        return taskRepository.getBacklogTasks();
    }

    @ModelAttribute("inProgressTasks")
    public List<Task> populateInProgressTasks(){
        return taskRepository.getInProgressTasks();
    }

    @ModelAttribute("doneTasks")
    public List<Task> populateDoneTasks(){
        return taskRepository.getDoneTasks();
    }
}
