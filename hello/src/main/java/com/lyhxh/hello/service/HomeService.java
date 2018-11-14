package com.lyhxh.hello.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @desc: Home 服务
 * @author: leiyang
 * @date: 2018/11/14 10:05
 */
@Service
public class HomeService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 调用wechat服务
     *
     * HystrixCommand 指定回调方法
     * @return
     */
    @HystrixCommand(fallbackMethod = "homeFallback")
    public String list() {
        return restTemplate.getForEntity("http://WECHAT/hello", String.class).getBody();
    }

    /**
     * 指定回调方法
     *
     * @return
     */
    public String homeFallback() {
        return "Error";
    }

}
