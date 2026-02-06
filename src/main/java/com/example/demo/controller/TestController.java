package com.example.demo.controller;

import com.example.demo.service.StudentClassService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.StudentClass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/v1/test")
public class TestController {
    @Autowired
    StudentClassService studentClassService;
    @GetMapping
    public String test() {
        return "Có ";
    }

    @GetMapping("/classStudent")
    public List<StudentClass> getClassStudent() {
        return studentClassService.getAllClass();
    }
    
}
