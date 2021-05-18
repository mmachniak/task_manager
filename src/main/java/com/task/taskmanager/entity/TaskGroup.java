package com.task.taskmanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TaskGroup {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  @JsonIgnore
  @OneToMany(mappedBy = "taskGroup", orphanRemoval = true)
  private List<Task> tasks = new ArrayList<>();

  protected TaskGroup() {
  }

  public TaskGroup(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Task> getTasks() {
    return tasks;
  }

  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }
}
