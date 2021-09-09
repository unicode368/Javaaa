package com.ua.faculty.repository;

import com.ua.faculty.entity.Role;
import com.ua.faculty.entity.User;
import com.ua.faculty.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findById(Long id);
    Optional<User> findByLogin(String login);
    Optional<Set<User>> findAllByRoles(Role role);
}
