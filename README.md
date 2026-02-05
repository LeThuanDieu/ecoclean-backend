# 🌱 EcoClean Student Management System

Ứng dụng **quản lý sinh viên và hoạt động EcoClean** trong môi trường đại học, được xây dựng bằng **Java Spring Boot**.  
Hệ thống hỗ trợ quản lý sinh viên, lớp học, và các hoạt động bảo vệ môi trường như dọn rác, trồng cây, tái chế,…

---

## 🎯 Mục tiêu dự án
- Quản lý thông tin sinh viên theo lớp
- Liên kết sinh viên với các hoạt động EcoClean
- Thực hành Spring Boot + JPA + RESTful API
- Phục vụ đồ án môn học / bài tập lớn / portfolio cá nhân

---

## 🛠️ Công nghệ sử dụng
- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Lombok**
- **Maven**
- **Postman** (test API)

---

## 📁 Cấu trúc project

---

## 🗄️ Thiết kế Database (mô tả)
### Student
- id
- msv
- name
- class_id (FK)

### StudentClass
- id
- name

**Quan hệ:**
- 1 StudentClass ⟶ nhiều Student  
- Student `@ManyToOne` với StudentClass

---

## 📦 Các Entity chính

### Student
```java
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String msv;
    private String name;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private StudentClass studentClass;
}

