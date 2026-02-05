package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAll(){
        return studentService.getAllStudents();
    }
    @PostMapping
    public Student create(@RequestBody StudentDTO studentDTO){
        return studentService.createStudent(studentDTO);
    }
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id ,@RequestBody StudentDTO studentDTO){
        return studentService.updateStudent(id,studentDTO);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "Đã xóa ! "+id;
    }
}
