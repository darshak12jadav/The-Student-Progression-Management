package com.example.progression_student.entities.admin;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"college_id"}),
        @UniqueConstraint(columnNames = {"email_id"})
})
public class Student_Details {
    @Id

    private Integer id;
    private String batch;
    private String branch;

    @Column(name = "college_id")
    private String college_id;

    private String email_id;
    private String full_name;
    private String roll_no;

    public Student_Details() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setCollege_id(String college_id) {
        this.college_id = college_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setRoll_no(String roll_no) {
        this.roll_no = roll_no;
    }

    public Integer getId() {
        return id;
    }

    public String getBatch() {
        return batch;
    }

    public String getBranch() {
        return branch;
    }

    public String getCollege_id() {
        return college_id;
    }

    public String getEmail_id() {
        return email_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getRoll_no() {
        return roll_no;
    }


}
