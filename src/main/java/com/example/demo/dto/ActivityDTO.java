package com.example.demo.dto;

import lombok.Data;

@Data
public class ActivityDTO {
    // private Long id;
    private String activityName;
    private String dateTime;
    private String location;
    private int score;
}
