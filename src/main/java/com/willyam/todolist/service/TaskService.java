package com.willyam.todolist.service;

import com.willyam.todolist.entity.Task;
import com.willyam.todolist.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks(){
        return this.taskRepository.findAll();
    }


    public Task getTask(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com ID: " + id));
    }

    public List<Task> getAllCompletedTasks(){
        return taskRepository.findByCompletedTrue();
    }

}
