package com.example.demo.service;

import com.example.demo.controller.UserController;
import com.example.demo.reponsitory.StudentRepository;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.reponsitory.UserRepository;

import javax.management.RuntimeErrorException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;


    public User registerUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())){
            throw new RuntimeException("Đã tồn tại người dùng có email trên !");
        }
        //-------------student---------------\
        if("STUDENT".equalsIgnoreCase(userDTO.getRole())){
            Student student = new Student();
            student.setEmail(userDTO.getEmail());
            student.setPassword(userDTO.getPassword());
            student.setRole("STUDENT");
            student.setMsv(userDTO.getMsv()); 
            student.setName(userDTO.getName());
            return studentRepository.save(student);
        }

        //  ADMIN or STAFF
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole().toUpperCase());
        
        return userRepository.save(user);
        // user.setEmail(userDTO.getEmail());
        // user.setPassword(userDTO.getPassword());
        // user.setRole(userDTO.getRole());
        // return userRepository.save(user);
    }
    public User resetPassword(String email, String newPass){
        User user = userRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("Không tìm thấy người dùng"));
        user.setPassword(newPass);
        return userRepository.save(user);
    }
}
