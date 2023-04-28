package com.example.progression_student.repository.user;

import com.example.progression_student.entities.user.pdf.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {

    public List<FileEntity> findByEmailID(String emailID);

}

