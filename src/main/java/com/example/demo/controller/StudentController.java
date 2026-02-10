package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@Tag(name = "Student Controller", description = "Danh sách sinh viên" )
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Operation(summary = "Lấy tất cả sinh viên",description = "API lấy tất cả sinh viên")
    @GetMapping
    public List<Student> getAll(){
        return studentService.getAllStudents();
    }

    @Operation(summary = "Lấy thông tin sinh viên theo ma sinh vien")
    @GetMapping("/msv")
    public Student getInStudent(@RequestParam String msv){
       return studentService.getInStudent(msv);
    }
    //--------Create Student ---------
    @Operation(summary = "Tạo mới sinh viên")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Tạo sinh viên thành công"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Dữ liệu không hợp lệ")
    })
    @PostMapping
    public Student create(@RequestBody StudentDTO studentDTO){
        return studentService.createStudent(studentDTO);
    }
    //--------Update Student ---------
    @Operation(summary = "Cập nhật thông tin sinh viên")
    @PutMapping("/{id}")
    public Student update(@Parameter(description = "ID của sinh viên cần cập nhật", example = "1") @PathVariable Long id ,@RequestBody StudentDTO studentDTO){
        return studentService.updateStudent(id,studentDTO);
    }
    //--------Delete Student ---------
    @Operation(summary = "Xóa sinh viên")
    @DeleteMapping("/{id}")
    public String delete( @Parameter(description = "ID của sinh viên cần xóa", example = "1") @PathVariable Long id){
        studentService.deleteStudent(id);
        return "Đã xóa ! "+id;
    }
}
