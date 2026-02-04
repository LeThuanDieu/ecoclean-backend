package com.example.demo.service;

import com.example.demo.entity.Booking;
import com.example.demo.reponsitory.BookingReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingReponsitory bookingReponsitory;

    public Booking createBooking(Booking booking){
        booking.setStatus("PENDING");
        booking.setBookingDate(LocalDateTime.now());
        return bookingReponsitory.save(booking);
    }
    public List<Booking> getAllBookings(){
        return bookingReponsitory.findAll();
    }
}
