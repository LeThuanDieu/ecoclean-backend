package com.example.demo.dto;

import com.example.demo.entity.StudentClass;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class StudentDTO {
    @Schema(description = "Tên sinh viên", example = "Nguyen Van A")
    private String name;
    @Schema(description = "Mã sinh viên", example = "SV001")
    private String msv;
    @Schema(description = "ID lớp học", example = "1")
    private Long classId;
}
