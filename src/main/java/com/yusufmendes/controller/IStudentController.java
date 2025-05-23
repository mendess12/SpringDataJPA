package com.yusufmendes.controller;

import com.yusufmendes.dto.DtoStudents;
import com.yusufmendes.dto.DtoStudentsIU;
import com.yusufmendes.entities.Students;

import java.util.List;

public interface IStudentController {

    public DtoStudents saveStudent(DtoStudentsIU dtoStudentIU);

    public List<Students> getAllStudents();

    public Students getStudentById(Integer id);

    public void deleteStudentById(Integer id);

    public Students updateStudent(Integer id, Students updatedStudent);
}
