package com.springbootweb.demo01.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootweb.demo01.bean.City;
import com.springbootweb.demo01.mapper.CityMapper;
import com.springbootweb.demo01.service.CityService;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {


}
