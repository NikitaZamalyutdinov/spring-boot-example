package server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import server.domain.Task;
import server.domain.TaskRepository;
import server.domain.User;
import server.web.ui.TasksToolbar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping(value = "/taskAdd")
    public String addTask(@ModelAttribute Task task){
        taskRepository.putTask(Task.create(task));
        return "redirect:tasks";
    }

    @RequestMapping(value = "/tasks")
    public String getAllTasks(Model model) {
        model.addAttribute("toolbar", new TasksToolbar());
        model.addAttribute("newTask", new Task());
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

    @ModelAttribute("taskTypes")
    public List<Task.Type> populateTaskTypes() {
        return new ArrayList<>(Task.allTypes());
    }

    @ModelAttribute("taskStatuses")
    public List<Task.Status> populateStatuses() {
        return new ArrayList<>(Task.allStatuses());
    }
}
