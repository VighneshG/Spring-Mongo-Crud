package com.spring.mongo.Controller;

import com.spring.mongo.Domain.Task;
import com.spring.mongo.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    // READ - FindAllTasks
    @GetMapping
    public List<Task> findAllTasks(){
        return taskService.findAllTasks();
    }

    // READ - findByTaskID
    @GetMapping("/{taskId}")
    public Task findByTaskId(@PathVariable String taskId){
        return taskService.findByTaskId(taskId);
    }

    // Update
    @PutMapping
    public Task updateTask(@RequestBody Task task){
        return taskService.updateTask(task);
    }

    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable String taskId){
        return taskService.deleteTask(taskId);
    }
}
