package com.yusufmendes.services;

import com.yusufmendes.dto.DtoEmployee;
import java.util.List;

public interface IEmployeeService {

    public List<DtoEmployee> findAllEmployee();
}
