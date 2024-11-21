package com.example.service;

import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import com.example.model.UserRequest;
import com.example.model.User;

@Service
public class UserService {

    private final Map<Long, User> userDatabase = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    public User createUser(UserRequest userRequest) {
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setName(userRequest.getName());
        user.setId(idCounter.incrementAndGet());
        userDatabase.put(user.getId(), user);
        return user;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userDatabase.values());
    }

    public Optional<User> getUserById(Long id) {
        return Optional.ofNullable(userDatabase.get(id));
    }

    public boolean deleteUser(Long id) {
        return userDatabase.remove(id) != null;
    }
}
