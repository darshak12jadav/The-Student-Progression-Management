package com.example.progression_student.repository.admin;

import com.example.progression_student.entities.admin.Student_Details;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface Student_Details_Repository extends JpaRepository<Student_Details,Integer> {

//    @Query("select  e from Student_Details e where e.batch = ?1")
    public List<Student_Details> findByBatchAndBranch(String batch,String branch);

}

