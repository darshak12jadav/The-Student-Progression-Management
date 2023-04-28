package com.example.progression_student.service.login;

import com.example.progression_student.entities.login.UserDetails;
import com.example.progression_student.repository.login.UserRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import net.bytebuddy.utility.RandomString;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender mailSender;

    public UserServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public UserDetails createUser(UserDetails userDetail, String url) {
        userDetail.setPassword(passwordEncoder.encode(userDetail.getPassword()));
        userDetail.setRole("ROLE_USER");

        RandomString rn = new RandomString();
        String verificationCode = rn.make(64);
        userDetail.setVerificationCode(verificationCode);

        UserDetails savedUser = userRepository.save(userDetail);
        if (savedUser != null) {
            sendVerificationMail(savedUser, url, verificationCode);
        }

        return savedUser;
    }


//    @Override
//    public UserDetails createUser(UserDetails userDetail, String url) {
//        userDetail.setPassword(passwordEncoder.encode(userDetail.getPassword()));
//        userDetail.setRole("ROLE_USER");
//
//        RandomString rn = new RandomString();
//        String verificationCode = rn.make(64);
//        userDetail.setVerificationCode(verificationCode);
//
//        sendVerificationMail(userDetail, url, verificationCode);
//
//        userDetail.setEnabled(false);
//        return userRepository.save(userDetail);
//    }


    @Override
    public boolean checkEmail(String email) {

        return userRepository.existsByEmail(email);
    }

    public boolean verifyAccount(String verificationCode) {
        UserDetails userDetails = userRepository.findByVerificationCode(verificationCode);

        if (userDetails == null) {
            return false;
        }

        userDetails.setEnabled(true);
        userDetails.setAccountNonLocked(true);
        userDetails.setVerificationCode(null);

        userRepository.save(userDetails);
        return true;
    }

    @Override
    public UserDetails getUserDetailsByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Async
    public void sendVerificationMail(UserDetails userDetails, String url, String verificationCode) {
        String from = "darshakjadav8@gmail.com";
        String to = userDetails.getEmail();
        String subject = "The Student Progression Management Account Verification";

        // HTML content with inline CSS styles
        String content = "<div style=\"background-color:#f5f5f5;padding:20px;font-family:sans-serif;\">"
                + "<h2 style=\"color:#444;\">Dear " + userDetails.getFullName() + ",</h2>"
                + "<p style=\"color:#666;\">Please click the link below to verify your registration:</p>"
                + "<div style=\"background-color:#fff;padding:10px;border-radius:5px;margin-top:10px;\">"
                + "<a href=\"" + url + "/verify?code=" + verificationCode + "\" "
                + "style=\"display:inline-block;padding:10px;background-color:#2a9df4;color:#fff;text-decoration:none;border-radius:5px;\">VERIFY</a>"
                + "</div>"
                + "<p style=\"color:#666;margin-top:20px;\">Thank you!</p>"
                + "</div>";

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom(from, "The Student Progression Management");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






    @Async
    public void sendEmail(String to, String subject, String body) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true);

            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Async
    public void sendBulkEmail(List<String> toList, String subject, String body) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (String to : toList) {
            executor.submit(() -> {
                sendEmail(to, subject, body);
            });
        }

        executor.shutdown();
    }



}
