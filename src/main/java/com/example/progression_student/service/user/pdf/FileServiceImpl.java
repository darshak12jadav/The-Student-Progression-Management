package com.example.progression_student.service.user.pdf;

import com.example.progression_student.entities.user.pdf.FileEntity;
import com.example.progression_student.repository.user.FileRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class FileServiceImpl implements FileService{
    @Autowired
    private FileRepository fileRepository;

    @Transactional
    @Override
    public List<FileEntity> getFileEntityByEmailId(String emailID) {
        return fileRepository.findByEmailID(emailID);
    }

}
