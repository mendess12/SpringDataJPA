package com.yusufmendes.services.impl;

import com.yusufmendes.dto.DtoStudents;
import com.yusufmendes.dto.DtoStudentsIU;
import com.yusufmendes.entities.Students;
import com.yusufmendes.repository.StudentRepository;
import com.yusufmendes.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public DtoStudents saveStudent(DtoStudentsIU dtoStudentIU) {

        DtoStudents response = new DtoStudents();
        Students student = new Students();
        BeanUtils.copyProperties(dtoStudentIU, student);

        Students dbStudent = studentRepository.save(student);
        BeanUtils.copyProperties(dbStudent, response);

        return response;
    }

    @Override
    public List<DtoStudents> getAllStudents() {
        List<DtoStudents> dtoList = new ArrayList<>();
        List<Students> studentList = studentRepository.findAll();
        for (Students student : studentList) {
            DtoStudents dtoStudents = new DtoStudents();
            BeanUtils.copyProperties(student, dtoStudents);
            dtoList.add(dtoStudents);
        }
        return dtoList;
    }

    @Override
    public DtoStudents getStudentById(Integer id) {
        DtoStudents dto = new DtoStudents();
        Optional<Students> optinal = studentRepository.findById(id);
        if (optinal.isPresent()) {
            Students dbStudent = optinal.get();
            BeanUtils.copyProperties(dbStudent, dto);
            return dto;
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
