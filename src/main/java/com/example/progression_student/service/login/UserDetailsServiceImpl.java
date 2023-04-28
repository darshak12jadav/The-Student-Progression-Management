package com.example.progression_student.service.login;

import com.example.progression_student.configuration.login.CustomUserDetails;
import com.example.progression_student.repository.login.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

         com.example.progression_student.entities.login.UserDetails userDetails = userRepository.findByEmail(email);

         if(userDetails!=null){
             return new CustomUserDetails(userDetails);
         }
        throw new UsernameNotFoundException("User not available \uD83D\uDE24 !!");
    }
}
