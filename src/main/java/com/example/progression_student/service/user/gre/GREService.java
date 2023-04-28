package com.example.progression_student.service.user.gre;

import com.example.progression_student.entities.user.details.GRE;
import com.example.progression_student.entities.user.pdf.FileEntity;

import java.util.List;

public interface GREService {

    public GRE createGRE(GRE gre);

    public boolean checkRegistrationNumber(String registrationNumber);

    public FileEntity createID(FileEntity fileEntity);

    public List<GRE> getGREBatchAndBranch(String batch, String branch);
}
