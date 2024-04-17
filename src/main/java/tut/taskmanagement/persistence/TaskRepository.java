/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tut.taskmanagement.persistence;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tut.taskmanagement.model.CountType;
import tut.taskmanagement.model.Task;

/**
 *
 * @author S2026080
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    public Task findByTitle(String title);

    public List<Task> findAllByOrderByDueDateDesc();

    //select [type], COUNT( *)*100/ (select COUNT(*) FROM [Task_DB].[dbo].[Task]) AS percentage FROM [Task_DB].[dbo].[Task] GROUP BY [type]
//    @Query("SELECT new tut.taskmanagement.model.CountType(COUNT(*)/(Select COUNT(*) from Task) *100,type) from Task GROUP BY type")
        @Query("select new tut.taskmanagement.model.CountType(count(p),type )\n" +
"       from Task p\n" +
"       group by p.type")
    public List<CountType> findPercentageByType();
}

