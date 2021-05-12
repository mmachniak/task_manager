package com.task.task_manager.controler;

import com.task.task_manager.entity.TaskGroup;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class TaskGroupController {

    private final List<TaskGroup> taskGroups = new ArrayList<>();

    public TaskGroupController() {
        taskGroups.add(new TaskGroup(1L, "Promocja Santander v2"));
        taskGroups.add(new TaskGroup(2L, "Promocja GetIn"));
        taskGroups.add(new TaskGroup(3L, "Promocja Milenium"));
        taskGroups.add(new TaskGroup(3L, "Promocja Milenium 3"));
    }

    @GetMapping("/taskGroup")
    public List<TaskGroup> getTaskGroups() {
        return taskGroups;
    }

    @GetMapping("/taskGroup/{id}")
    public TaskGroup getTaskGroup(@PathVariable Long id) {
        //zwrocic obiekt po id
        return null;
    }


    @DeleteMapping("/taskGroup/{id}")
    public void deleteTaskGroup(@PathVariable Long id) {
        //usunac na podstawie id
    }



}
