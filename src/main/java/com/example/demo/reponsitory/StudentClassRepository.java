package com.example.demo.reponsitory;

import com.example.demo.entity.Faculty;
import com.example.demo.entity.Student;
import com.example.demo.entity.StudentClass;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentClassRepository extends JpaRepository<StudentClass, Long> {

    List<StudentClass> findClassByFaculty(Faculty faculty);

    

}
