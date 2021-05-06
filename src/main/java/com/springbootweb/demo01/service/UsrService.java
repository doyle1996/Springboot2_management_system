package com.springbootweb.demo01.service;

import com.springbootweb.demo01.mapper.UsrMapper;
import com.springbootweb.demo01.bean.Usr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsrService {
    @Autowired
    UsrMapper usrMapper;
    public Usr getUsr(Integer id){
        return usrMapper.getUsr(id);
    }

}
