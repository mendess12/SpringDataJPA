package com.yusufmendes.controller;

import com.yusufmendes.dto.DtoEmployee;
import java.util.List;

public interface IEmployeeController {

    public List<DtoEmployee> findAllEmployees();
}
