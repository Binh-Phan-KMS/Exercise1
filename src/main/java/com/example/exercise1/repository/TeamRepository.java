package com.example.exercise1.repository;

import com.example.exercise1.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

    Team findByName(String name);

}
