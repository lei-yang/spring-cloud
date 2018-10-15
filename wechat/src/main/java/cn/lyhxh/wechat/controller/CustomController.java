package cn.lyhxh.wechat.controller;

import cn.lyhxh.wechat.dao.custom.CustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Description: 自定义sql查询控制器
 * @Author leiyang_39@163.com
 * @Date 2018/6/28 16:11
 * @Version V3.0
 */
@RestController
@RequestMapping("custom")
public class CustomController {

    @Autowired
    CustomMapper customMapper;

    @GetMapping("query")
    public List<Map> testCustom(String querySql) {
        return customMapper.executeSql(querySql);
    }

}
