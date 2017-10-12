package server.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @Enumerated(EnumType.STRING)
    private TaskType type;
    @Enumerated(EnumType.STRING)
    private TaskPriority priority;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "assigned_to")
    private User assignedTo;
    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;
    private Integer progress;

    public Long getId() {
        return id;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public TaskType getType() {
        return type;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }
}
