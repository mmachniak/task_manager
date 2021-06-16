package com.task.taskmanager.fixture;

import com.task.taskmanager.entity.TaskGroup;
import java.util.Arrays;
import java.util.List;

public class TaskGroupFixture {

  public static List<TaskGroup> getTaskGroups() {
    TaskGroup task1 = new TaskGroup("Task1");
    task1.setId(1L);
    TaskGroup task2 = new TaskGroup("Task2");
    task2.setId(2L);
    TaskGroup task3 = new TaskGroup("Task3");
    task3.setId(3L);
    return Arrays.asList(task1, task2, task3);
  }

}
