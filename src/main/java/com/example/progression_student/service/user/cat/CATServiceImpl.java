package com.example.progression_student.service.user.cat;

import com.example.progression_student.entities.user.details.CAT;

import com.example.progression_student.repository.user.CATRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CATServiceImpl implements CATService{
    @Autowired
    private CATRepository catRepository;

    @Override
    public CAT createCAT(CAT cat) {
        return catRepository.save(cat);
    }

    @Override
    public boolean checkRegistrationNumber(int registrationNumber) {
        return catRepository.existsById(registrationNumber);
    }

    @Override
    public List<CAT> getCATByBatchAndBranch(String batch, String branch) {
        return catRepository.findByBatchAndBranch(batch,branch);
    }


}
