/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tut.taskmanagement.controller;
//
//import jakarta.servlet.http.HttpServletResponse;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tut.taskmanagement.model.CountType;
import tut.taskmanagement.model.Task;
import tut.taskmanagement.service.TaskService;

/**
 *
 * @author S2026080
 */
@RestController
@RequestMapping("/api/grouprr")
@CrossOrigin("*")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/task")
    public List<Task> getTask() {
        return taskService.getTasks();
    }

    @PostMapping("/task")
    public Task addTask(@RequestBody Task task) {
        task.setCreationDate(LocalDateTime.now());
        return taskService.save(task);
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<?> addTask(@RequestBody Task taskParam, @PathVariable Long id) {
        if (taskService.exist(id)) {
            Task task = taskService.getTaskById(id).orElseThrow(() -> new EntityNotFoundException("Request Task not found"));
            task.setTitle(taskParam.getTitle());
            task.setDueDate(taskParam.getDueDate());
            task.setDescription(taskParam.getDescription());
            task.setType(taskParam.getType());
            taskService.save(task);
            return ResponseEntity.ok().body(task);
        } else {
            HashMap<String, String> message = new HashMap<>();
            message.put("message", id + " Task not Found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        if (taskService.exist(id)) {
            taskService.delete(id);
            HashMap<String, String> message = new HashMap<>();
            message.put("message", id + " Task successfully Removed!");
            return ResponseEntity.status(HttpStatus.OK).body(message);

        } else {
            HashMap<String, String> message = new HashMap<>();
            message.put("message", id + " Task not Found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

    @GetMapping("/task/{id}")
    public Task getById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id).orElseThrow(() -> new EntityNotFoundException("Request Task not found"));
        return task;

    }
    
    @GetMapping("/task/vData/percentageofconttype")
    public List<CountType> getPercentageByType(){
     return taskService.getPercentageByType();
    }
//    
//    @PutMapping("/{id}")
//public Task update(@PathVariable Long id, RequestBody Task task){
//    Task task = taskService.findById(id).orElseThrow(RuntimeException::new);
//    task.setTitle(title);
//}

}
