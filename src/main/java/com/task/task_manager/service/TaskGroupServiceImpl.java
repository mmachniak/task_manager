package com.task.task_manager.service;

import com.task.task_manager.entity.TaskGroup;
import com.task.task_manager.repository.TaskGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskGroupServiceImpl {

    private TaskGroupRepository repository;

    public TaskGroupServiceImpl(TaskGroupRepository repository) {
        this.repository = repository;
    }

    public List<TaskGroup> findTaskGroups() {
        return repository.findAll();
    }

    public TaskGroup findTaskGroup(Long id) {
        return repository.getOne(id);
    }

    public void deleteTaskGroup(Long id) {
        repository.deleteById(id);
    }

}
