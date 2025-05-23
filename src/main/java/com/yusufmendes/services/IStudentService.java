package com.yusufmendes.services;

import com.yusufmendes.dto.DtoStudents;
import com.yusufmendes.dto.DtoStudentsIU;
import com.yusufmendes.entities.Students;
import java.util.List;

public interface IStudentService {

    public DtoStudents saveStudent(DtoStudentsIU dtoStudentIU);

    public List<Students> getAllStudents();

    public Students getStudentById(Integer id);

    public void deleteStudentById(Integer id);

    public Students updateStudent(Integer id, Students updatedStudent);
}
