package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FacultyDTO;
import com.example.demo.entity.Faculty;
import com.example.demo.service.FacultyService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/v1/facults")
@Tag(name = "Faculty Controller" )
public class FacultController {
    @Autowired 
    FacultyService facultyService;

    @GetMapping("")
    public List<Faculty> getAll() {
        return facultyService.getAllFaculties();
    }
    @PostMapping("")
    public Faculty createFaculty(@RequestBody FacultyDTO facultyDTO) {
        return facultyService.createFaculty(facultyDTO);
    }
    @GetMapping("/{id}")
    public Faculty findFaculty(@PathVariable Long id) {
        return facultyService.getFacultyById(id);
    }
    @PutMapping("/{id}")
    public Faculty updateFaculty(@PathVariable Long id, @RequestBody FacultyDTO facultyDTO) {

        return facultyService.updateFaculty(id, facultyDTO);
    }
    @DeleteMapping("/{id}")
    public String deleteFaculty(@PathVariable Long id){
        facultyService.deleteFaculty(id);
        return "Xóa khoa thành công";
    }
    
    
}
