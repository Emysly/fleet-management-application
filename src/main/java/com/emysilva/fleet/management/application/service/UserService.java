package com.emysilva.fleet.management.application.service;

import com.emysilva.fleet.management.application.exception.NoSuchDataException;
import com.emysilva.fleet.management.application.model.Client;
import com.emysilva.fleet.management.application.model.User;
import com.emysilva.fleet.management.application.repository.ClientRepository;
import com.emysilva.fleet.management.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User getUser(int id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchDataException("user with id: " + id + "not found"));
    }

    public void deleteUser(int id) {
        User userToDelete = userRepository.findById(id).orElseThrow(() -> new NoSuchDataException("user with id: " + id + "not found"));
        userRepository.delete(userToDelete);
    }
}
