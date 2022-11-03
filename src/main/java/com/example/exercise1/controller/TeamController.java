package com.example.exercise1.controller;

import com.example.exercise1.entity.Team;
import com.example.exercise1.entity.Team;
import com.example.exercise1.entity.User;
import com.example.exercise1.service.TeamService;
import com.example.exercise1.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TeamController {
    @Autowired
    private TeamService svc;

    @PostMapping("/team")
    public Team addTeam(@RequestBody Team team) {
        return svc.saveTeam(team);
    }

    @GetMapping("/team/{id}")
    public Team getTeamById(@PathVariable Integer id) {
        return svc.getTeam(id);
    }

    @GetMapping("/team")
    public Team findByName(@RequestParam String name) {
        return svc.findByName(name);
    }

    @PutMapping("/team")
    public Team updateTeam(@RequestBody Team team) {
        return svc.updateTeam(team);
    }

    @DeleteMapping("/team/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        return svc.deleteTeam(id);
    }

    @GetMapping("/team/{name}/members")
    public List<User> getTeamMembers(@PathVariable String name) {
        return svc.getMembers(name);
    }
}
