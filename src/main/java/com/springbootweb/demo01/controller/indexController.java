package com.springbootweb.demo01.controller;

import com.springbootweb.demo01.bean.City;
import com.springbootweb.demo01.bean.User;
import com.springbootweb.demo01.bean.Usr;
import com.springbootweb.demo01.service.CityService;
import com.springbootweb.demo01.service.UsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;

@Controller
public class indexController {
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
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "账号密码错误");
            return "login";
        }
    }

    //去main页面
    @GetMapping("/main.html")
    public String mainPage() {
        return "main";
    }



    @Autowired
    UsrService usrService;
    @ResponseBody
    @GetMapping("/usr")
    public Usr getUsr(@RequestParam("id") Integer id){
        return usrService.getUsr(id);
    }
//
//    @Autowired
//    CityService cityService;
//    @ResponseBody
//    @GetMapping("/city")
//
//    public City getCityById(@RequestParam("id") Long id){
//        return cityService.getById(id);
//
//    }








}
