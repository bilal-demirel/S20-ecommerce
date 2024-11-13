package com.demirel.ecommerce.service;

import com.demirel.ecommerce.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User addUser(User user);
    User deleteUserById(Long id);
    User updateUser(User user);
}
