package com.example.progression_student.repository.user;

import com.example.progression_student.entities.user.details.GATE;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GATERepository extends JpaRepository<GATE,String> {

    public List<GATE> findByBatchAndBranch(String batch, String branch);

}
