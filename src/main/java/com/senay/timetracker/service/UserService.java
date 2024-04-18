package com.senay.timetracker.service;

import com.senay.timetracker.entity.User_Task;
import com.senay.timetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User_Task> getAllUsers() {
        return userRepository.findAll();
    }

    public User_Task createUser(User_Task user) {
        return userRepository.save(user);
    }

    public User_Task getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User_Task updateUser(Long id, User_Task user) {
        return user;
    }
}