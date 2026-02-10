package com.example.demo.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Participation;

public interface ParticipationRepository extends JpaRepository<Participation,Long> {

    
}
