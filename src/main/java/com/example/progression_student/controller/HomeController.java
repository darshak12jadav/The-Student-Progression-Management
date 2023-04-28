package com.example.progression_student.controller;

import com.example.progression_student.entities.login.UserDetails;
import com.example.progression_student.repository.login.UserRepository;
import com.example.progression_student.service.login.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @ModelAttribute
    private void userDetails(Model m, Principal p){
        if(p!=null)
        {
            String email = p.getName();
            UserDetails userDetails =userRepository.findByEmail(email);

            m.addAttribute("userDetails",userDetails);
        }
    }
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @PostMapping("/createUser")
    public String createuser(@ModelAttribute UserDetails userDetails, HttpSession session, HttpServletRequest request) {

        String url = request.getRequestURL().toString();

        url = url.replace(request.getServletPath(),"");

        // System.out.println(user);

        boolean f = userService.checkEmail(userDetails.getEmail());

        if (f) {
            session.setAttribute("msg", "Email Id alreday exists \uD83E\uDD74 !!");
        }

        else {
            UserDetails userDetails1 = userService.createUser(userDetails,url);
            if (userDetails1 != null) {
                session.setAttribute("msg", "Register Successfully \uD83D\uDE0A !!" +
                        "Check your Mail to verify your account.");
            } else {
                session.setAttribute("msg", "Something wrong on server \uD83D\uDE28 !!");
            }
        }

        return "redirect:/register";
    }

    @RequestMapping("/clearMessage")
    public String clearMessage(HttpSession session) {
        session.removeAttribute("msg");
        return "redirect:/register";
    }

    @GetMapping("/verify")
    public String verifyAccount(@Param("code") String code){

        if (userService.verifyAccount(code)) {
            return "verify_success";
        }
        else {
            return "failed";
        }

    }


    /* Changing Password */

    @GetMapping("/loadForgetPassword")
    public String loadForgetPassword()
    {
        return"forgetpassword";
    }
    @GetMapping("/loadResetPassword/{id}")
    public String loadResetPassword(@PathVariable int id,Model m)
    {

        m.addAttribute("id",id);
        return"resetpassword";
    }

    @PostMapping("/forgetPassword")
    public String forgetPassword(@RequestParam String email,@RequestParam String mobilenum,HttpSession session)
    {
        UserDetails userDetails=userRepository.findByEmailAndMobileno(email,mobilenum);
        if(userDetails!=null)
        {
            return "redirect:/loadResetPassword/"+userDetails.getId();
        }
        else {
            session.setAttribute("msg2","Invalid Email or Mobile Number \uD83D\uDE14 \uD83D\uDE14 !!");
            return "forgetpassword";
        }

    }

    @PostMapping("/changePassword")
    public String resetPassword(@RequestParam String psw,@RequestParam Integer id,HttpSession session)
    {
        UserDetails userDetails=userRepository.findById(id).get();
        String encryptPsw=passwordEncoder.encode(psw);
        userDetails.setPassword(encryptPsw);
        UserDetails updateUser =userRepository.save(userDetails);
        if(updateUser!=null)
        {
            session.setAttribute("msg1","password change Sucessfully \uD83E\uDD37  \uD83E\uDD37 \uD83D\uDE0E");
        }
        return "redirect:/loadForgetPassword";

    }

    @RequestMapping("/clearMessage1")
    public String clearMessage1(HttpSession session) {
        session.removeAttribute("msg1");
        return "redirect:/signin";
    }

    @RequestMapping("/clearMessage2")
    public String clearMessage2(HttpSession session) {
        session.removeAttribute("msg2");
        return "redirect:/loadForgetPassword";
    }




}