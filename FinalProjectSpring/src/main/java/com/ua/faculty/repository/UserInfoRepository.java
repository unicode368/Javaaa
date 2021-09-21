package com.ua.faculty.repository;

import com.ua.faculty.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {
    Optional<UserInfo> findByEmail(String email);
}
