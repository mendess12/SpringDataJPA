package com.yusufmendes.services;

import com.yusufmendes.entities.Students;

import java.util.List;

public interface IStudentService {

    public Students saveStudent(Students students);

    public List<Students> getAllStudents();

    public Students getStudentById(Integer id);

    public void deleteStudentById(Integer id);
}
