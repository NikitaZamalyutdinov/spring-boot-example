package server.Data;

public class Task {

    public enum Status {
        BACKLOG, IN_PROGRESS, DONE, ON_REVIEW, BLOCKED, BLOCKER;

        public String capitalized(){
            return Utilite.capitalize(this.toString());
        }
    }

    public enum Type {
        ISSUE, BUG, IMPROVEMENT, TASK;

        public String capitalized(){
            return Utilite.capitalize(this.toString());
        }
    }

    public enum Priority {
        LOW, MEDIUM, HIGH;

        public String capitalized(){
            return Utilite.capitalize(this.toString());
        }
    }

    private Status status;
    private Type type;
    private String name;
    private String description;
    private int progress;
    private Priority priority;
    private User assignedTo;
    private User creator;

    public Task() {
    }

    public Task(Status status, Type type, String name) {
        this(status, type, name, "", 0, Priority.MEDIUM, null, null);
    }

    public Task(Status status, Type type, String name, String description, int progress, Priority priority, User assignedTo, User creator) {
        this.status = status;
        this.type = type;
        this.name = name;
        this.description = description;
        this.progress = progress;
        this.priority = priority;
        User assinbedToSafe = assignedTo != null ? assignedTo : UserRepository.getFakeUser();
        User creatorSafe = creator != null ? creator : UserRepository.getFakeUser();
        this.assignedTo = assinbedToSafe;
        this.creator = creatorSafe;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Priority getPriority() {
        return priority;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public User getCreator() {
        return creator;
    }

    public Status getStatus() {
        return status;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getProgress() {
        return progress;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProgress(byte progress) {
        this.progress = progress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (progress != task.progress) return false;
        if (status != task.status) return false;
        if (type != task.type) return false;
        if (name != null ? !name.equals(task.name) : task.name != null) return false;
        return description != null ? description.equals(task.description) : task.description == null;
    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) progress;
        return result;
    }
}
