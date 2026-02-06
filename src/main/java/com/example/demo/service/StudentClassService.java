package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentClass;
import com.example.demo.reponsitory.StudentClassReponsitory;

@Service
public class StudentClassService {
    @Autowired
    StudentClassReponsitory studentClassReponsitory;
    public List<StudentClass> getAllClass() {
        return studentClassReponsitory.findAll();
    }   
}
