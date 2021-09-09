package com.ua.faculty.repository;

import com.ua.faculty.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {
}
