package com.example.progression_student.service.user.ielts;

import com.example.progression_student.entities.user.details.IELTS;
import com.example.progression_student.repository.user.IELTSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IELTSServiceImpl implements  IELTSService{
    @Autowired
    private   IELTSRepository ieltsRepository;

    @Override
    public IELTS createIELTS(IELTS ielts) {
        return ieltsRepository.save(ielts);
    }

    @Override
    public boolean checkCandidateID(String candidateID) {
        return ieltsRepository.existsById(candidateID);
    }

    @Override
    public List<IELTS> getIELTSBatchAndBranch(String batch, String branch) {
        return ieltsRepository.findByBatchAndBranch(batch, branch);
    }


}
