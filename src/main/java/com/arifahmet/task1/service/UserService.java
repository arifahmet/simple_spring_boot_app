package com.arifahmet.task1.service;

import com.arifahmet.task1.domain.User;

import java.util.List;

public interface UserService {
    List<User> getUsersByName(String name);
    User addUser(User user);
}
