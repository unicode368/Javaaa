package com.ua.faculty.repository;

import com.ua.faculty.entity.Role;
import com.ua.faculty.entity.User;
import com.ua.faculty.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {
    Optional<UserInfo> findByEmail(String email);
    Optional<Set<UserInfo>> findAllByUser(User user);
}
