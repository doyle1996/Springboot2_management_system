package com.springbootweb.demo01.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传请求
 */
@Slf4j
@Controller
public class FormTestController {

    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }
   /**
    * @multipart:自动封装上传过来的文件
    * @author Zhang Jingbo
    * @param email
    * @param username
    * @param headImg
    * @param photos
    * @return java.lang.String
    * @date 2021/4/26 8:18 下午
    */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headImg") MultipartFile headImg,
                         @RequestPart("photos") MultipartFile[]photos) throws IOException {
        log.info("上传信息:email={},username={},headImg={},photos={}",email,username,headImg.getSize(),photos.length);

        if(!headImg.isEmpty()){
            String originalFilename = headImg.getOriginalFilename();
            headImg.transferTo(new File("/Users/zhangjingbo/Downloads/tmp/"+originalFilename));
        }
        if(photos.length>0){
            for (MultipartFile photo:photos){
                if(!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("/Users/zhangjingbo/Downloads/tmp/"+originalFilename));
                }
            }

        }
        return "main";
    }

}
