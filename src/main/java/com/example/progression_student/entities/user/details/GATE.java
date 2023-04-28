package com.example.progression_student.entities.user.details;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class GATE {
    private String collegeID;

    @Id
    private String registrationNumber;

    private String examDate;

    private String gateScore;

    private String Marks;

    private String allIndiaRank;

    private String batch;
    private String branch;


    public GATE() {
    }

    public String getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(String collegeID) {
        this.collegeID = collegeID;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getGateScore() {
        return gateScore;
    }

    public void setGateScore(String gateScore) {
        this.gateScore = gateScore;
    }

    public String getMarks() {
        return Marks;
    }

    public void setMarks(String marks) {
        Marks = marks;
    }

    public String getAllIndiaRank() {
        return allIndiaRank;
    }

    public void setAllIndiaRank(String allIndiaRank) {
        this.allIndiaRank = allIndiaRank;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
