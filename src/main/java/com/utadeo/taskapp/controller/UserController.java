package com.utadeo.taskapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.utadeo.taskapp.model.User;
import com.utadeo.taskapp.service.IUserService;


@RestController
public class UserController {

    private IUserService userService;

    UserController(IUserService userService){
        this.userService = userService;
    }

    @PostMapping("user/")
    public User store(@RequestBody User user){
        return this.userService.createUser(user);
    }
    
    @PutMapping("/user/{id}")
	public User updateUser(@PathVariable Long id ,@RequestBody User user) {
		return userService.updateUser(id,user);
	}
    
    @GetMapping("/{id}/")
    public User show(@PathVariable("id") Long id){
        return this.userService.getById(id);
    }

    @GetMapping("allusers/")
    public List<User> AllUsers(){
		return userService.getAllUsers();
	}

    @DeleteMapping("/user/{id}/")
	public void deleteUser(@PathVariable("id") Long id) {
		this.userService.deleteUser(id);
	}
    
    
}
