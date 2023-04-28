package com.example.progression_student.repository.login;

import com.example.progression_student.entities.login.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDetails,Integer> {
    public boolean existsByEmail(String email);
    public UserDetails findByEmail(String email);
    public UserDetails findByEmailAndMobileno( String email,String  mobileno);

    public UserDetails findByVerificationCode(String code);



}
