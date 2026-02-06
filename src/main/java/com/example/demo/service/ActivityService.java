package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ActivityDTO;
import com.example.demo.entity.Activity;
import com.example.demo.reponsitory.ActivityRepository;

@Service
public class ActivityService {
    @Autowired
    ActivityRepository activityRepository;

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();  
    }     

    public Activity createActivity(ActivityDTO activityDTO) {
        Activity activity = new Activity();
        activity.setNameActivity(activityDTO.getActivityName());
        activity.setDateTime(activityDTO.getDateTime());
        activity.setScore(activityDTO.getScore());
        return activityRepository.save(activity);
    }

    public Activity updateActivity(Long id, ActivityDTO activityDTO) {
        Activity activity = activityRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy id "));
        activity.setNameActivity(activityDTO.getActivityName());
        activity.setDateTime(activityDTO.getDateTime());
        activity.setScore(activityDTO.getScore());
        return activityRepository.save(activity);
    }
    

    public void deleteActivity( Long id) {
    
        if(!activityRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy hoạt động !");
        }
        activityRepository.deleteById(id);
    }
}

