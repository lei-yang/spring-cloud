package cn.lyhxh.wechat.utils;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @Description: freemarker测试类
 * @Author leiyang_39@163.com
 * @Date 2018/7/2 15:40
 * @Version V3.0
 */
public class FreeMarkerUtilTest {

    @Test
    public void temp2Str() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "起航");
        map.put("sex", "男");
        String ret = null;
        try {
            ret = FreeMarkerUtil.temp2Str("${name} ${sex} 您好吗?", map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(ret);
    }

}