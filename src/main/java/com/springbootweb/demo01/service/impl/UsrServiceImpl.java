package com.springbootweb.demo01.service.impl;


import com.springbootweb.demo01.bean.Usr;
import com.springbootweb.demo01.mapper.UsrMapper;
import com.springbootweb.demo01.service.UsrService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

//实现类注入接口  方法应该在接口中
@Service
public class UsrServiceImpl implements UsrService {
    @Mapper
    UsrMapper usrMapper;

    @Override
    public Usr getUsr(Integer id) {
        return usrMapper.getUsr(id);
    }
}
