package com.yusufmendes.controller;

import com.yusufmendes.dto.DtoCustomer;

public interface ICustomerController {

    public DtoCustomer findCustomerById(Long id);
}
