package com.example.demo.dto;

import com.example.demo.entity.Faculty;
import com.example.demo.entity.StudentClass;

import lombok.Data;

@Data
public class StudentClassDTO {
    private String className;
    private Long facultyId;


}
