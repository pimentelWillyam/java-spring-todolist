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

    public List<Task> getAllIncompletedTasks(){
        return taskRepository.findByCompletedFalse();
    }

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task newTask){
        Task task = taskRepository.findById(id).orElseThrow();
        task.setTitle(newTask.getTitle());
        task.setDescription(newTask.getDescription());
        task.setCompleted(newTask.isCompleted());
        taskRepository.save(task);
        return task;
    }

    public void deleteTask(Long id){
        Task task = taskRepository.findById(id).orElseThrow();
        taskRepository.delete(task);
    }



}
