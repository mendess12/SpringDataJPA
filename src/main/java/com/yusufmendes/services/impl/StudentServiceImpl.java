package com.yusufmendes.services.impl;

import com.yusufmendes.dto.DtoCourse;
import com.yusufmendes.dto.DtoStudents;
import com.yusufmendes.dto.DtoStudentsIU;
import com.yusufmendes.entities.Course;
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
        List<Students> studentList = studentRepository.findAllStudent();
        for (Students student : studentList) {
            DtoStudents dtoStudents = new DtoStudents();
            BeanUtils.copyProperties(student, dtoStudents);
            dtoList.add(dtoStudents);
        }
        return dtoList;
    }

    @Override
    public DtoStudents getStudentById(Integer id) {

        DtoStudents dtoStudents = new DtoStudents();
        Optional<Students> studentOptional = studentRepository.findById(id);
        if (studentOptional.isEmpty()) {
            return null;
        }
        Students dbStudent = studentOptional.get();
        BeanUtils.copyProperties(dbStudent, dtoStudents);

        if (dbStudent.getCourses() != null && !dbStudent.getCourses().isEmpty()) {
            for (Course course : dbStudent.getCourses()) {
                DtoCourse dtoCourse = new DtoCourse();
                BeanUtils.copyProperties(course, dtoCourse);

                dtoStudents.getCourses().add(dtoCourse);
            }
        }
        return dtoStudents;
    }

    @Override
    public void deleteStudentById(Integer id) {
        Optional<Students> optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            studentRepository.delete(optional.get());
        }
    }

    @Override
    public DtoStudents updateStudent(Integer id, DtoStudentsIU dtoStudentsIU) {
        DtoStudents dto = new DtoStudents();
        Optional<Students> optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            Students dbStudent = optional.get();
            dbStudent.setFirstName(dtoStudentsIU.getFirstName());
            dbStudent.setLastName(dtoStudentsIU.getLastName());
            dbStudent.setBirthOfDate(dtoStudentsIU.getBirthOfDate());

            Students updatedStudent = studentRepository.save(dbStudent);
            BeanUtils.copyProperties(updatedStudent, dto);
            return dto;
        }
        return null;
    }
}
