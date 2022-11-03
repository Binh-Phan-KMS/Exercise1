package com.example.exercise1.controller;

import com.example.exercise1.entity.Task;
import com.example.exercise1.entity.User;
import com.example.exercise1.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskService svc;

    @PostMapping("/task")
    public Task addTask(@RequestBody Task task) {

        return svc.saveTask(task);
    }

    @GetMapping("/task/{id}")
    public Task getTaskById(@PathVariable Integer id) {
        return svc.getTask(id);
    }

    @GetMapping("/task")
    public Task findByTitle(@RequestParam String name) {
        return svc.findByTitle(name);
    }

    @PutMapping("/task")
    public Task updateTask(@RequestBody Task task) {
        return svc.updateTask(task);
    }

    @DeleteMapping("/task/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        return svc.deleteTask(id);
    }
}
