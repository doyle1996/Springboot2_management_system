package com.springbootweb.demo01.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootweb.demo01.bean.City;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CityMapper extends BaseMapper<City> {
}
