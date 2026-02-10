package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.FacultyDTO;
import com.example.demo.entity.Faculty;
import com.example.demo.reponsitory.FacultyRepository;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyReponsitory;

    public List<Faculty> getAllFaculties(){
        return facultyReponsitory.findAll();
    }
    public Faculty createFaculty(FacultyDTO facultyDTO){
        Faculty faculty = new Faculty();
        faculty.setNameFaculty(facultyDTO.getFacultyName());
        return facultyReponsitory.save(faculty);
    }
    public Faculty updateFaculty(Long id, FacultyDTO facultyDTO){
        Faculty faculty = facultyReponsitory.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khoa với id: " + id));
        faculty.setNameFaculty(facultyDTO.getFacultyName());
        return facultyReponsitory.save(faculty);
    }
    public void deleteFaculty(Long id){
        Faculty faculty = facultyReponsitory.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy khoa với id: " + id));
        facultyReponsitory.delete(faculty);
    }
    public Faculty getFacultyById(Long id){
        return facultyReponsitory.findById(id).orElseThrow(()->new RuntimeException("Không tìm thấy khoa đó "));
    }
}