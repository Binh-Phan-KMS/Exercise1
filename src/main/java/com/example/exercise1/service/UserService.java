package com.example.exercise1.service;


import com.example.exercise1.constant.Role;
import com.example.exercise1.entity.Team;
import com.example.exercise1.entity.User;
import com.example.exercise1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository repo;
    public User getUserById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public List<User> getUsers() {
        return repo.findAll();
    }

    public List<User> findByName(String name) {
        return repo.findByName(name);
    }
    public User saveUser(User user) {
        if (user.getRole().equals(Role.MEMBER) || user.getRole().equals(Role.SCRUM_MASTER) || user.getRole().equals(Role.PROJECT_OWNER) || user.getRole().equals(Role.OTHER)) {
            return repo.save(user);
        }

        return null;
    }

    public String deleteUser(Integer id) {
        repo.deleteById(id);
        return "User removed " + id;
    }

    public User updateUser(User user) {
        User existingUser = repo.findById(user.getID()).orElse(null);
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setOffice(user.getOffice());
            existingUser.setTeam(user.getTeam());
            existingUser.setRole(user.getRole());
        }

        return existingUser;
    }
}
