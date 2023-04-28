package com.example.progression_student.service.user.gate;

import com.example.progression_student.entities.user.details.GATE;


import java.util.List;


public interface GATEService {
    public GATE createGATE(GATE gate);
    public boolean checkRegistrationNumber(String registrationNumber);

    public List<GATE> getByBatchAndBranch(String batch, String branch);
}
