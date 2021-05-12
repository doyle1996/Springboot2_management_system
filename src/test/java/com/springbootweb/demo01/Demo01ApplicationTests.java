package com.springbootweb.demo01;


import com.springbootweb.demo01.bean.City;
import com.springbootweb.demo01.bean.Customer;
import com.springbootweb.demo01.bean.Good;
import com.springbootweb.demo01.bean.User;
import com.springbootweb.demo01.mapper.CityMapper;
import com.springbootweb.demo01.mapper.CustomerMapper;
import com.springbootweb.demo01.mapper.GoodMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@SpringBootTest
class Demo01ApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from test.user", long.class);
        log.info("当前记录总数：{}", aLong);
    }

    @Autowired
    CityMapper cityMapper;
    @Test
    void TestUserMapper(){


        City city = cityMapper.selectById(1L);
        log.info("用户信息:{}",city);

    }

  @Autowired
    GoodMapper goodMapper;
    @Test
    void TestGoodMapper(){
        Good good = goodMapper.selectById(1L);
        log.info("good :{}",good);
    }


    @Autowired
    StringRedisTemplate redisTemplate;


    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Test
    void testRedis(){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();

        operations.set("1","doyle");

        String hello = operations.get("hello");
        System.out.println(hello);

        System.out.println(redisConnectionFactory.getClass());
    }


}
