package cn.lyhxh.wechat.utils;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * @Description: freemaker工具类
 * @Author leiyang_39@163.com
 * @Date 2018/7/2 15:38
 * @Version V3.0
 */
public class FreeMarkerUtil {

    /**
     * FreeMarker配置
     */
    private static Configuration cfg = new Configuration();

    /**
     * 把模板转换为字符串返回
     *
     * @param temp
     * @param map
     * @return
     */
    public static String temp2Str(String temp, Map<String, Object> map) throws Exception {
        StringTemplateLoader stringLoader = new StringTemplateLoader();
        stringLoader.putTemplate("strTemp", temp);
        cfg.setTemplateLoader(stringLoader);
        try {
            Template template = cfg.getTemplate("strTemp", "utf-8");
            StringWriter writer = new StringWriter();
            try {
                template.process(map, writer);
                return writer.toString();
            } catch (TemplateException e) {
                throw new Exception("模板错误:"+e.getMessage());
            }
        } catch (IOException e) {
            throw new Exception("模板错误:"+e.getMessage());
        }
    }

}
