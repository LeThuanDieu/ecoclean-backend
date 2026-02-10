package com.example.demo.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
