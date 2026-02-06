package com.example.demo.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;

import com.example.demo.entity.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
