package com.springbootweb.demo01.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springbootweb.demo01.bean.City;
import com.springbootweb.demo01.bean.Good;
import com.springbootweb.demo01.bean.User;
import com.springbootweb.demo01.service.CityService;
import com.springbootweb.demo01.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.Oneway;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {


    @GetMapping("/basic_table")
    public String basic_table() {
        return "table/basic_table";
    }

    @Autowired
    GoodService goodService;

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn", defaultValue = "1") Integer pn,
                             RedirectAttributes ra) {

        goodService.removeById(id);

        ra.addAttribute("pn", pn);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
//        List<User> users = Arrays.asList(new User("zhangsan", "123"),
//                new User("lisi", "123456"),
//                new User("hehe", "123456789"));
//        model.addAttribute("users",users);

        List<Good> list = goodService.list();
        model.addAttribute("good", list);
        //分页查询数据
        Page<Good> goodPage = new Page<>(pn, 500);
        //分页查询结果
        Page<Good> page = goodService.page(goodPage, null);

        long current = page.getCurrent();
        long pages = page.getPages();
        long total = page.getTotal();
        List<Good> records = page.getRecords();
        model.addAttribute("good_page", page);


        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(Model model) {

        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table() {
        return "table/editable_table";
    }

}
