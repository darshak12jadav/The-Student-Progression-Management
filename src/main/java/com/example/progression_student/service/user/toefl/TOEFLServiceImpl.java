package com.example.progression_student.service.user.toefl;

import com.example.progression_student.entities.user.details.TOEFL;
import com.example.progression_student.repository.user.TOEFLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TOEFLServiceImpl implements  TOEFLService{
    @Autowired
    private TOEFLRepository toeflRepository;
    @Override
    public TOEFL createTOEFL(TOEFL toefl) {
        return toeflRepository.save(toefl);
    }

    @Override
    public boolean checkSAppointmentNumber(String appointmentNumber) {
        return toeflRepository.existsById(appointmentNumber);
    }

    @Override
    public List<TOEFL> getTOEFLByBatchAndBranch(String batch, String branch) {
        return toeflRepository.findByBatchAndBranch(batch, branch);
    }

}
