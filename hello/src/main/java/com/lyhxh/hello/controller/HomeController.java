package com.lyhxh.hello.controller;

import com.lyhxh.hello.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc: Home控制器
 * @Date: 2018/10/12 16:56
 * @Author: leiyang
 */
@RestController
public class HomeController {

    @Autowired
    HomeService homeService;

    @GetMapping("hello")
    public String hello() {
        return homeService.list();
    }

}
