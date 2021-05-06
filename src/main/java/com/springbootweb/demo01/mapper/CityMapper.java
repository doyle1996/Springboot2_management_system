package com.springbootweb.demo01.mapper;


import com.springbootweb.demo01.bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {

//    @Select("select * from test.city where id=#{id}")
    public City getById(Long id);

    //如果select语句过于复杂
    public void insert(City city);
}
