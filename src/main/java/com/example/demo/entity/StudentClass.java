package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "class")
public class StudentClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameClass;
    
    @ManyToOne
    @JoinColumn(name="faculty_id")
    private Faculty faculty;

    @OneToMany(mappedBy = "studentClass")
    @JsonIgnore
    private List<Student> student;

}
