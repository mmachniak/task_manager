package com.task.taskmanager.service;

import com.task.taskmanager.entity.TaskGroup;
import com.task.taskmanager.repository.TaskGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskGroupServiceImpl {

  private final TaskGroupRepository repository;

  public TaskGroupServiceImpl(TaskGroupRepository repository) {
    this.repository = repository;
  }

  public List<TaskGroup> findTaskGroups() {
    return repository.findAll();
  }

  public TaskGroup findTaskGroup(Long id) {
    return repository.getOne(id);
  }

  public TaskGroup createTaskGroup(TaskGroup taskGroup) {
    return repository.save(taskGroup);
  }

  public void deleteTaskGroup(Long id) {
    repository.deleteById(id);
  }

}
