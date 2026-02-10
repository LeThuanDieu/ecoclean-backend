package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name ="students")
@EqualsAndHashCode(callSuper = true)
public class Student extends User{
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long id;

    @Column(unique = true, nullable = false)
    private String msv;
    private String name;
    @ManyToOne
    @JoinColumn(name = "class_id")
    @JsonIgnore
    private StudentClass studentClass;
}
