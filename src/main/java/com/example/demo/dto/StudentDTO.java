package com.example.demo.dto;

import com.example.demo.entity.StudentClass;
import lombok.Data;

@Data
public class StudentDTO {
    private String name;
    private String msv;
    private Long classId;
}
