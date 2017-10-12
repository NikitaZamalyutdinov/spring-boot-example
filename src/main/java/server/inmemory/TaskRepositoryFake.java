package server.inmemory;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;
import server.domain.entity.TaskFake;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TaskRepositoryFake {
    private static List<TaskFake> tasks = Lists.newArrayList(
            new TaskFake(TaskFake.Status.BACKLOG, TaskFake.Type.BUG, "Task1"),
            new TaskFake(TaskFake.Status.BACKLOG, TaskFake.Type.TASK, "Task10"),
            new TaskFake(TaskFake.Status.BACKLOG, TaskFake.Type.ISSUE, "heaahsddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"),
            new TaskFake(TaskFake.Status.IN_PROGRESS, TaskFake.Type.BUG, "Task2"),
            new TaskFake(TaskFake.Status.DONE, TaskFake.Type.BUG, "Task3")) ;

    static {
        tasks.get(0).setPriority(TaskFake.Priority.LOW);
        tasks.get(2).setPriority(TaskFake.Priority.HIGH);
    }

    private static EnumSet<TaskFake.Status> backlogTaskPosibleStatuses =
            EnumSet.of(TaskFake.Status.BACKLOG, TaskFake.Status.BLOCKED, TaskFake.Status.BLOCKER);
    private static EnumSet<TaskFake.Status> inProgressTaskPosibleStatuses =
            EnumSet.of(TaskFake.Status.IN_PROGRESS, TaskFake.Status.ON_REVIEW,
                    TaskFake.Status.BLOCKED, TaskFake.Status.BLOCKER);
    private static EnumSet<TaskFake.Status> doneTaskPosibleStatuses = EnumSet.of(TaskFake.Status.DONE);

    public List<TaskFake> getAll(){
        return tasks;
    }

    public List<TaskFake> getBacklogTasks() {
        return tasks.stream()
                .filter(t -> backlogTaskPosibleStatuses.contains(t.getStatus()))
                .collect(Collectors.toList());
    }

    public List<TaskFake> getInProgressTasks() {
        return tasks.stream()
                .filter(t -> inProgressTaskPosibleStatuses.contains(t.getStatus()))
                .collect(Collectors.toList());
    }

    public List<TaskFake> getDoneTasks() {
        return tasks.stream()
                .filter(t -> doneTaskPosibleStatuses.contains(t.getStatus()))
                .collect(Collectors.toList());
    }

    public void putTask(TaskFake task){
        tasks.add(task);
    }
}
