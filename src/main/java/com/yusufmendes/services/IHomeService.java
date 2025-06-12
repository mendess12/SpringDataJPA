package com.yusufmendes.services;

import com.yusufmendes.dto.DtoHome;

public interface IHomeService {

    public DtoHome findHomeById(Long id);
}
