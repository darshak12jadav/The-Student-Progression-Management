package com.example.progression_student.service.user.cat;

import com.example.progression_student.entities.user.details.CAT;
import com.example.progression_student.entities.user.details.GATE;

import java.util.List;

public interface CATService {
    public CAT createCAT(CAT cat);
    public boolean checkRegistrationNumber(int registrationNumber);
    public List<CAT> getCATByBatchAndBranch(String batch, String branch);


}
