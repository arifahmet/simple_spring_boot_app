package com.arifahmet.task1.service.impl;

import com.arifahmet.task1.domain.User;
import com.arifahmet.task1.repository.UserRepository;
import com.arifahmet.task1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsersByName(String name) {
        return userRepository.findByNameIgnoreCase(name);
    }
    public User addUser(User user){
        return userRepository.save(user);
    }

}
