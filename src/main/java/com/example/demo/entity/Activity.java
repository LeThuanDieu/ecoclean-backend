package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nameActivity;
    private String location;
    private String dateTime;
    private int score;

//    @OneToMany(mappedBy = "activity",cascade = CascadeType.ALL)
//    private List<Participation> participationList;
}
