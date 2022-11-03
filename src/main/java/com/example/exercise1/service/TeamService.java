package com.example.exercise1.service;

import com.example.exercise1.entity.Team;
import com.example.exercise1.entity.User;
import com.example.exercise1.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TeamService {

    @Autowired
    private TeamRepository repo;

    public Team saveTeam(Team team) {
        return repo.save(team);
    }

    public Team getTeam(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public Team findByName(String name) {
        return repo.findByName(name);
    }

    public Team updateTeam(Team team) {
        Team temp = repo.findById(team.getID()).orElse(null);
        temp.setName(team.getName());
        temp.setOffice(team.getOffice());

        repo.save(temp);

        return temp;
    }

    public String deleteTeam(Integer id) {
        repo.deleteById(id);
        return "Team removed " + id;
    }

    public List<User> getMembers(String name) {
        return repo.findByName(name).getMembers();
    }
}
