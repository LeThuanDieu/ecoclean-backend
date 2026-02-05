package com.example.demo.config;

import com.example.demo.entity.Student;
import com.example.demo.entity.StudentClass;
import com.example.demo.reponsitory.StudentClassReponsitory;
import com.example.demo.reponsitory.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner init(StudentRepository studentRepo, StudentClassReponsitory classRepo) {
        return args -> {
            // 1. Tạo và lưu Class trước (Vì Student cần ID của Class)
            if (classRepo.count() == 0) {
                StudentClass c1 = new StudentClass();
                c1.setNameClass("Lớp Công nghệ thông tin 1");
                classRepo.save(c1);

                StudentClass c2 = new StudentClass();
                c2.setNameClass("Lớp An toàn thông tin");
                classRepo.save(c2);

                // 2. Tạo Student và gán Class tương ứng
                Student s1 = new Student();
                s1.setMsv("B21DCCN001");
                s1.setName("Nguyễn Văn A");
                s1.setStudentClass(c1); // Gán vào lớp 1
                studentRepo.save(s1);

                Student s2 = new Student();
                s2.setMsv("B21DCCN002");
                s2.setName("Trần Thị B");
                s2.setStudentClass(c1); // Cũng học lớp 1
                studentRepo.save(s2);

                Student s3 = new Student();
                s3.setMsv("B21DCAT001");
                s3.setName("Lê Văn C");
                s3.setStudentClass(c2); // Học lớp 2
                studentRepo.save(s3);

                System.out.println("--- Đã thêm dữ liệu test thành công! ---");
            }

        };
    }
}
