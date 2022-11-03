package com.spring.mongo.Service;

import com.spring.mongo.Domain.Task;
import com.spring.mongo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    //CRUD - Create, Read, Update, Delete operations

    //Create
    public Task createTask(Task task){
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return taskRepository.save(task);
    }

    // READ - FindAllTasks
    public List<Task> findAllTasks(){
        return taskRepository.findAll();
    }

    // READ - findByTaskID
    public Task findByTaskId(String taskId){
        return taskRepository.findById(taskId).get();
    }

    // Update
    public Task updateTask(Task task){
        //Get existing task
        Task oldTask = taskRepository.findById(task.getTaskId()).get();
        oldTask.setAssignee(task.getAssignee());
        oldTask.setDescription(task.getDescription());
        oldTask.setSeverity(task.getSeverity());
        oldTask.setStoryPoint(task.getStoryPoint());

        return taskRepository.save(oldTask);
    }

    //Delete
    public String deleteTask(String taskId){
        if (taskRepository.existsById(taskId)){
            taskRepository.deleteById(taskId);
            return "Deleted task "+taskId+" Successfully!";
        }else return "Task "+taskId+" Doesn't exist";
    }
}
