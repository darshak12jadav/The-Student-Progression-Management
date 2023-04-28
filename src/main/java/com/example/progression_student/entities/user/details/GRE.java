package com.example.progression_student.entities.user.details;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class GRE {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String collegeID;

    private String examDate;

    private String verbalReasoning;

    private String quantitativeReasoning;

    private String analyticalWriting;

    private String registrationNumber;

    private String batch;
    private String branch;

    public GRE() {
    }

    public String getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(String collegeID) {
        this.collegeID = collegeID;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getVerbalReasoning() {
        return verbalReasoning;
    }

    public void setVerbalReasoning(String verbalReasoning) {
        this.verbalReasoning = verbalReasoning;
    }

    public String getQuantitativeReasoning() {
        return quantitativeReasoning;
    }

    public void setQuantitativeReasoning(String quantitativeReasoning) {
        this.quantitativeReasoning = quantitativeReasoning;
    }

    public String getAnalyticalWriting() {
        return analyticalWriting;
    }

    public void setAnalyticalWriting(String analyticalWriting) {
        this.analyticalWriting = analyticalWriting;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
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
