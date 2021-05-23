package com.task.taskmanager.controler;

import com.task.taskmanager.entity.Task;
import com.task.taskmanager.entity.TaskGroup;
import com.task.taskmanager.service.TaskGroupServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TaskGroupController {

  private final TaskGroupServiceImpl service;

  public TaskGroupController(TaskGroupServiceImpl service) {
    this.service = service;
  }

  @GetMapping("/taskGroup")
  public List<TaskGroup> getTaskGroups() {
    return service.findTaskGroups();
  }

  @GetMapping("/taskGroup/{id}")
  public TaskGroup getTaskGroup(@PathVariable Long id) {
    return service.findTaskGroup(id);
  }

  @PostMapping("/taskGroup")
  public void addTaskGroup(@RequestBody TaskGroup taskGroup) {
    service.createTaskGroup(taskGroup);
  }


  @DeleteMapping("/taskGroup/{id}")
  public void deleteTaskGroup(@PathVariable Long id) {
    service.deleteTaskGroup(id);
  }

  @Transactional
  @GetMapping("/taskGroup/{id}/task")
  public List<Task> getTasks(@PathVariable Long id) {
    var taskGroup = service.findTaskGroup(id);
    return taskGroup.getTasks();
  }

}
