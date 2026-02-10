package com.example.demo.config;

import com.example.demo.entity.*; // Chỉnh lại package entity của bạn
import com.example.demo.reponsitory.*; // Chỉnh lại package repository của bạn
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(
            StudentRepository studentRepo, 
            StudentClassRepository classRepo,
            FacultyRepository facultyRepo,
            ActivityRepository activityRepo,
            ParticipationRepository participationRepo,
            UserRepository userRepo) {
            
        return args -> {
            // Kiểm tra nếu chưa có Khoa nào thì mới tạo dữ liệu (Tránh trùng lặp)
            if (facultyRepo.count() == 0) {
                System.out.println("--- Đang bắt đầu khởi tạo dữ liệu mẫu cho EcoClean ---");

                // 1. Tạo Khoa (Faculty)
                Faculty f1 = new Faculty();
                f1.setNameFaculty("Khoa Công nghệ thông tin");
                facultyRepo.save(f1);

                // 2. Tạo Lớp (StudentClass) - Cần Faculty trước
                StudentClass c1 = new StudentClass();
                c1.setNameClass("Lớp 21CNTT01");
                c1.setFaculty(f1);
                classRepo.save(c1);

                // 3. Tạo Sinh viên (Student kế thừa từ User)
                // Vì bạn dùng JOINED, Hibernate sẽ tự lo việc lưu vào cả 2 bảng users và students
                Student s1 = new Student();
                s1.setEmail("dieu.le@student.com");
                s1.setPassword("password123");
                s1.setName("Lê Thuận Diệu");
                s1.setMsv("B21DCCN001");
                s1.setStudentClass(c1); // Gán vào lớp vừa tạo
                studentRepo.save(s1);

                // 4. Tạo Hoạt động (Activity)
                Activity a1 = new Activity();
                a1.setNameActivity("Chiến dịch dọn rác bãi biển Xuân Thiều");
                a1.setLocation("Liên Chiểu, Đà Nẵng");
                a1.setDateTime("2026-03-15 07:30");
                a1.setScore(50);
                activityRepo.save(a1);

                // 5. Tạo Tham gia (Participation) - Kết nối Sinh viên và Hoạt động
                // Participation p1 = new Participation();
                // p1.setStudent(s1);
                // p1.setActivity(a1);
                // p1.setCheckedIn(false); // Mặc định chưa điểm danh
                // participationRepo.save(p1);

                System.out.println("--- Khởi tạo dữ liệu mẫu hoàn tất! ---");
            }
        };
    }
}