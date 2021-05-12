package com.springbootweb.demo01.controller;

import com.springbootweb.demo01.bean.City;
import com.springbootweb.demo01.bean.User;
import com.springbootweb.demo01.bean.Usr;
import com.springbootweb.demo01.service.UsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.StreamInfo;


import javax.servlet.http.HttpSession;

@Controller
public class indexController {

    @Autowired
    StringRedisTemplate redisTemplate;


    @GetMapping(value = {"/", "/login"})
    public String login() {
        return "login";
    }

    //登录成功 重新定向到main.html
    @PostMapping("/login")
    public String main(User user, HttpSession httpSession, Model model) {
        if (StringUtils.hasLength(user.getUsername()) &&
                "123456".equals(user.getPassword())) {
            httpSession.setAttribute("loginuser", user);
            return "redirect:/main";
        } else {
            model.addAttribute("msg", "账号密码错误");
            return "login";
        }
    }

    ;
    @GetMapping("index_alt")
    public String index_alt(HttpSession session, Model model) {
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        String s1 = opsForValue.get("/main.html");
        String s=opsForValue.get("/index_alt");
        model.addAttribute("mainCount",s1);
        model.addAttribute("indexCount",s);
        return "index_alt";


    }

    //去main页面
    @GetMapping("/main")
    public String mainPage() {





        return "main";
    }


    @Autowired
    UsrService usrService;

    @ResponseBody
    @GetMapping("/usr")
    public Usr getUsr(@RequestParam("id") Integer id) {
        return usrService.getUsr(id);
    }


}
