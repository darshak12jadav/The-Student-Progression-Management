package com.example.progression_student.service.user.gre;

import com.example.progression_student.entities.user.details.GRE;
import com.example.progression_student.entities.user.pdf.FileEntity;
import com.example.progression_student.repository.user.FileRepository;
import com.example.progression_student.repository.user.GRERepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GREServiceImpl implements GREService{

    @Autowired
    private GRERepository greRepository;

    @Autowired
    private FileRepository fileRepository;

    @Override
    public GRE createGRE(GRE gre) {
        return greRepository.save(gre);
    }

    @Override
    public boolean checkRegistrationNumber(String registrationNumber) {
        return greRepository.existsByRegistrationNumber(registrationNumber);
    }

    @Override
    public FileEntity createID(FileEntity fileEntity) {
        return fileRepository.save(fileEntity);
    }

    @Override
    public List<GRE> getGREBatchAndBranch(String batch, String branch) {
        return greRepository.findByBatchAndBranch(batch, branch);
    }


}
