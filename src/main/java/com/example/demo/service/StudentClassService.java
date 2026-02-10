package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentClassDTO;
import com.example.demo.entity.Faculty;
import com.example.demo.entity.Student;
import com.example.demo.entity.StudentClass;
import com.example.demo.reponsitory.FacultyRepository;
import com.example.demo.reponsitory.StudentClassRepository;
import com.example.demo.reponsitory.StudentRepository;

@Service
public class StudentClassService {
    @Autowired
    StudentClassRepository studentClassReponsitory;
    @Autowired
    FacultyRepository facultyReponsitory;
    @Autowired
    StudentRepository   studentRepository;
    public List<StudentClass> getAllClass() {
        return studentClassReponsitory.findAll();
    }
    public StudentClass createClass(StudentClassDTO dto) {
        StudentClass studentClass = new StudentClass();
        studentClass.setNameClass(dto.getClassName());
        Faculty faculty = facultyReponsitory.findById(dto.getFacultyId()).orElseThrow(()-> new RuntimeException("Không tìm thấy khoa "));
        studentClass.setFaculty(faculty);
        return studentClassReponsitory.save(studentClass);
    }
    public StudentClass updateClass(Long id, StudentClassDTO dto) {
        StudentClass studentClass = studentClassReponsitory.findById(id).orElseThrow(()-> new RuntimeException("Không tìm thấy "));
        studentClass.setNameClass(dto.getClassName());
        Faculty faculty = facultyReponsitory.findById(dto.getFacultyId()).orElseThrow(()-> new RuntimeException("Không tìm thấy "));
        studentClass.setFaculty(faculty);
        return studentClassReponsitory.save(studentClass);
    }
    public String deleteClass(Long id) {
        StudentClass studentClass = studentClassReponsitory.findById(id).orElseThrow(()->new RuntimeException("Không tìm thấy id cần xóa "));
        for(Student student: studentClass.getStudent()){
            student.setStudentClass(null);
        }
        studentClassReponsitory.delete(studentClass);
        return "Đã xóa ";
    }
    public List<StudentClass> findClassByIdFaculty(Long id) {
        Faculty faculty = facultyReponsitory.findById(id).orElseThrow(()-> new RuntimeException("Không tìm thấy khoa cần tìm "));
        return  studentClassReponsitory.findClassByFaculty(faculty);

    }
    public List<Student> findStudentByIdClass(Long id) {
        studentClassReponsitory.findById(id).orElseThrow(()->new RuntimeException("Không tìm thấy lớp cần tìm"));
        return studentRepository.findByStudentClass_Id(id);
    }   
}
