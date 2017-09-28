package server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import server.domain.Task;
import server.domain.TaskRepository;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

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
