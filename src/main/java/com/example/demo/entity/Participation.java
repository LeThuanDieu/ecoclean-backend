package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "participattion")
public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student ;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;
    private boolean checkedIn;
}
