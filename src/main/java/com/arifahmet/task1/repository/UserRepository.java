package com.arifahmet.task1.repository;

import com.arifahmet.task1.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByNameIgnoreCase(String name);
}
