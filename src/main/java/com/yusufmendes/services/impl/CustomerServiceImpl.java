package com.yusufmendes.services.impl;

import com.yusufmendes.dto.DtoAddress;
import com.yusufmendes.dto.DtoCustomer;
import com.yusufmendes.entities.Address;
import com.yusufmendes.entities.Customer;
import com.yusufmendes.repository.CustomerRepository;
import com.yusufmendes.services.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public DtoCustomer findCustomerById(Long id) {

        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAddress dtoAddress = new DtoAddress();

        Optional<Customer> optional = customerRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }

        Customer customer = optional.get();
        Address address = customer.getAddress();
        BeanUtils.copyProperties(customer, dtoCustomer);
        BeanUtils.copyProperties(address, dtoAddress);

        dtoCustomer.setAddress(dtoAddress);

        return dtoCustomer;
    }
}
