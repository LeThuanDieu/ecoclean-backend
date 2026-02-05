package com.example.demo.reponsitory;

import com.example.demo.entity.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentClassReponsitory extends JpaRepository<StudentClass, Long> {
}
