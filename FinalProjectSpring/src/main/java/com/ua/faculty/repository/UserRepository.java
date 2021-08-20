package com.ua.faculty.repository;

import com.ua.faculty.entity.User;
import com.ua.faculty.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String login);
}
