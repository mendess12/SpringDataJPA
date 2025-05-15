package com.yusufmendes.services.impl;

import com.yusufmendes.entities.Students;
import com.yusufmendes.repository.StudentRepository;
import com.yusufmendes.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Students getStudentById(Integer id) {
        Optional<Students> students = studentRepository.findById(id);
        if (students.isPresent()) {
            return students.get();
        }
        return null;
    }

    @Override
    public void deleteStudentById(Integer id) {
        Students dbStudent = getStudentById(id);
        if (dbStudent != null) {
            studentRepository.delete(dbStudent);
        }
    }

    @Override
    public Students updateStudent(Integer id, Students updatedStudent) {
        Students dbStudent = getStudentById(id);
        if (dbStudent != null) {
            dbStudent.setFirstName(updatedStudent.getFirstName());
            dbStudent.setLastName(updatedStudent.getLastName());
            dbStudent.setBirthOfDate(updatedStudent.getBirthOfDate());

            return studentRepository.save(dbStudent);
        }
        return null;
    }
}
