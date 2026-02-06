package com.example.demo.controller;

import com.example.demo.service.ActivityService;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ActivityDTO;
import com.example.demo.entity.Activity;
import com.example.demo.reponsitory.ActivityRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/v1/activities")
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    
    @GetMapping()
    public List<Activity> getAllActivity() {
        return activityService.getAllActivities();
    }

    @PostMapping()
    public Activity createActivity(@RequestBody ActivityDTO activityDTO) {
        return activityService.createActivity(activityDTO);
    }
    @PutMapping("/{id}")
    public Activity updateActivity(@RequestBody ActivityDTO aaActivityDTO, @PathVariable Long id) {
        return activityService.updateActivity(id, aaActivityDTO);
    }
    @DeleteMapping("/{id}")
    public String deleteActivity(@PathVariable Long id){
        activityService.deleteActivity(id);
        return "Đã xóaid= "+ id;
}
}
