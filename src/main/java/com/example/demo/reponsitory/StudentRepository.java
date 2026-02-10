package com.example.demo.reponsitory;

import com.example.demo.entity.Student;
import com.example.demo.entity.StudentClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Optional<Student> findByMsv(String msv);
    List<Student> findByStudentClass_Id(Long class_id);
    

    // Kiểm tra tồn tại MSSV
    boolean existsByMsv(String msv);


}
