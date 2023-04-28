package com.example.progression_student.repository.user;

import com.example.progression_student.entities.user.details.GRE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface GRERepository extends JpaRepository<GRE,Integer> {
    public boolean existsByRegistrationNumber(String registrationNumber);

    public List<GRE>  findByBatchAndBranch(String batch, String branch);

}
