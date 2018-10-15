package cn.lyhxh.wechat.dao.custom;

import cn.lyhxh.wechat.model.Country;
import cn.lyhxh.wechat.utils.FreeMarkerUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @Description: 自定义sql查询测试
 * @Author leiyang_39@163.com
 * @Date 2018/6/28 16:03
 * @Version V3.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomMapperTest {

    @Autowired
    CustomMapper customMapper;

    @Test
    public void executeSql() {
        String querySql = "SELECT * FROM country WHERE countrycode = 'ZH'";
        List<Map> countryList = customMapper.executeSql(querySql);
        assertTrue(2 == countryList.size());
    }

    @Test
    public void executeParamsSql() {
        Map map = new HashMap();
        String querySql = "SELECT * FROM country WHERE countrycode like concat('%',#{code},'%')";
        // 这里的 sql 对应 XML 中的 ${sql}
        map.put("sql", querySql);
        map.put("code", "ZH");
        List<Map> countryList = customMapper.executeParamsSql(map);
        assertTrue(2 == countryList.size());
    }

    @Test
    public void freemarker() {
        Map map = new HashMap();
        String querySql = "SELECT * FROM country WHERE 1 = 1 <#if code?? && code != ''> AND countrycode like '%${code}%' </#if>";
        map.put("sql", querySql);
        map.put("code", "ZH");
        try {
            String sql = FreeMarkerUtil.temp2Str(querySql, map);
            System.out.println(sql);
            List<Map> countryList = customMapper.executeSql(sql);
            assertTrue(2 == countryList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}