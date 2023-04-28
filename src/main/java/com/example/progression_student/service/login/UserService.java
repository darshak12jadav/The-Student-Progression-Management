package com.example.progression_student.service.login;

import com.example.progression_student.entities.login.UserDetails;

public interface UserService {
    public UserDetails createUser(UserDetails userDetails,String url);

    public boolean checkEmail(String email);
    public  boolean verifyAccount(String code);

    public UserDetails getUserDetailsByEmail(String email);


}
