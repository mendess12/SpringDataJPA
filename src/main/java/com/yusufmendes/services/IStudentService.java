package com.yusufmendes.services;

import com.yusufmendes.dto.DtoStudents;
import com.yusufmendes.dto.DtoStudentsIU;
import com.yusufmendes.entities.Students;
import java.util.List;

public interface IStudentService {

    public DtoStudents saveStudent(DtoStudentsIU dtoStudentIU);

    public List<DtoStudents> getAllStudents();

    public DtoStudents getStudentById(Integer id);

    public void deleteStudentById(Integer id);

    public DtoStudents updateStudent(Integer id, DtoStudentsIU dtoStudentsIU);
}
