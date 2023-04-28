package com.example.progression_student.service.user.ielts;

import com.example.progression_student.entities.user.details.IELTS;
import com.example.progression_student.entities.user.details.TOEFL;

import java.util.List;

public interface IELTSService {
    public IELTS createIELTS(IELTS ielts);
    public boolean checkCandidateID(String candidateID);

    public List<IELTS> getIELTSBatchAndBranch(String batch, String branch);
}
