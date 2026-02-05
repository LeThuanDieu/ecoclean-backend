package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.entity.StudentClass;
import com.example.demo.reponsitory.StudentClassReponsitory;
import com.example.demo.reponsitory.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentClassReponsitory studentClassReponsitory;
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public Student createStudent(StudentDTO studentDTO){
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setMsv(studentDTO.getMsv());
        StudentClass studentClass = studentClassReponsitory
                .findById(studentDTO.getClassId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy lớp"));

        student.setStudentClass(studentClass);
        return studentRepository.save(student);
    }
    public Student updateStudent(Long id, StudentDTO studentDTO){
        Student student = studentRepository.findById(id).orElseThrow(()->new RuntimeException("Không tìm thấy id "));
        student.setName(studentDTO.getName());
        student.setMsv(studentDTO.getMsv());
        StudentClass studentClass = studentClassReponsitory
                .findById(studentDTO.getClassId())
                .orElseThrow(()-> new RuntimeException("Không tìm tấy lớp "));
        student.setStudentClass(studentClass);
        return studentRepository.save(student);
    }
    public void deleteStudent(Long id){
        if(!studentRepository.existsById(id)){
            throw  new RuntimeException("Không tìm thấy sinh viên !");
        }
        studentRepository.deleteById(id);
    }
}
