package com.example.exercise1.controller;

import com.example.exercise1.entity.User;
import com.example.exercise1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService svc;

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        return svc.saveUser(user);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Integer id) {
        return svc.getUserById(id);
    }

    @GetMapping("/user/list")
    public List<User> findAllUsers() {
        return svc.getUsers();
    }

    @GetMapping("/user")
    public List<User> findByName(@RequestParam String name) {
        return svc.findByName(name);
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        return svc.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        return svc.deleteUser(id);
    }
}
