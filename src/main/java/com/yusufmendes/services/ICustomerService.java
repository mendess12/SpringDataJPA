package com.yusufmendes.services;

import com.yusufmendes.dto.DtoCustomer;

public interface ICustomerService {

    public DtoCustomer findCustomerById(Long id);
}
