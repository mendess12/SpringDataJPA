package com.yusufmendes.services.impl;

import com.yusufmendes.entities.Students;
import com.yusufmendes.repository.StudentRepository;
import com.yusufmendes.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Students saveStudent(Students students) {
        return studentRepository.save(students);
    }

    @Override
    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }
}
