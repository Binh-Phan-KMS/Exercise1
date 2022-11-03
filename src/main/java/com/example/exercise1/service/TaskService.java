package com.example.exercise1.service;

import com.example.exercise1.entity.Task;
import com.example.exercise1.entity.Team;
import com.example.exercise1.entity.User;
import com.example.exercise1.repository.TaskRepository;
import com.example.exercise1.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
public class TaskService {

    @Autowired
    private TaskRepository repo;

    public Task saveTask(Task task) {
        if (task.getAssignee() == null) {
            task.setAssignee(new User());
        }

        if (task.getEstimatedTime() == null) {
            task.setEstimatedTime(0);
        }

        LocalDateTime dateTime = LocalDateTime.now().plusHours(task.getEstimatedTime());
        task.setDeadline(dateTime);
        return repo.save(task);
    }

    public Task getTask(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public Task findByTitle(String title) {
        return repo.findByTitle(title);
    }

    public Task updateTask(Task task) {
        Task temp = repo.findById(task.getID()).orElse(null);
        temp.setTitle(task.getTitle());
        temp.setDescription(task.getDescription());
        temp.setStatus(task.getStatus());
        temp.setEstimatedTime(task.getEstimatedTime());

        repo.save(temp);

        return temp;
    }

    public String deleteTask(Integer id) {
        repo.deleteById(id);
        return "Team removed " + id;
    }


}
