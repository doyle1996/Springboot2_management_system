package com.springbootweb.demo01.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootweb.demo01.bean.Good;
import com.springbootweb.demo01.mapper.GoodMapper;
import com.springbootweb.demo01.service.GoodService;
import org.springframework.stereotype.Service;

@Service
public class GoodServiceImpl extends ServiceImpl<GoodMapper,Good> implements GoodService {
}
