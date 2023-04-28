package com.example.progression_student.service.user.pdf;

import com.example.progression_student.entities.user.pdf.FileEntity;


import java.util.List;

public interface FileService {

    public List<FileEntity> getFileEntityByEmailId(String emailID);

}
