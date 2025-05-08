package com.waldhauser.tasklist.task;

import jakarta.persistence.*;
import com.waldhauser.tasklist.tasklist.Tasklist;
import java.util.UUID;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // this is jakarta import and generated value UUID bc database sets it
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tasklist_id", nullable = false)
    private Tasklist tasklist;

    @Column(unique = false, nullable = false)
    private String name;

    @Column(unique = false, nullable = false)
    private String description;

    public Task() {
    }

    public Task(UUID id, Tasklist tasklist, String name, String description) {
        this.id = id;
        this.tasklist = tasklist;
        this.name = name;
        this.description = description;
    }

    public Task(Tasklist tasklist, String name, String description) {
        this.tasklist = tasklist;
        this.name = name;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Tasklist getTasklist() {
        return tasklist;
    }

    public void setTasklist(Tasklist tasklist) {
        this.tasklist = tasklist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
