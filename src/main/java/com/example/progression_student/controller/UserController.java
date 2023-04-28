package com.example.progression_student.controller;

import com.example.progression_student.entities.login.UserDetails;
import com.example.progression_student.entities.user.details.*;
import com.example.progression_student.entities.user.pdf.FileEntity;
import com.example.progression_student.repository.login.UserRepository;
import com.example.progression_student.repository.user.FileRepository;
import com.example.progression_student.service.user.cat.CATService;
import com.example.progression_student.service.user.gate.GATEService;
import com.example.progression_student.service.user.gre.GREService;
import com.example.progression_student.service.user.ielts.IELTSService;
import com.example.progression_student.service.user.toefl.TOEFLService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GREService greService;
    @Autowired
    private GATEService gateService;
    @Autowired
    private IELTSService ieltsService;
    @Autowired
    private TOEFLService toeflService;
    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private CATService catService;

    @ModelAttribute
    private void userDetails(Model m, Principal p){
      String email = p.getName();
      UserDetails userDetails =userRepository.findByEmail(email);

      m.addAttribute("userDetails",userDetails);
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @GetMapping("/")
    public String home(){
        return "user/home";
    }

    @GetMapping("/gre")
    public String greStudentDetails(){
        return "user/greStudentDetails";
    }

    @GetMapping("/gate")
    public String gateStudentDetails(){
        return "user/gateStudentDetails";
    }

    @GetMapping("/ielts")
    public String ieltsStudentDetails(){
        return "user/ieltsStudentDetails";
    }

    @GetMapping("/toefl")
    public String toeflStudentDetails(){
        return "user/toeflStudentDetails";
    }

    @GetMapping("/cat")
    public String catStudentDetails(){
        return "user/catStudentDetails";
    }
    @GetMapping("/grePDF")
    public String grePDF() {
        return "user/grePDF";
    }

    @GetMapping("/gatePDF")
    public String gatePDF() {
        return "user/gatePDF";
    }

    @GetMapping("/ieltsPDF")
    public String ieltsPDF() {
        return "user/ieltsPDF";
    }

    @GetMapping("/toeflPDF")
    public String toeflPDF() {
        return "user/toeflPDF";
    }

    @GetMapping("/catPDF")
    public String catPDF() {
        return "user/catPDF";
    }

    @PostMapping("/createGRE")
    public String createGRE(@ModelAttribute GRE gre, HttpSession session){

       boolean f = greService.checkRegistrationNumber(gre.getRegistrationNumber());

        if (f) {
            session.setAttribute("msg", "Check your Registration Number please!!! \uD83E\uDD74 \uD83E\uDD74 !!");
        }else {
            GRE gre1 = greService.createGRE(gre);
            if (gre1 != null) {
                session.setAttribute("msg", "GRE Details Submitted Successfully!! \uD83D\uDE0A \uD83D\uDE0A");
            }
            else {
                session.setAttribute("msg", "Something wrong on server \uD83D\uDE28 \uD83D\uDE28!!");
            }
        }
        return "redirect:/user/gre";
    }

    @RequestMapping("/clearMessage")
    public String clearMessage(HttpSession session) {
        session.removeAttribute("msg");
        return "redirect:/user/gre";
    }



    @PostMapping("/createGATE")
    public String createGATE(@ModelAttribute GATE gate, HttpSession session){

        boolean f = gateService.checkRegistrationNumber(gate.getRegistrationNumber());

        if (f) {
            session.setAttribute("msg", "Please check your Registration number!!! \uD83E\uDD74 \uD83E\uDD74 !!");
        }else {
            GATE gate1 = gateService.createGATE(gate);
            if (gate1 != null) {
                session.setAttribute("msg", "GATE Details Submitted Successfully!! \uD83D\uDE0A \uD83D\uDE0A !!");
            }
            else {
                session.setAttribute("msg", "Something wrong on server \uD83D\uDE28 \uD83D\uDE28 !!");
            }
        }
        return "redirect:/user/gate";
    }

    @RequestMapping("/clearMessage1")
    public String clearMessage1(HttpSession session) {
        session.removeAttribute("msg");
        return "redirect:/user/gate";
    }



    @PostMapping("/createIELTS")
    public String createIELTS(@ModelAttribute IELTS ielts, HttpSession session){

        boolean f = ieltsService.checkCandidateID(ielts.getCandidateID());

        if (f) {
            session.setAttribute("msg", "Change your Candidate ID please!!! \uD83E\uDD74 \uD83E\uDD74 !!");
        }else {
            IELTS ielts1 = ieltsService.createIELTS(ielts);
            if (ielts1 != null) {
                session.setAttribute("msg", "IELTS Details Submitted Successfully!! \uD83D\uDE0A \uD83D\uDE0A !!");
            }
            else {
                session.setAttribute("msg", "Something wrong on server \uD83D\uDE28 \uD83D\uDE28 !!");
            }
        }
        return "redirect:/user/ielts";
    }

    @RequestMapping("/clearMessage2")
    public String clearMessage2(HttpSession session) {
        session.removeAttribute("msg");
        return "redirect:/user/ielts";
    }

    @PostMapping("/createTOEFL")
    public String createTOEFL(@ModelAttribute TOEFL toefl, HttpSession session){

        boolean f = toeflService.checkSAppointmentNumber(toefl.getAppointmentNumber());

        if (f) {
            session.setAttribute("msg", "Change your Appointment Number please!!! \uD83E\uDD74 \uD83E\uDD74 !!");
        }else {
            TOEFL toefl1 = toeflService.createTOEFL(toefl);
            if (toefl1 != null) {
                session.setAttribute("msg", "TOEFL Details Submitted Successfully!! \uD83D\uDE0A \uD83D\uDE0A !!");
            }
            else {
                session.setAttribute("msg", "Something wrong on server \uD83D\uDE28 \uD83D\uDE28 !!");
            }
        }
        return "redirect:/user/toefl";
    }

    @RequestMapping("/clearMessage3")
    public String clearMessage3(HttpSession session) {
        session.removeAttribute("msg");
        return "redirect:/user/toefl";
    }

    @PostMapping("/createCAT")
    public String createCAT(@ModelAttribute CAT cat, HttpSession session){

        boolean f = catService.checkRegistrationNumber(cat.getRegistrationNumber());

        if (f) {
            session.setAttribute("msg", "Change your Registration Number please!!! \uD83E\uDD74 \uD83E\uDD74 !!");
        }else {
            CAT cat1 = catService.createCAT(cat);
            if (cat1 != null) {
                session.setAttribute("msg", "CAT Details Submitted Successfully!! \uD83D\uDE0A \uD83D\uDE0A !!");
            }
            else {
                session.setAttribute("msg", "Something wrong on server \uD83D\uDE28 \uD83D\uDE28 !!");
            }
        }
        return "redirect:/user/cat";
    }

    @RequestMapping("/clearMessage4")
    public String clearMessage4(HttpSession session) {
        session.removeAttribute("msg");
        return "redirect:/user/cat";
    }




    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("studentID") String sid,@RequestParam("emailID") String eid,@RequestParam("fullName") String fid, RedirectAttributes redirectAttributes) {
        try {
            FileEntity fileEntity = new FileEntity();
            fileEntity.setName(file.getOriginalFilename());
            fileEntity.setType(file.getContentType());
            fileEntity.setData(file.getBytes());
            fileEntity.setStudentID(sid);
            fileEntity.setEmailID(eid);
            fileEntity.setFullName(fid);
            fileRepository.save(fileEntity);

            redirectAttributes.addFlashAttribute("message", "File uploaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "Failed to upload file!");
        }
        return "redirect:/user/grePDF";
    }

    @PostMapping("/upload1")
    public String uploadFile1(@RequestParam("file") MultipartFile file,@RequestParam("studentID") String sid ,@RequestParam("emailID") String eid ,@RequestParam("fullName") String fid,RedirectAttributes redirectAttributes) {
        try{
            FileEntity fileEntity = new FileEntity();
            fileEntity.setName(file.getOriginalFilename());
            fileEntity.setType(file.getContentType());
            fileEntity.setData(file.getBytes());
            fileEntity.setStudentID(sid);
            fileEntity.setEmailID(eid);
            fileEntity.setFullName(fid);
            fileRepository.save(fileEntity);

            redirectAttributes.addFlashAttribute("message", "File uploaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "Failed to upload file!");
        }
        return "redirect:/user/gatePDF";
    }

    @PostMapping("/upload2")
    public String uploadFile2(@RequestParam("file") MultipartFile file,@RequestParam("studentID") String sid ,@RequestParam("emailID") String eid,@RequestParam("fullName") String fid ,RedirectAttributes redirectAttributes) {
        try{
            FileEntity fileEntity = new FileEntity();
            fileEntity.setName(file.getOriginalFilename());
            fileEntity.setType(file.getContentType());
            fileEntity.setData(file.getBytes());
            fileEntity.setStudentID(sid);
            fileEntity.setEmailID(eid);
            fileEntity.setFullName(fid);
            fileRepository.save(fileEntity);

            redirectAttributes.addFlashAttribute("message", "File uploaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "Failed to upload file!");
        }
        return "redirect:/user/ieltsPDF";
    }

    @PostMapping("/upload3")
    public String uploadFile3(@RequestParam("file") MultipartFile file,@RequestParam("studentID") String sid ,@RequestParam("emailID") String eid,@RequestParam("fullName") String fid ,RedirectAttributes redirectAttributes) {
        try{
            FileEntity fileEntity = new FileEntity();
            fileEntity.setName(file.getOriginalFilename());
            fileEntity.setType(file.getContentType());
            fileEntity.setData(file.getBytes());
            fileEntity.setStudentID(sid);
            fileEntity.setEmailID(eid);
            fileEntity.setFullName(fid);
            fileRepository.save(fileEntity);

            redirectAttributes.addFlashAttribute("message", "File uploaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "Failed to upload file!");
        }
        return "redirect:/user/toeflPDF";
    }

    @PostMapping("/upload4")
    public String uploadFile4(@RequestParam("file") MultipartFile file,@RequestParam("studentID") String sid ,@RequestParam("emailID") String eid,@RequestParam("fullName") String fid ,RedirectAttributes redirectAttributes) {
        try{
            FileEntity fileEntity = new FileEntity();
            fileEntity.setName(file.getOriginalFilename());
            fileEntity.setType(file.getContentType());
            fileEntity.setData(file.getBytes());
            fileEntity.setStudentID(sid);
            fileEntity.setEmailID(eid);
            fileEntity.setFullName(fid);
            fileRepository.save(fileEntity);

            redirectAttributes.addFlashAttribute("message", "File uploaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "Failed to upload file!");
        }
        return "redirect:/user/catPDF";
    }


}





