package com.springbootweb.demo01.mapper;

import com.springbootweb.demo01.bean.Usr;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsrMapper {
    public Usr getUsr(Integer id);
}
