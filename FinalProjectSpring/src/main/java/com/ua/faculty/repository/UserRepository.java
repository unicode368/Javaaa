package com.ua.faculty.repository;

import com.ua.faculty.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
