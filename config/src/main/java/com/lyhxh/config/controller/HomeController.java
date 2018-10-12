package com.lyhxh.config.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc: Home控制器
 * @Date: 2018/10/12 16:56
 * @Author: leiyang@edspay.com
 */
@RestController
public class HomeController {

    @GetMapping("hello")
    public String hello() {
        return "Hello world!";
    }

}
