package com.example.progression_student.service.user.toefl;

import com.example.progression_student.entities.user.details.GRE;
import com.example.progression_student.entities.user.details.TOEFL;

import java.util.List;

public interface TOEFLService {
    public TOEFL createTOEFL(TOEFL toefl);
    public boolean checkSAppointmentNumber(String appointmentNumber);

    public List<TOEFL> getTOEFLByBatchAndBranch(String batch, String branch);
}
