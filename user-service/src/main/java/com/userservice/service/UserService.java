package com.userservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.bean.UserInfo;
import com.userservice.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public UserInfo createUser(UserInfo userObj) {
		return userRepository.save(userObj);
	}
	
	public UserInfo findUserById(int id) {
		Optional<UserInfo> userObj = userRepository.findById(id);
		return userObj.get();
	}
	
	public List<UserInfo> findAllUsers() {
		return userRepository.findAll();
	}
	
	public UserInfo updateUser(UserInfo userObj) {
		return userRepository.save(userObj);
	}
	
	public void deleteUserById(int id) {
		userRepository.deleteById(id);
	}
	/*
	public void validateLogin(User userObj) {
		userRepository.validateLogin(userObj);
	}*/
}
