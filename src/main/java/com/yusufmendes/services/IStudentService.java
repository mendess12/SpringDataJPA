package com.yusufmendes.services;

import com.yusufmendes.entities.Students;
import java.util.List;

public interface IStudentService {

    public Students saveStudent(Students students);

    public List<Students> getAllStudents();
}
