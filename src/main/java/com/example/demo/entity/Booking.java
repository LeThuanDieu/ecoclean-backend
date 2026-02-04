package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name="bookings")
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime bookingDate;
    private String status;
    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
