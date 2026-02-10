package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.List;

@Entity
@Table(name="users")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    
    private String role; //ADMIN, STAFF, STUDENT

//    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
//    private List<Student> studentList;

}
