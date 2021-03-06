package com.task.task_manager.controler;

import com.task.task_manager.entity.TaskGroup;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@CrossOrigin
public class TaskGroupController {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<TaskGroup> mapper = (resultSet, i) -> new TaskGroup(
            resultSet.getLong(1),
            resultSet.getString(2)
    );

    public TaskGroupController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/taskGroup")
    public List<TaskGroup> getTaskGroups() {
        return jdbcTemplate.query("select * from TASK_GROUP", mapper);
    }

    @GetMapping("/taskGroup/{id}")
    public TaskGroup getTaskGroup(@PathVariable Long id) {
        return jdbcTemplate.queryForObject("select * from TASK_GROUP WHERE ID = ?", mapper, id);
    }


    @DeleteMapping("/taskGroup/{id}")
    public void deleteTaskGroup(@PathVariable Long id) {
        jdbcTemplate.update("DELETE FROM TASK_GROUP WHERE ID = ?", id);
    }

//zadanie sworzyć endpoint który zwróci pierwsze n liczby nieprzystych

    @GetMapping("/even/{n}")
    public List<Integer> getEvenList(@PathVariable Integer n) {
        return IntStream.iterate(1, i -> i + 2)
                .limit(n).boxed()
                .collect(Collectors.toList());

//        List<Integer> odd = new ArrayList<>();
//        int i = 0;
//        int x = 0;
//        while (i < n) {
//            if (x % 2 == 1) {
//                odd.add(x);
//                i++;
//            }
//            x++;
//        }
//        return odd;
    }


}
