package com.springbootweb.demo01.service;

import com.springbootweb.demo01.mapper.CityMapper;
import com.springbootweb.demo01.bean.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    CityMapper cityMapper;
    public City getById(Long id){
        return cityMapper.getById(id);
    }

}
