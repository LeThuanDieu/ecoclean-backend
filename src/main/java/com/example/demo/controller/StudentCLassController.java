package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentClassDTO;
import com.example.demo.entity.Student;
import com.example.demo.entity.StudentClass;
import com.example.demo.reponsitory.StudentClassRepository;
import com.example.demo.service.StudentClassService;
import com.example.demo.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/v1/classes")
@Tag(name = "Student Class Controller")

public class StudentCLassController {
    @Autowired
    StudentClassService studentClassService;
    // StudentService st;

    @GetMapping("")
    public List<StudentClass> getAll() {
        return studentClassService.getAllClass();
    }
    @PostMapping("")
    public StudentClass createClass(@RequestBody StudentClassDTO dto) {
        return studentClassService.createClass(dto);
    }
    @PutMapping("/{id}")
    public StudentClass updateClass(@PathVariable Long id, @RequestBody StudentClassDTO dto) {
        return studentClassService.updateClass(id,dto);
    }
    @DeleteMapping("/{id}")
    public String deleteClass(@PathVariable Long id){
        studentClassService.deleteClass(id);
        return "Đã xóa lớp !";
    }
    @Operation(summary = "Danh sách lớp theo khoa")
    @GetMapping("/class/faculty_id")
    public List<StudentClass> getClassFaculty(@RequestParam Long id) {
        return studentClassService.findClassByIdFaculty(id);
    }
    @Operation(summary = "Danh sách sinh viên của lớp")
    @GetMapping("/{id}/students")
    public List<Student> getStudentsByClassId (@PathVariable Long id) {
        return studentClassService.findStudentByIdClass(id);
    }  
    
    
}
