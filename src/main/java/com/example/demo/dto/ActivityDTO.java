package com.example.demo.dto;

import lombok.Data;

@Data
public class ActivityDTO {
    private Long id;
    private String activityName;
    private String dateTime;
    private int score;
}
