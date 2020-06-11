package com.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userservice.bean.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Integer> {

}
