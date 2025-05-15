package com.yusufmendes.controller;

import com.yusufmendes.entities.Students;
import java.util.List;

public interface IStudentController {

    public Students saveStudent(Students students);

    public List<Students> getAllStudents();
}
