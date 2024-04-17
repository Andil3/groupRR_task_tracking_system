/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tut.taskmanagement.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tut.taskmanagement.model.CountType;
import tut.taskmanagement.model.Task;
import tut.taskmanagement.persistence.TaskRepository;

/**
 *
 * @author S2026080
 */
@Component
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    /**
     *
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<Task> getTasks() {
        return taskRepository.findAllByOrderByDueDateDesc();
    }

    @Override
    @Transactional
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean exist(Long id) {
        return taskRepository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }
     @Override
    public void delete(Long id){
        taskRepository.deleteById(id);
    }
    
    @Override
    public List<CountType> getPercentageByType(){
       return taskRepository.findPercentageByType();
    }
}
