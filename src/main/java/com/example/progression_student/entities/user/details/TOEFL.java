package com.example.progression_student.entities.user.details;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class TOEFL {


        @Id
        private String appointmentNumber;
        private String collegeID;

        private String examDate;
        private String listeningScore;

        private String readingScore;

        private String writingScore;

        private String speakingScore;

                private String Score;

        private String batch;
        private String branch;


        public TOEFL() {
        }

        public TOEFL(String collegeID, String examDate, String listeningScore, String readingScore, String writingScore, String speakingScore, String score) {
                this.collegeID = collegeID;
                this.examDate = examDate;
                this.listeningScore = listeningScore;
                this.readingScore = readingScore;
                this.writingScore = writingScore;
                this.speakingScore = speakingScore;
                Score = score;
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

        public String getListeningScore() {
                return listeningScore;
        }

        public void setListeningScore(String listeningScore) {
                this.listeningScore = listeningScore;
        }

        public String getReadingScore() {
                return readingScore;
        }

        public void setReadingScore(String readingScore) {
                this.readingScore = readingScore;
        }

        public String getWritingScore() {
                return writingScore;
        }

        public void setWritingScore(String writingScore) {
                this.writingScore = writingScore;
        }

        public String getSpeakingScore() {
                return speakingScore;
        }

        public void setSpeakingScore(String speakingScore) {
                this.speakingScore = speakingScore;
        }

        public String getScore() {
                return Score;
        }

        public void setScore(String score) {
                Score = score;
        }

        public String getAppointmentNumber() {
                return appointmentNumber;
        }

        public void setAppointmentNumber(String appointmentNumber) {
                this.appointmentNumber = appointmentNumber;
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
