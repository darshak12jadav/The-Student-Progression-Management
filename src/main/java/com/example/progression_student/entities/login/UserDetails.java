package com.example.progression_student.entities.login;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String fullName;
    private String email;
    private String mobileno;
    private String password;

    private String role;

    private boolean accountNonLocked;

    private boolean enabled;
    private  String verificationCode;

    public UserDetails() {
    }

    public UserDetails(int id, String fullName, String email, String mobileno,
                       String password, String role,
                       boolean accountNonLocked, boolean enabled, String verificationCode) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.mobileno = mobileno;
        this.password = password;
        this.role = role;
        this.accountNonLocked = accountNonLocked;
        this.enabled = enabled;
        this.verificationCode = verificationCode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileno() {
        return mobileno;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
