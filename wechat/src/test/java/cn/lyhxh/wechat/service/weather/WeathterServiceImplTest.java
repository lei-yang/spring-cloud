package cn.lyhxh.wechat.service.weather;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description: 天气测试类
 * @Author leiyang_39@163.com
 * @Date 2018/6/8 17:28
 * @Version V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WeathterServiceImplTest {

    @Autowired
    private WeathterService weathterService;

    @Test
    public void testWeather() {
        String city = "杭州";
        String weather = weathterService.getWeather(city);
        System.out.println(weather);
    }

}