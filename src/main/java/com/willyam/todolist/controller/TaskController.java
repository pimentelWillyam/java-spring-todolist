package com.willyam.todolist.controller;

import com.willyam.todolist.entity.Task;
import com.willyam.todolist.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<Task> getTasks() {
        return service.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id){
        return service.getTask(id);
    }

    @GetMapping("/completed")
    public List<Task> getAllCompletedTasks() {
        return service.getAllCompletedTasks();
    }

    @GetMapping("/incompleted")
    public List<Task> getAllIncompletedTasks() {
        return service.getAllIncompletedTasks();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        return service.createTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
    }
}

