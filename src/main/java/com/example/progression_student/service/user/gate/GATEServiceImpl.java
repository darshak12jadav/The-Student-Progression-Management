package com.example.progression_student.service.user.gate;

import com.example.progression_student.entities.user.details.GATE;
import com.example.progression_student.repository.user.GATERepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GATEServiceImpl implements GATEService{
    @Autowired
    private GATERepository gateRepository;
    @Override
    public GATE createGATE(GATE gate) {
        return gateRepository.save(gate);
    }

    @Override
    public boolean checkRegistrationNumber(String registrationNumber) {
        return gateRepository.existsById(registrationNumber);
    }

    @Override
    public List<GATE> getByBatchAndBranch(String batch, String branch) {
        return gateRepository.findByBatchAndBranch(batch,branch);
    }


}
