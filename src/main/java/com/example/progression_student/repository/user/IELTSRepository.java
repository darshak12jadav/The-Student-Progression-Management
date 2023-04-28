package com.example.progression_student.repository.user;

import com.example.progression_student.entities.user.details.IELTS;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IELTSRepository extends JpaRepository<IELTS,String> {

    public List<IELTS>  findByBatchAndBranch(String batch, String branch);
}
