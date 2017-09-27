package server.Data;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TaskRepository {
    private static List<Task> tasks = ImmutableList.of(
            new Task(Task.Status.BACKLOG, Task.Type.BUG, "Task1"),
            new Task(Task.Status.BACKLOG, Task.Type.BUG, "Task10"),
            new Task(Task.Status.BACKLOG, Task.Type.ISSUE, "heaahsddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"),
            new Task(Task.Status.IN_PROGRESS, Task.Type.BUG, "Task2"),
            new Task(Task.Status.DONE, Task.Type.BUG, "Task3")) ;

    private static EnumSet<Task.Status> backlogTaskPosibleStatuses =
            EnumSet.of(Task.Status.BACKLOG, Task.Status.BLOCKED, Task.Status.BLOCKER);
    private static EnumSet<Task.Status> inProgressTaskPosibleStatuses =
            EnumSet.of(Task.Status.IN_PROGRESS, Task.Status.ON_REVIEW,
                    Task.Status.BLOCKED, Task.Status.BLOCKER);
    private static EnumSet<Task.Status> doneTaskPosibleStatuses = EnumSet.of(Task.Status.DONE);

    public List<Task> getAll(){
        return tasks;
    }

    public List<Task> getBacklogTasks() {
        return tasks.stream()
                .filter(t -> backlogTaskPosibleStatuses.contains(t.getStatus()))
                .collect(Collectors.toList());
    }

    public List<Task> getInProgressTasks() {
        return tasks.stream()
                .filter(t -> inProgressTaskPosibleStatuses.contains(t.getStatus()))
                .collect(Collectors.toList());
    }

    public List<Task> getDoneTasks() {
        return tasks.stream()
                .filter(t -> doneTaskPosibleStatuses.contains(t.getStatus()))
                .collect(Collectors.toList());
    }
}
