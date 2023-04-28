package com.example.progression_student.entities.user.details;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CAT {

    @Id
    private int registrationNumber;
    private String collegeID;
    private String examDate;
    private String verbalAbility_ReadingComprehension_score;
    private String verbalAbility_ReadingComprehension_percentile;
    private String dataInterpretation_LogicalReasoning_score;
    private String dataInterpretation_LogicalReasoning_percentile;
    private String quantitativeAbility_score;
    private String quantitativeAbility_percentile;
    private String overall_score;
    private String overall_percentile;
    private String batch;
    private String branch;

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
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

    public String getVerbalAbility_ReadingComprehension_score() {
        return verbalAbility_ReadingComprehension_score;
    }

    public void setVerbalAbility_ReadingComprehension_score(String verbalAbility_ReadingComprehension_score) {
        this.verbalAbility_ReadingComprehension_score = verbalAbility_ReadingComprehension_score;
    }

    public String getVerbalAbility_ReadingComprehension_percentile() {
        return verbalAbility_ReadingComprehension_percentile;
    }

    public void setVerbalAbility_ReadingComprehension_percentile(String verbalAbility_ReadingComprehension_percentile) {
        this.verbalAbility_ReadingComprehension_percentile = verbalAbility_ReadingComprehension_percentile;
    }

    public String getDataInterpretation_LogicalReasoning_score() {
        return dataInterpretation_LogicalReasoning_score;
    }

    public void setDataInterpretation_LogicalReasoning_score(String dataInterpretation_LogicalReasoning_score) {
        this.dataInterpretation_LogicalReasoning_score = dataInterpretation_LogicalReasoning_score;
    }

    public String getDataInterpretation_LogicalReasoning_percentile() {
        return dataInterpretation_LogicalReasoning_percentile;
    }

    public void setDataInterpretation_LogicalReasoning_percentile(String dataInterpretation_LogicalReasoning_percentile) {
        this.dataInterpretation_LogicalReasoning_percentile = dataInterpretation_LogicalReasoning_percentile;
    }

    public String getQuantitativeAbility_score() {
        return quantitativeAbility_score;
    }

    public void setQuantitativeAbility_score(String quantitativeAbility_score) {
        this.quantitativeAbility_score = quantitativeAbility_score;
    }

    public String getQuantitativeAbility_percentile() {
        return quantitativeAbility_percentile;
    }

    public void setQuantitativeAbility_percentile(String quantitativeAbility_percentile) {
        this.quantitativeAbility_percentile = quantitativeAbility_percentile;
    }

    public String getOverall_score() {
        return overall_score;
    }

    public void setOverall_score(String overall_score) {
        this.overall_score = overall_score;
    }

    public String getOverall_percentile() {
        return overall_percentile;
    }

    public void setOverall_percentile(String overall_percentile) {
        this.overall_percentile = overall_percentile;
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
