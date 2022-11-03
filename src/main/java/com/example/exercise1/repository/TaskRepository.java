package com.example.exercise1.repository;

import com.example.exercise1.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    Task findByTitle(String title);
}
