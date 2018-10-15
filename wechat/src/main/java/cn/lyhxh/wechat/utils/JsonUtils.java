package cn.lyhxh.wechat.utils;

import me.chanjar.weixin.mp.util.json.WxMpGsonBuilder;

/**
 * @Description: Json工具类
 * @Author leiyang_39@163.com
 * @Date 2018/6/8 14:01
 * @Version V1.0
 */
public class JsonUtils {

    public static String toJson(Object obj) {
        return WxMpGsonBuilder.create().toJson(obj);
    }

}
