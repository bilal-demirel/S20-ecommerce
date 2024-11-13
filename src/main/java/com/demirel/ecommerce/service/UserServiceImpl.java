package com.demirel.ecommerce.service;

import com.demirel.ecommerce.entity.User;
import com.demirel.ecommerce.exception.UserNotFoundException;
import com.demirel.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        } else {
            throw new UserNotFoundException("User ID that you entered does not exist!");
        }
    }

    @Override
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User deleteUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            userRepository.deleteById(id);
            return optionalUser.get();
        } else {
            throw new UserNotFoundException("User ID that you entered does not exist!");
        }
    }

    @Override
    public User updateUser(User user){
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if(optionalUser.isPresent()){
            optionalUser.get().setBirthDate(user.getBirthDate());
            optionalUser.get().setEmail(user.getEmail());
            optionalUser.get().setRole(user.getRole());
            optionalUser.get().setPassword(user.getPassword());
            optionalUser.get().setUsername(user.getUsername());
            userRepository.save(optionalUser.get());
            return optionalUser.get();
        } else {
            throw new UserNotFoundException("User ID that you entered does not exist!");
        }
    }
}
