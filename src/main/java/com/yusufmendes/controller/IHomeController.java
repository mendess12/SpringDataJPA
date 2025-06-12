package com.yusufmendes.controller;

import com.yusufmendes.dto.DtoHome;

public interface IHomeController {

    public DtoHome findHomeById(Long id);
}
