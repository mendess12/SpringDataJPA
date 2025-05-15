package com.yusufmendes.controller;

import com.yusufmendes.entities.Students;

import java.util.List;

public interface IStudentController {

    public Students saveStudent(Students students);

    public List<Students> getAllStudents();

    public Students getStudentById(Integer id);

    public void deleteStudentById(Integer id);

    public Students updateStudent(Integer id, Students updatedStudent);
}
