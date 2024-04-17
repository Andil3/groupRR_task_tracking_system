/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tut.taskmanagement.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import tut.taskmanagement.model.Task;
import tut.taskmanagement.model.CountType;

/**
 *
 * @author S2026080
 */
@Service
public interface TaskService {

    public List<Task> getTasks();

    public Task save(Task task);

    public boolean exist(Long id);
    
    public Optional<Task> getTaskById(Long id);
    
     public void delete(Long id);
     
     public List<CountType> getPercentageByType();

}
