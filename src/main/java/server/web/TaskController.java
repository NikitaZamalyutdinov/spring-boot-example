package server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import server.domain.entity.*;
import server.service.TaskService;
import server.service.UserService;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskService service;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/taskUpdateStatus")
    public String updateTaskStatus(@RequestParam String name, @RequestParam String column) {
        service.updateTaskStatus(name, TaskStatus.valueOf(column));
        return "redirect:tasks";
    }

    @RequestMapping(value = "/taskAdd")
    public String addTask(@ModelAttribute Task task){
        service.saveTask(task);
        return "redirect:tasks";
    }

    @ModelAttribute("allUsers")
    public List<User> populateUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/tasks")
    public String getAllTasks(Model model) {
        model.addAttribute("newTask", new Task());
        return "tasks";
    }

    @ModelAttribute("backlogTasks")
    public List<Task> populateBacklogTasks(){
        return service.getBacklogTasks();
    }

    @ModelAttribute("inProgressTasks")
    public List<Task> populateInProgressTasks(){
        return service.getInProgressTasks();
    }

    @ModelAttribute("doneTasks")
    public List<Task> populateDoneTasks(){
        return service.getDoneTasks();
    }

    @ModelAttribute("taskTypes")
    public List<TaskType> populateTaskTypes() {
        return new ArrayList<>(EnumSet.allOf(TaskType.class));
    }

    @ModelAttribute("taskStatuses")
    public List<TaskStatus> populateStatuses() {
        return new ArrayList<>(EnumSet.allOf(TaskStatus.class));
    }

    @ModelAttribute("taskPriorities")
    public List<TaskPriority> populatePriorities() { return new ArrayList<>(EnumSet.allOf(TaskPriority.class)); }
}
