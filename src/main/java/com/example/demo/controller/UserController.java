package com.example.demo.controller;


import com.example.demo.dto.ResetPassDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/users")
public class UserController{
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO){
       try {
        User user = userService.registerUser(userDTO);
        return ResponseEntity.ok(user);
       } catch (Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
       }
    }
    @PutMapping("/resetPassword/{email}")
    public ResponseEntity<?> reset(@RequestBody ResetPassDTO resetPassDTO){
       try {
        User user = userService.resetPassword(resetPassDTO.getEmail(), resetPassDTO.getNewPassword());
        return ResponseEntity.ok(user);
        
       } catch (Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
       } 
    }
    
}
