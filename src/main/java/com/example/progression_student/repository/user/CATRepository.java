package com.example.progression_student.repository.user;

import com.example.progression_student.entities.admin.Student_Details;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.progression_student.entities.user.details.CAT;

import java.util.List;

public interface CATRepository extends JpaRepository<CAT,Integer> {

    public List<CAT> findByBatchAndBranch(String batch, String branch);


}
