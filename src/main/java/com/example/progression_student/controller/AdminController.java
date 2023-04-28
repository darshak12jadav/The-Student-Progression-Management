package com.example.progression_student.controller;

import com.example.progression_student.entities.admin.Student_Details;
import com.example.progression_student.entities.login.UserDetails;
import com.example.progression_student.entities.user.details.*;
import com.example.progression_student.entities.user.pdf.FileEntity;
import com.example.progression_student.helper.ExcelHelper;

import com.example.progression_student.repository.admin.Student_Details_Repository;
import com.example.progression_student.repository.login.UserRepository;

import com.example.progression_student.repository.user.FileRepository;
import com.example.progression_student.service.admin.Student_Details_Service;
import com.example.progression_student.service.login.UserService;
import com.example.progression_student.service.user.cat.CATService;
import com.example.progression_student.service.user.gate.GATEService;
import com.example.progression_student.service.user.gre.GREService;
import com.example.progression_student.service.user.ielts.IELTSService;
import com.example.progression_student.service.user.pdf.FileService;
import com.example.progression_student.service.user.toefl.TOEFLService;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Optional;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private Student_Details_Service student_details_service;

    public AdminController(Student_Details_Service student_details_service) {
        this.student_details_service = student_details_service;
    }

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private GREService greService;


    @Autowired
    private GATEService gateService;


    @Autowired
    private TOEFLService toeflService;


    @Autowired
    private IELTSService ieltsService;

    @Autowired
    private FileService fileService;

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private Student_Details_Repository student_details_repository;

    @Autowired
    private CATService catService;


    @ModelAttribute
    private void userDetails(Model m, Principal p){
        if(p!=null)
        {
            String email = p.getName();
            UserDetails userDetails =userRepository.findByEmail(email);

            m.addAttribute("userDetails",userDetails);
        }
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @GetMapping("/")
    public String home()
    {
        return "admin/home";
    }

    @GetMapping("/excel/excel2")
    public String excelUpload(){
        return "admin/excel2";
    }

    @GetMapping("/excel/excel1")
    public String excel1(){
        return "admin/excel1";
    }

    @PostMapping("/excel/upload")
    public String upload(@RequestParam("Excel-file") MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
        try {
            if (ExcelHelper.checkExcelFormat(file)) {
                List<Student_Details> students = ExcelHelper.covertExcelToListOfStudent(file.getInputStream());
                if (students.size() > 0) {
                    boolean isSaved = this.student_details_service.save(file);
                    if (isSaved) {
                        redirectAttributes.addFlashAttribute("message", "File uploaded successfully!");
                    } else {
                        redirectAttributes.addFlashAttribute("error", "Duplicate data found. Please upload a file with unique data.");
                    }
                } else {
                    redirectAttributes.addFlashAttribute("error", "The uploaded file has an incorrect format or is missing a column or please check your Excel sheet name.");
                }
            } else {
                redirectAttributes.addFlashAttribute("error", "Please upload an Excel file.");
            }
        } catch (InvalidFormatException e) {
            redirectAttributes.addFlashAttribute("error", "The uploaded file has an invalid format. Please upload a valid Excel file.");
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("error", "There was an error reading the uploaded file. Please try again.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "The uploaded file has an incorrect format or is missing a column or please check your Excel sheet name.");
        }
        return "redirect:/admin/excel/excel2";
    }

    @GetMapping("/viewDetails")
    public String view(){
        return "admin/view";
    }

    @GetMapping("/viewDetails/greView1")
    public String greView1(){
        return "admin/greView1";
    }

    @GetMapping("/viewDetails/greView2")
    public String greView2(@RequestParam("batch") String batch,@RequestParam("branch") String branch, Model model) {
        List<GRE> greList = greService.getGREBatchAndBranch(batch, branch);
        if(greList.isEmpty()) {
            model.addAttribute("errorMsg", "The details you're searching for is doesn't exist!!");
            return "admin/greView2"; // replace with the name of your error page
        } else {
            model.addAttribute("greList", greList);
            return "admin/greView2";
        }
    }


    @GetMapping("/viewDetails/gateView1")
    public String gateView1(){
        return "admin/gateView1";
    }

    @GetMapping("/viewDetails/gateView2")
    public String gateView2(@RequestParam("batch") String batch,@RequestParam("branch") String branch, Model model) {
        List<GATE> gateList = gateService.getByBatchAndBranch(batch, branch);
        if(gateList.isEmpty()) {
            model.addAttribute("errorMsg", "The details you're searching for is doesn't exist!!");
            return "admin/gateView2"; // replace with the name of your error page
        } else {
            model.addAttribute("gateList", gateList);
            return "admin/gateView2";
        }
    }

    @GetMapping("/viewDetails/toeflView1")
    public String toeflView1(){
        return "admin/toeflView1";
    }

    @GetMapping("/viewDetails/toeflView2")
    public String toeflView2(@RequestParam("batch") String batch,@RequestParam("branch") String branch, Model model) {
        List<TOEFL> toeflList = toeflService.getTOEFLByBatchAndBranch(batch, branch);
        if(toeflList.isEmpty()) {
            model.addAttribute("errorMsg", "The details you're searching for is doesn't exist!!");
            return "admin/toeflView2"; // replace with the name of your error page
        } else {
            model.addAttribute("toeflList", toeflList);
            return "admin/toeflView2";
        }
    }

    @GetMapping("/viewDetails/ieltsView1")
    public String ieltsView1(){
        return "admin/ieltsView1";
    }

    @GetMapping("/viewDetails/ieltsView2")
    public String ieltsView2(@RequestParam("batch") String batch,@RequestParam("branch") String branch, Model model) {
        List<IELTS> ieltsList = ieltsService.getIELTSBatchAndBranch(batch, branch);
        if(ieltsList.isEmpty()) {
            model.addAttribute("errorMsg", "The details you're searching for is doesn't exist!!");
            return "admin/ieltsView2"; // replace with the name of your error page
        } else {
            model.addAttribute("ieltsList", ieltsList);
            return "admin/ieltsView2";
        }
    }

    @GetMapping("/excel/studentView1")
    public String studentView1(){
        return "admin/studentView1";
    }

    @GetMapping("/excel/studentView2")
    public String studentView2(@RequestParam("batch") String batch,@RequestParam("branch") String branch, Model model) {
        List<Student_Details> studList = student_details_service.getStudent_DetailsByBatchAndBranch(batch,branch);
        if(studList.isEmpty()) {
            model.addAttribute("errorMsg", "The details you're searching for is doesn't exist!!");
            return "admin/studentView2"; // replace with the name of your error page
        } else {
            model.addAttribute("studList", studList);
            return "admin/studentView2";
        }
    }


    @GetMapping("/viewDetails/resultView1")
    public String resultView1(){
        return "admin/resultView1";
    }



    @GetMapping("/viewDetails/resultView2")
    public String resultView2(@RequestParam("emailID") String emailID, Model model) {
        List<FileEntity> filesList = fileService.getFileEntityByEmailId(emailID);
        System.out.println(filesList.size()+".........................");
        if(filesList.isEmpty()) {
            model.addAttribute("errorMsg", "The College Id you're searching for is doesn't exist!!");
            return "admin/resultView2"; // replace with the name of your error page
        } else {
            model.addAttribute("filesList", filesList);
            System.out.println("Files List: " + filesList); // Print the filesList object
            return "admin/resultView2";
        }
    }


    @GetMapping("/viewDetails/resultview2/files1/{id}")
    public ResponseEntity<byte[]> getFile1(@PathVariable Long id) {
        Optional<FileEntity> fileEntityOptional = fileRepository.findById(id);
        if (fileEntityOptional.isPresent()) {
            FileEntity fileEntity = fileEntityOptional.get();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline; filename=" + fileEntity.getName());
            headers.add("Content-Type", "application/pdf");
            headers.add("X-Frame-Options", "SAMEORIGIN"); // to allow embedding in an iframe
            return ResponseEntity.ok().headers(headers).body(fileEntity.getData());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/viewDetails/resultview2/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
        Optional<FileEntity> fileEntityOptional = fileRepository.findById(id);
        if (fileEntityOptional.isPresent()) {
            FileEntity fileEntity = fileEntityOptional.get();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=" + fileEntity.getName());
            return ResponseEntity.ok().headers(headers).body(fileEntity.getData());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/viewDetails/userView1")
    public String userView1(){
        return "admin/userView1";
    }

    @GetMapping("/viewDetails/userView2")
    public String userView2(@RequestParam("email") String email, Model model) {
        UserDetails userList = userService.getUserDetailsByEmail(email);
        if(userList==null) {
            model.addAttribute("errorMsg", "The User you're searching for is doesn't exist!!");
            return "admin/userView2"; // replace with the name of your error page
        } else {
            model.addAttribute("userList",userList );
            return "admin/userView2";
        }
    }

    @GetMapping("/viewDetails/catView1")
    public String catView1(){
        return "admin/catView1";
    }

    @GetMapping("/viewDetails/catView2")
    public String catView2(@RequestParam("batch") String batch,@RequestParam("branch") String branch, Model model) {
        List<CAT> catList = catService.getCATByBatchAndBranch(batch, branch);
        if(catList.isEmpty()) {
            model.addAttribute("errorMsg", "The details you're searching for is doesn't exist!!");
            return "admin/catView2"; // replace with the name of your error page
        } else {
            model.addAttribute("catList", catList);
            return "admin/catView2";
        }
    }

}





