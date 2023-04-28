package com.example.progression_student.service.admin;


import com.example.progression_student.entities.admin.Student_Details;
import com.example.progression_student.entities.user.details.GATE;
import com.example.progression_student.helper.ExcelHelper;
import com.example.progression_student.repository.admin.Student_Details_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class Student_Details_Service {
    @Autowired
    private Student_Details_Repository student_details_repository;

    public boolean save(MultipartFile multipartFile) {
        try {
            List<Student_Details> studentDetailsList = ExcelHelper.covertExcelToListOfStudent(multipartFile.getInputStream());
            this.student_details_repository.saveAll(studentDetailsList);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public List<Student_Details> getStudent_DetailsByBatchAndBranch(String batch,String branch) {
        return student_details_repository.findByBatchAndBranch(batch,branch);
//        return null;
    }

}
