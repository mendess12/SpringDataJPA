package com.yusufmendes.controller.impl;

import com.yusufmendes.controller.IStudentController;
import com.yusufmendes.dto.DtoStudents;
import com.yusufmendes.dto.DtoStudentsIU;
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
    public DtoStudents saveStudent(@RequestBody DtoStudentsIU dtoStudentIU) {
        return studentService.saveStudent(dtoStudentIU);
    }

    @GetMapping(path = "/list")
    @Override
    public List<DtoStudents> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public DtoStudents getStudentById(@PathVariable(name = "id") Integer id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteStudentById(@PathVariable(name = "id") Integer id) {
        studentService.deleteStudentById(id);
    }

    @PutMapping(path = "/update/{id}")
    @Override
    public DtoStudents updateStudent(@PathVariable(name = "id") Integer id, @RequestBody DtoStudentsIU dtoStudentsIU) {
        return studentService.updateStudent(id, dtoStudentsIU);
    }

}
