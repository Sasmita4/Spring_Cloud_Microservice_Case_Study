package com.userservice.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.userservice.bean.UserInfo;
import com.userservice.service.UserService;

/**
 * 
 * @author sasmitam
 * 
 * Rest API's to handle User CRUD Operations
 * 
 */

@RestController
public class UserResource {
	
	@Autowired
	UserService userService;
	
	/*
	 * Get All Users
	 */
	@GetMapping("/getAllUser")
	@HystrixCommand(fallbackMethod = "getAllUsersFallBack")
	public ResponseEntity<List<UserInfo>> getAllUsers() {
		List<UserInfo> arlUsers = userService.findAllUsers();
		return new ResponseEntity<List<UserInfo>>(arlUsers, HttpStatus.OK);
	}
	
	public ResponseEntity<List<UserInfo>> getAllUsersFallBack() {
		return new ResponseEntity<List<UserInfo>>(
				Arrays.asList(new UserInfo(10, "", "", "", "","")), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/*
	 * Get User Based on userId
	 */
	@GetMapping("/getUserById/{id}")
	@HystrixCommand(fallbackMethod = "getUserByIdFallBack")
	public ResponseEntity<UserInfo> getUserById(@PathVariable("id") int id) {
		UserInfo responseObj = userService.findUserById(id);
		return new ResponseEntity<UserInfo>(responseObj, HttpStatus.OK);
	}
	
	public ResponseEntity<UserInfo> getUserByIdFallBack(@PathVariable("id") int id) {
		userService.findUserById(id);
		return new ResponseEntity<UserInfo>(new UserInfo(10, "", "", "", "",""), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/*
	 * Register User 
	 */
	@PostMapping("/createUser")
	@HystrixCommand(fallbackMethod = "createUserFallBack")
	public ResponseEntity<Object> createUser(@RequestBody UserInfo user) {
		UserInfo responseObj = userService.createUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(responseObj.getnUserId());
		return ResponseEntity.created(location).build();
	}
	
	public ResponseEntity<Object> createUserFallBack(@RequestBody UserInfo user) {
		return new ResponseEntity<Object>(user, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/*
	 * Update an User object
	 */
	@PutMapping("/updateUser")
	@HystrixCommand(fallbackMethod = "updateUserFallBack")
	public ResponseEntity<UserInfo> updateUser(@RequestBody UserInfo userObj) {
		UserInfo responseObj = userService.updateUser(userObj);
		return new ResponseEntity<UserInfo>(responseObj, HttpStatus.CREATED);	
	}
	
	public ResponseEntity<UserInfo> updateUserFallBack(@RequestBody UserInfo userObj) {
		return new ResponseEntity<UserInfo>(userObj, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/*
	 * Delete an User Based on UserId
	 */
	@DeleteMapping("/deleteUserById/{id}")
	@HystrixCommand(fallbackMethod = "deleteUserByIdFallBack")
	public ResponseEntity<Object> deleteUserById(@PathVariable("id") int id) {
		userService.deleteUserById(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	public ResponseEntity<Object> deleteUserByIdFallBack(@PathVariable("id") int id) {
		return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
