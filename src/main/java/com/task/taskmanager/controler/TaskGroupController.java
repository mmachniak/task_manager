package com.task.taskmanager.controler;

import com.task.taskmanager.entity.TaskGroup;
import com.task.taskmanager.service.TaskGroupServiceImpl;
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


  @DeleteMapping("/taskGroup/{id}")
  public void deleteTaskGroup(@PathVariable Long id) {
    service.deleteTaskGroup(id);
  }

}
