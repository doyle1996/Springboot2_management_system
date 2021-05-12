package com.springbootweb.demo01.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootweb.demo01.bean.Customer;
import com.springbootweb.demo01.mapper.CustomerMapper;
import com.springbootweb.demo01.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService{

}
