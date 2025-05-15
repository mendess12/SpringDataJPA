package com.yusufmendes.controller.impl;

import com.yusufmendes.controller.IStudentController;
import com.yusufmendes.entities.Students;
import com.yusufmendes.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping(path = "/save")
    @Override
    public Students saveStudent(@RequestBody Students students) {
        return studentService.saveStudent(students);
    }

    @GetMapping(path = "/list")
    @Override
    public List<Students> getAllStudents() {
        return studentService.getAllStudents();
    }

}
