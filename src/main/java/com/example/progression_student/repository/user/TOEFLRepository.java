package com.example.progression_student.repository.user;

import com.example.progression_student.entities.user.details.TOEFL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TOEFLRepository extends JpaRepository<TOEFL,String> {

    public List<TOEFL> findByBatchAndBranch(String batch, String branch);

}
