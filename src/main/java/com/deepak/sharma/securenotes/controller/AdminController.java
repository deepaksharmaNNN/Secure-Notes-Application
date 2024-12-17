package com.deepak.sharma.securenotes.controller;

import com.deepak.sharma.securenotes.dtos.UserDTO;
import com.deepak.sharma.securenotes.model.User;
import com.deepak.sharma.securenotes.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    // Add admin specific APIs here

    //Get all Users
    @GetMapping("/users") // http://localhost:8080/api/admin/users
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    //Update Role
    @PutMapping("/updateRole") // http://localhost:8080/api/admin/updateRole?userId=1&roleName=ROLE_ADMIN
    public ResponseEntity<String> updateRole(@RequestParam Long userId, @RequestParam String roleName){
        String message = userService.updateRole(userId, roleName);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    //Get User Details by Id
    @GetMapping("/user/{userId}") // http://localhost:8080/api/admin/user/1
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId){
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }
}
