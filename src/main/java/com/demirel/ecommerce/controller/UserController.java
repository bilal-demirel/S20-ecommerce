package com.demirel.ecommerce.controller;

import com.demirel.ecommerce.entity.User;
import com.demirel.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getUsers(){
        List<User> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        userService.addUser(user);
        return ResponseEntity.ok(user);
    }
    @PutMapping("/")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return ResponseEntity.ok(userService.updateUser(user));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable Long id){
        User user = userService.getUserById(id);
        userService.deleteUserById(id);
        return ResponseEntity.ok(user);
    }
}
