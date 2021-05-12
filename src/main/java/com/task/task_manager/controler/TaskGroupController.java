package com.task.task_manager.controler;

import com.task.task_manager.entity.TaskGroup;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class TaskGroupController {

    @GetMapping("/taskGroup")
    public List<TaskGroup> getTaskGroups() {
        List<TaskGroup> list = new ArrayList<>();
        list.add(new TaskGroup(1L, "Promocja Santander v2"));
        list.add(new TaskGroup(2L, "Promocja GetIn"));
        list.add(new TaskGroup(3L, "Promocja Milenium"));
        return list;
    }

}
